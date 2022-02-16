package com.oscarg798.pokedesk.lib.pokemon.util

import com.oscarg798.pokedesk.lib.pokemon.utils.IdExtractor
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class IdExtractorTest {

    private lateinit var extractor: IdExtractor

    @Before
    fun setup() {
        extractor = IdExtractor()
    }

    @Test
    fun `given a url with the right pattern when getIdFromUrl called then it should return the id`() {
        Assert.assertEquals(12, extractor.getIdFromUrl("a/b/c/12/"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `given a url does not ends with the right character when getIdFromUrl called then it should crash`() {
        extractor.getIdFromUrl("a/b/12")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `given an url that onces splited it does not have at least 2 position at the end when getIdFromUrl called then it should crash`() {
        extractor.getIdFromUrl("12")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `given an url does not end up with an id before the split token when getIdFromUrl called then it should crash`() {
        extractor.getIdFromUrl("12")
    }
}
