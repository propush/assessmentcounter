package com.pushkin.ascounter

fun main(args: Array<String>) {
    println("Assessment counter")

    val assessmentVariantFormatter = AssessmentVariantFormatterImpl()

    println(
        assessmentVariantFormatter
            .format(AssessmentVariant(30, 4, arrayListOf(30, 20, 10, 0), 3))
    )

    println(
        assessmentVariantFormatter
            .format(AssessmentVariant(15, 6, arrayListOf(15, 10, 5, 0), 5))
    )

    println(
        assessmentVariantFormatter
            .format(AssessmentVariant(15, 5, arrayListOf(15, 10, 5, 0), 4))
    )

}