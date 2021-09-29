package org.acme.hibernate.orm.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheQuery
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import org.acme.hibernate.orm.domain.PersonneEntity
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PersonneRepository : PanacheRepositoryBase<PersonneEntity, String> {

    fun requetePersonneEntityParUid(uid: String): PanacheQuery<PersonneEntity> {
        return find("uid = ?1", uid)
    }

    fun requetePersonneEntityParUidEtOu(uid: String, ou: String): PanacheQuery<PersonneEntity> {
        return find("uid = ?1 and ou = ?2", uid, ou)
    }

    fun requeteListePersonneEntityPaginee(query: String, pageIndex: Int, pageSize: Int)
            : PanacheQuery<PersonneEntity> = find(query).page(pageIndex, pageSize)

}
