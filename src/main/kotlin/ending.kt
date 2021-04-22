const val HOURS = "час"
const val MINUTES = "минут"
const val ENDING_HOURS_A = "а"
const val ENDING_HOURS_OV = "ов"
const val ENDING_MINUTES_YOU = "ы"
const val ENDING_MINUTE_U = "у"

fun minutesOrHours(time: Int): String {
    val end = when (time) {
        in 0..3599 -> MINUTES
        else -> HOURS
    }
    return end
}

fun ending(time: Int): String {
    val end = if (minutesOrHours(time) == MINUTES) elevenMinutes(time) else elevenHours(time)
    return end
}