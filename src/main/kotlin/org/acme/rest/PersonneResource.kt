package org.acme.rest

import org.acme.hibernate.orm.domain.PersonneEntity
import org.acme.hibernate.orm.repository.PersonneRepository
import javax.inject.Inject
import javax.ws.rs.BeanParam
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam

@Path("personnes")
class PersonneResource @Inject constructor(
    private val personneRepository: PersonneRepository
) {

    @GET
    fun chercherPersonnes(
        @BeanParam pageRequest: PaginationListeRequest
    ): List<PersonneEntity> {
        return personneRepository.requeteListePersonneEntityPaginee(
            pageRequest.query,
            pageRequest.page,
            pageRequest.size
        ).list()
    }

    @GET
    @Path("{uid}")
    fun chercherPersonneParUidEtOu(
        @PathParam("uid") uid: String
    ): List<PersonneEntity> {
        return personneRepository.requetePersonneEntityParUid(uid).list()
    }
}