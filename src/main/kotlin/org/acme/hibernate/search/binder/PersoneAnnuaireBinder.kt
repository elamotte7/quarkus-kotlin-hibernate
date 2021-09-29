package org.acme.hibernate.search.binder

import io.quarkus.arc.Unremovable
import org.acme.hibernate.orm.repository.PersonneAnnuaireRepository
import org.hibernate.search.engine.backend.document.DocumentElement
import org.hibernate.search.engine.backend.document.IndexFieldReference
import org.hibernate.search.engine.backend.types.IndexFieldType
import org.hibernate.search.mapper.pojo.bridge.PropertyBridge
import org.hibernate.search.mapper.pojo.bridge.binding.PropertyBindingContext
import org.hibernate.search.mapper.pojo.bridge.mapping.programmatic.PropertyBinder
import org.hibernate.search.mapper.pojo.bridge.runtime.PropertyBridgeWriteContext
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

/**
 * Property binder pour mapper les champs de la personne annuaire
 */
@ApplicationScoped
@Unremovable
class PersoneAnnuaireBinder @Inject constructor(
    private val personneAnnuaireRepository: PersonneAnnuaireRepository
) : PropertyBinder {

    override fun bind(context: PropertyBindingContext) {

        context.dependencies().useRootOnly()

        val stantdardTextType: IndexFieldType<String> = context.typeFactory()
            .asString()
            .analyzer("personne_standard")
            .toIndexFieldType()

        context.bridge(
            String::class.java, Bridge(
                context.indexSchemaElement().field("nom", stantdardTextType).toReference(),
                context.indexSchemaElement().field("prenom", stantdardTextType).toReference(),
                personneAnnuaireRepository
            )
        )
    }

    class Bridge(
        val nomField: IndexFieldReference<String>,
        val prenomField: IndexFieldReference<String>,
        val personneAnnuaireRepository: PersonneAnnuaireRepository
    ) : PropertyBridge<String> {

        override fun write(target: DocumentElement, bridgedElement: String, context: PropertyBridgeWriteContext) {
            val personneannuaireEntity = personneAnnuaireRepository.findById(bridgedElement)
            target.addValue(this.nomField, personneannuaireEntity?.nom)
            target.addValue(this.prenomField, personneannuaireEntity?.prenom)
        }
    }
}

