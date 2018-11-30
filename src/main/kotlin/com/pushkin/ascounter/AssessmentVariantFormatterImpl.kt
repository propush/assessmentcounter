package com.pushkin.ascounter

class AssessmentVariantFormatterImpl : AssessmentVariantFormatter {

    override fun format(assessmentVariant: AssessmentVariant): String =
        StringBuilder()
            .also { sb ->
                assessmentVariant.multipliers.forEach { sb.append("Mark $it;") }
                sb.append("Total (max ${assessmentVariant.maxTotalResult})")
                sb.appendln()
                assessmentVariant
                    .asessment
                    .forEach {
                        it
                            .repeats
                            .forEach {
                                sb.append("$it;")
                            }
                        sb.append("${it.total}")
                        sb.appendln()
                    }
            }
            .toString()

}