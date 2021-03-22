@file:Suppress("FunctionNaming")

package de.adesso.junitinsights.tools

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object InsightsLogger {

    private val formatter = DateTimeFormatter.ofPattern("YYYY-dd-MM HH:mm:ss.S")

    fun log_info(msg: String) {
        log(InsightsLogLevel.INFO, msg)
    }

    fun log_debug(msg: String) {
        log(InsightsLogLevel.DEBUG, msg)
    }

    fun log(logLevel: InsightsLogLevel, msg: String) {
        println("${LocalDateTime.now().format(formatter)} JunitInsights ${logLevel.name} : $msg")
    }
}

enum class InsightsLogLevel {
    INFO, DEBUG
}
