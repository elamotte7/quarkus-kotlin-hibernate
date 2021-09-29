package org.acme.hibernate.orm.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import io.quarkus.panache.common.Sort
import org.acme.hibernate.enums.TypeProfilEnum
import org.acme.hibernate.orm.domain.ProfilEntity
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ProfilRepository : PanacheRepository<ProfilEntity> {

    fun requeteProfilEntityParLibelle(libelle: String): ProfilEntity? {
        return find("libelle = ?1", libelle).firstResult()
    }

    fun requeteProfilEntityParTypeProfil(typeProfil: TypeProfilEnum): List<ProfilEntity>? {
        return find("typeProfil = ?1", typeProfil).list()
    }

    fun requeteProfilEntityParActif(actif: Boolean): List<ProfilEntity>? {
        return find("actif = ?1", Sort.by("typeProfil").and("libelle"), actif).list()
    }

    fun supprimeProfil(id: Long) {
        val profil = findById(id)
        if (profil != null) {
            delete(profil)
        }
    }
}
