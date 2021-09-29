package org.acme.hibernate.orm.domain

import org.acme.hibernate.enums.TypeProfilEnum
import org.hibernate.search.engine.backend.types.Aggregable
import org.hibernate.search.engine.backend.types.Sortable
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity(name = "PROFIL")
@Table(name = "PROFIL")
@Indexed
data class ProfilEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericField(name = "id")
    var id: Long? = null,

    @field:NotBlank(message = "Le champ ne doit pas être vide")
    @KeywordField(aggregable = Aggregable.YES, sortable = Sortable.YES)
    var libelle: String = "",

    @Column(name = "TYPE_PROFIL")
    @Enumerated(EnumType.STRING)
    @KeywordField(aggregable = Aggregable.YES, sortable = Sortable.YES)
    var typeProfil: TypeProfilEnum = TypeProfilEnum.ANONYME,

    @Column(columnDefinition = "TEXT")
    @FullTextField
    var commentaire: String = "",

    @GenericField
    var actif: Boolean = false,

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "PROFIL_ROLE",
        joinColumns = [JoinColumn(name = "PROFIL_ID")],
        inverseJoinColumns = [JoinColumn(name = "ROLE_ID")]
    )
    var roles: MutableList<RoleEntity> = mutableListOf(),

    @ManyToMany(mappedBy = "profils", fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    var personnes: MutableList<PersonneEntity> = mutableListOf(),

    ) {
    @PreRemove
    fun supprimeAssociation() {
        this.roles.clear()
        this.personnes.forEach {
            it.profils.remove(this)
        }
    }
}
