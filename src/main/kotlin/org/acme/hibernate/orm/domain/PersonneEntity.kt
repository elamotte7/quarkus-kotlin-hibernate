package org.acme.hibernate.orm.domain

import org.acme.hibernate.search.binder.PersoneAnnuaireBinder
import org.hibernate.search.engine.backend.types.Aggregable
import org.hibernate.search.engine.backend.types.Sortable
import org.hibernate.search.mapper.pojo.bridge.mapping.annotation.PropertyBinderRef
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.PropertyBinding
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity(name = "PERSONNE")
@Table(
    name = "PERSONNE",
    uniqueConstraints =
    [UniqueConstraint(columnNames = ["UID", "OU"])]
)
@Indexed
data class PersonneEntity(
    @Id
    @NotNull
    @NotBlank
    @field:PropertyBinding(binder = PropertyBinderRef(type = PersoneAnnuaireBinder::class))
    var uid: String = "",

    @NotNull
    @NotBlank
    @KeywordField(aggregable = Aggregable.YES, sortable = Sortable.YES)
    var ou: String = "",

    @Column(name = "CN")
    @NotNull
    @NotBlank
    @KeywordField(aggregable = Aggregable.YES, sortable = Sortable.YES)
    var cn: String = "",

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "PERSONNE_PROFIL",
        joinColumns = [JoinColumn(name = "PERSONNE_ID")],
        inverseJoinColumns = [JoinColumn(name = "PROFIL_ID")]
    )
    //@field:PropertyBinding(binder = PropertyBinderRef(type = ProfilBinder::class))
    @IndexedEmbedded
    var profils: MutableList<ProfilEntity> = mutableListOf(),
) {
    @PreRemove
    fun supprimeAssociation() {
        this.profils.clear()
    }
}
