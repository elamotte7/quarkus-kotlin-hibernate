package org.acme.hibernate.orm.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import org.acme.hibernate.orm.domain.PersonneAnnuaireEntity
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PersonneAnnuaireRepository : PanacheRepositoryBase<PersonneAnnuaireEntity, String> {
}
