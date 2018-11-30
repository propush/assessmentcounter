package com.pushkin.ascounter

import org.junit.Assert.assertEquals
import org.junit.Test


class VariantResultTest {

    @Test
    fun build() {
        assertEquals(
            VariantResult(arrayListOf(4, 1, 0, 0), 30, 5),
            VariantResult.build(arrayListOf(4, 1, 0, 0), arrayListOf(30, 20, 10, 0), 5)
        )
    }
}