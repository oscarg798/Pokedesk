package com.oscarg798.pokedesk.lib.type

import androidx.compose.ui.graphics.Color
import com.oscarg798.pokedesk.lib.pokemon.model.Pokemon
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TypeRepositoryTest {

    private lateinit var repository: TypeRepository
    private val typeColorLoader: TypeColorLoader = mockk()
    private val type: Pokemon.Type = mockk()

    @Before
    fun setup() {
        repository = TypeRepository(typeColorLoader)
    }

    @Test
    fun `given a type when get type color invoke then it should return the int color`() {
        every { type.id } answers { 3 }
        every { typeColorLoader.getTypeColors() } answers { setOf(TypeColor(3, "0xff77A3FE")) }

        val color = repository.getColorFromType(type)

        assertEquals(Color(0xff77A3FE), Color(color))
    }

    @Test(expected = IllegalStateException::class)
    fun `given a type with an id that does not exists in type colors loaded when get type color invoke then it should crash`() {
        every { type.id } answers { 3 }
        every { typeColorLoader.getTypeColors() } answers { setOf(TypeColor(1, "0xff77A3FE")) }

        repository.getColorFromType(type)
    }
}
