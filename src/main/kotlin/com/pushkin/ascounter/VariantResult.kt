package com.pushkin.ascounter

data class VariantResult(
    val repeats: ArrayList<Int>,
    val total: Int,
    val markCount: Int
) {

    companion object {

        fun build(
            repeats: ArrayList<Int>,
            multipliers: ArrayList<Int>,
            maxMarkCount: Int
        ) =
            VariantResult(repeats, countTotal(repeats, multipliers, maxMarkCount), countMarks(repeats))

        private fun countMarks(repeats: ArrayList<Int>) =
            repeats.fold(0) { prev, current -> prev + current }

        private fun countTotal(
            repeats: ArrayList<Int>,
            multipliers: ArrayList<Int>,
            maxMarkCount: Int
        ) =
            ResultCounter.build(multipliers).countTotal(repeats, multipliers, maxMarkCount)

    }

}