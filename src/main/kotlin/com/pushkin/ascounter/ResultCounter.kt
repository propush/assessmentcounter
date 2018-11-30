package com.pushkin.ascounter

abstract class ResultCounter {

    companion object {

        fun build(multipliers: ArrayList<Int>): ResultCounter =
            when (multipliers.max()) {
                15 -> ResultCounter15()
                30 -> ResultCounter30()
                else -> throw IllegalArgumentException("Could not determine total counter for $multipliers")
            }

        fun countAverage(repeats: ArrayList<Int>, multipliers: ArrayList<Int>, maxMarkCount: Int) =
            repeats
                .foldIndexed(0) { i, prev, current -> prev + current * multipliers[i] }
                .toDouble() / maxMarkCount.toDouble()

    }

    abstract fun countTotal(
        repeats: ArrayList<Int>,
        multipliers: ArrayList<Int>,
        maxMarkCount: Int
    ): Int

}

class ResultCounter15 : ResultCounter() {

    override fun countTotal(repeats: ArrayList<Int>, multipliers: ArrayList<Int>, maxMarkCount: Int): Int {
        val average = countAverage(repeats, multipliers, maxMarkCount)
        return if (average in 0.0..2.5) {
            0
        } else if (average > 2.5 && average <= 7.5) {
            5
        } else if (average > 7.5 && average <= 12.5) {
            10
        } else if (average > 12.5 && average <= 15) {
            15
        } else {
            average.toInt()
        }
    }

}

class ResultCounter30 : ResultCounter() {

    override fun countTotal(repeats: ArrayList<Int>, multipliers: ArrayList<Int>, maxMarkCount: Int): Int {
        val average = countAverage(repeats, multipliers, maxMarkCount)
        return if (average in 0.0..5.5) {
            0
        } else if (average > 5.5 && average <= 14.5) {
            10
        } else if (average > 14.5 && average <= 25.5) {
            20
        } else if (average > 25.5 && average <= 30) {
            30
        } else {
            average.toInt()
        }
    }

}