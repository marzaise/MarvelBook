package com.marzaise.marvelbook.mapper

import com.marzaise.marvelbook.FakeData.IRON_MAN_DOMAIN
import com.marzaise.marvelbook.FakeData.IRON_MAN_LOCAL
import com.marzaise.marvelbook.data.local.toDomainModel
import com.marzaise.marvelbook.data.local.toLocalModel
import org.junit.Test

class HeroLocalTest {
    @Test
    fun `Transform local hero to domain`() {
        val heroLocal = IRON_MAN_LOCAL
        val hero = heroLocal.toDomainModel()
        assert(hero.equals(heroLocal))
    }

    @Test
    fun `Transform domain hero to local`() {
        val heroDomain = IRON_MAN_DOMAIN
        val hero = heroDomain.toLocalModel()
        assert(heroDomain.equals(hero))
    }
}