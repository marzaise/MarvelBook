package com.marzaise.marvelbook.mapper

import com.marzaise.marvelbook.FakeData.IRON_MAN
import com.marzaise.marvelbook.FakeData.IRON_MAN_LOCAL
import com.marzaise.marvelbook.data.local.toDomainModel
import com.marzaise.marvelbook.data.local.toLocalModel
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class HeroLocalTest {
    @Test
    fun `Transform local hero to domain`() {
        val recipeLocal = IRON_MAN_LOCAL
        val recipe = recipeLocal.toDomainModel()
        assert(recipeLocal.equals(recipe))
    }

    @Test
    fun `Transform domain hero to local`() {
        val recipeDomain = IRON_MAN
        val recipe = recipeDomain.toLocalModel()
        assert(recipeDomain.equals(recipe))
    }
}