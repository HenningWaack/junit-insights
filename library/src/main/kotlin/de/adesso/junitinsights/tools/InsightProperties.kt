package de.adesso.junitinsights.tools

import de.adesso.junitinsights.tools.InsightsLogger.log_info
import org.junit.jupiter.api.extension.ExtensionContext

/**
 * Global properties for JUnit Insights.
 * Properties are read from the Gradle or Maven build files at runtime by JUnitCallbacks
 * @see de.adesso.junitinsights.junit.JUnitCallbacks.beforeAll
 */
object InsightProperties {
    internal var isInitialized = false
    var reportpath: String = "build/reports/"
    var enabled: Boolean = false
    var logLevel: InsightsLogLevel = InsightsLogLevel.INFO

    /**
     * Initialize the object with data retrieved from an extension context.
     * @param context Test extension context containing the necessary information
     */
    fun setConfiguration(context: ExtensionContext) {
        if (isInitialized) {
            return
        }

        reportpath = context.getConfigurationParameter("de.adesso.junitinsights.reportpath")
            .orElse("build/reports/")

        enabled = context.getConfigurationParameter("de.adesso.junitinsights.enabled")
            .orElse("false")!!
            .toBoolean()

        logLevel = InsightsLogLevel.valueOf(
            context.getConfigurationParameter("de.adesso.junitinsights.loglevel")
                .orElse("INFO")!!
        )

        log_info("Junit Insights enabled: $enabled")

        isInitialized = true
    }
}
