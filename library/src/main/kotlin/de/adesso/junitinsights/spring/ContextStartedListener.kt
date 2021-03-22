package de.adesso.junitinsights.spring

import de.adesso.junitinsights.model.Event
import de.adesso.junitinsights.model.EventLog
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.ContextStartedEvent

/**
 * Listens to the Spring ContextRefreshedEvent to register starting of the context
 * This callback is registered to the Spring Context in the BenchmarkContextCustomizerFactory
 * @see BenchmarkContextCustomizerFactory
 */
@Suppress("unused", "UNUSED_PARAMETER")
class ContextStartedListener : ApplicationListener<ContextStartedEvent> {

    /**
     * Logs when a new context is started during testing.
     * @see EventLog
     */
    override fun onApplicationEvent(event: ContextStartedEvent) {
        val activeProfiles = event.applicationContext.environment.activeProfiles
        EventLog.log(Event("context started"))
    }
}
