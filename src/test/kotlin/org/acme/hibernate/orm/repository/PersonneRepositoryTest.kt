package org.acme.hibernate.orm.repository

import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Test
import javax.inject.Inject
import kotlin.test.assertEquals

@QuarkusTest
class PersonneRepositoryTest {

    @Inject
    private lateinit var personneRepository: PersonneRepository

    @Test
    fun testCherchePersonneParUid(){
        val list = personneRepository.requetePersonneEntityParUid("IDN00010006I").list()
        assertEquals(1, list.size)
    }

    @Test
    fun testCherchePPersonnes(){
        val list = personneRepository.requeteListePersonneEntityPaginee("", 0, 10).list()
        assertEquals(3, list.size)
    }

}