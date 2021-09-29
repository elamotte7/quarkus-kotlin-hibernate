package org.acme.hibernate.orm.domain

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity(name = "ROLE")
@Table(name = "ROLE")
data class RoleEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Version
    var version: Int? = 0,

    @field:NotBlank(message = "Le champ libellé ne doit pas être vide")
    var libelle: String = "",

    @field:NotBlank(message = "Le champ code ne doit pas être vide")
    var code: String = "",

    @Column(columnDefinition = "TEXT")
    var commentaire: String = "",

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    var profils: MutableList<ProfilEntity> = mutableListOf()
) {
    @PreRemove
    fun supprimeAssociation() {
        this.profils.clear()
    }
}
