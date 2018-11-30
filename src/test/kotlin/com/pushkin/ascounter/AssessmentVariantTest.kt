package com.pushkin.ascounter

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class AssessmentVariantTest {

    private lateinit var assessmentVariant: AssessmentVariant

    @Before
    fun setUp() {
        assessmentVariant = AssessmentVariant(30, 3, arrayListOf(30, 20, 10, 0), 3)
    }

    @Test
    fun evaluate() {
        val result = assessmentVariant.evaluate()
        assertTrue(result.size > 10)
    }

    @Test
    fun variantSequence() {
        assertEquals(
            arrayListOf(3, 3, 3, 3),
            AssessmentVariant.variantSequence(arrayListOf(3, 3, 3, 3), 4).iterator().next()
        )
        assertEquals(
            arrayListOf(3, 3, 3, 2),
            AssessmentVariant.variantSequence(arrayListOf(3, 3, 3, 3), 4).drop(1).iterator().next()
        )
        assertEquals(
            arrayListOf(3, 3, 3, 1),
            AssessmentVariant.variantSequence(arrayListOf(3, 3, 3, 2), 4).drop(1).iterator().next()
        )
        assertEquals(
            arrayListOf(3, 3, 2, 3),
            AssessmentVariant.variantSequence(arrayListOf(3, 3, 3, 0), 4).drop(1).iterator().next()
        )
        assertEquals(
            arrayListOf(3, 0, 2, 3),
            AssessmentVariant.variantSequence(arrayListOf(3, 0, 3, 0), 4).drop(1).iterator().next()
        )
        assertEquals(
            arrayListOf(0, 3, 3, 3),
            AssessmentVariant.variantSequence(arrayListOf(1, 0, 0, 0), 4).drop(1).iterator().next()
        )
        assertFalse(
            AssessmentVariant.variantSequence(arrayListOf(0, 0, 0, 0), 4).drop(1).iterator().hasNext()
        )
    }

    @Test
    fun variantSequenceNext() {
        val variantIterator = AssessmentVariant.variantSequence(arrayListOf(3, 3, 3, 3), 4).iterator()
        assertEquals(
            arrayListOf(3, 3, 3, 3),
            variantIterator.next()
        )
        assertEquals(
            arrayListOf(3, 3, 3, 2),
            variantIterator.next()
        )
    }

    @Test
    fun getLongRepresentation() {
        assertEquals(
            16,
            AssessmentVariant.getLongRepresentation(arrayListOf(1, 0), 16)
        )
    }

    @Test
    fun variantSequenceNext2() {
        val variantIterator = AssessmentVariant.variantSequence(arrayListOf(4, 3, 2, 1), 5).iterator()
        assertEquals(
            arrayListOf(4, 3, 2, 1),
            variantIterator.next()
        )
        assertEquals(
            arrayListOf(4, 3, 2, 0),
            variantIterator.next()
        )
        assertEquals(
            arrayListOf(4, 3, 1, 4),
            variantIterator.next()
        )
        assertEquals(
            arrayListOf(4, 3, 1, 3),
            variantIterator.next()
        )
        assertEquals(
            arrayListOf(4, 3, 1, 2),
            variantIterator.next()
        )
        assertEquals(
            arrayListOf(4, 3, 1, 1),
            variantIterator.next()
        )
        assertEquals(
            arrayListOf(4, 3, 1, 0),
            variantIterator.next()
        )
        assertEquals(
            arrayListOf(4, 3, 0, 4),
            variantIterator.next()
        )
    }

}