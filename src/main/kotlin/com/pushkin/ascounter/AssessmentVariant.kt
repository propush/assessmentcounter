package com.pushkin.ascounter

class AssessmentVariant(
    val maxTotalResult: Int,
    val totalRepetitions: Int,
    val multipliers: ArrayList<Int>,
    val maxMarkCount: Int
) {

    companion object {

        fun variantSequence(initialVariant: ArrayList<Int>, totalRepetitions: Int) = sequence {
            if (initialVariant.count { it >= totalRepetitions } > 0) {
                throw IllegalArgumentException("Bad argument $initialVariant for base $totalRepetitions")
            }
            var variant = arrayListOf<Int>()
            variant.addAll(initialVariant)
            yield(variant)
            while (variant.count { it > 0 } > 0) {
                val longRepresentation = getLongRepresentation(variant, totalRepetitions)
                variant = toBase(longRepresentation - 1, totalRepetitions)
                if (variant.size < initialVariant.size) {
                    repeat(initialVariant.size - variant.size) {
                        variant.add(0, 0)
                    }
                }
                yield(variant)
            }
        }

        fun toBase(number: Long, base: Int): ArrayList<Int> {
            val quotient: Long = number / base
            val remainder: Int = (number % base).toInt()
            return if (quotient == 0L) {
                arrayListOf(remainder)
            } else {
                toBase(quotient, base).also { it.addAll(arrayListOf(remainder)) }
            }
        }

        fun getLongRepresentation(list: ArrayList<Int>, fromBase: Int): Long {
            if (list.count { it >= fromBase } > 0) {
                throw IllegalArgumentException("Bad argument $list for base $fromBase")
            }
            return list
                .map { it.toLong() }
                .foldIndexed(0L) { i, prev, current ->
                    prev + current * Math.pow(fromBase.toDouble(), (list.size - 1 - i).toDouble()).toLong()
                }
        }
    }

    val assessment by lazy { evaluate() }

    fun evaluate(): ArrayList<VariantResult> {
        val result = arrayListOf<VariantResult>()
        val initialVariant = arrayListOf<Int>()
        multipliers.forEach { _ -> initialVariant.add(totalRepetitions - 1) }
        val variants = variantSequence(initialVariant, totalRepetitions).iterator()
        while (variants.hasNext()) {
            val currentVariant = variants.next()
            val variantResult = VariantResult.build(currentVariant, multipliers, maxMarkCount)
            if (variantResult.total <= maxTotalResult && variantResult.markCount <= maxMarkCount) {
                result.add(variantResult)
            }
        }
        return result
    }

}