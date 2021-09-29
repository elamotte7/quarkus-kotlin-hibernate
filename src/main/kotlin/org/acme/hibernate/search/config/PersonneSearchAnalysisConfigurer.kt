package org.acme.hibernate.search.config

import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurationContext
import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurer
import javax.enterprise.context.Dependent
import javax.inject.Named

@Dependent
@Named("personneAnalysisConfigurer")
class PersonneSearchAnalysisConfigurer : ElasticsearchAnalysisConfigurer {

    override fun configure(context: ElasticsearchAnalysisConfigurationContext) {
        context.analyzer("personne_standard").custom()
            .tokenizer("standard")
            .tokenFilters("elision", "asciifolding", "lowercase")
    }
}
