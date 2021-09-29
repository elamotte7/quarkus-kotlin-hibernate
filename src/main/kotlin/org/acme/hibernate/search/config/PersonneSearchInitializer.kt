package org.acme.hibernate.search.config

import io.quarkus.runtime.StartupEvent
import org.hibernate.search.mapper.orm.session.SearchSession
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.enterprise.event.Observes
import javax.inject.Inject
import javax.transaction.Transactional
import kotlin.system.measureTimeMillis

/**
 * Automatic re-indexation of database entities on service startup
 */
class PersonneSearchInitializer @Inject constructor(private val searchSession: SearchSession) {

    private val logger: Logger = LoggerFactory.getLogger(PersonneSearchInitializer::class.java)

    @Transactional
    fun onStart(@Observes ev: StartupEvent?) {
        logger.info("Startup : starting mass reindexation of managed database entities")

        measureTimeMillis {
            searchSession.massIndexer().startAndWait()
        }.let { logger.info("""Startup : ended mass reindexation of managed database entities in ${it}ms""") }
    }
}
