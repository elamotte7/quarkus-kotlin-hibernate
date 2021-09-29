package org.acme.hibernate.orm.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.acme.hibernate.orm.domain.RoleEntity
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class RoleRepository : PanacheRepository<RoleEntity> {

    fun requeteRoleEntityParLibelle(libelle: String): RoleEntity? {
        return find("libelle = ?1", libelle).firstResult()
    }

    fun requeteRoleEntityParCode(code: String): RoleEntity? {
        return find("code = ?1", code).firstResult()
    }
}
