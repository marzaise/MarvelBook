package com.marzaise.marvelbook.mapper

import com.marzaise.marvelbook.FakeData.IRON_MAN_REMOTE
import com.marzaise.marvelbook.data.net.models.toDomainModel
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class HeroRemoteTest {
    @Test
    fun `Transform remote hero to domain`() {
        val heroRemote = IRON_MAN_REMOTE
        val hero = heroRemote.toDomainModel()
        assert(hero.equals(heroRemote))
    }
}