package org.acme.hibernate.orm.domain

import javax.persistence.Cacheable
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity(name = "ANNUAIRE_PERSONNE")
@Table(name = "ANNUAIRE_PERSONNE")
@Cacheable
data class PersonneAnnuaireEntity(
    @Id
    var uid: String? = null,

    var prenom: String? = null,

    var nom: String? = null,

    var email: String? = null
)
