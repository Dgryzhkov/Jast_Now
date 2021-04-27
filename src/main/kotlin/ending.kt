const val HOURS = "час"
const val MINUTES = "минут"
const val ENDING_HOURS_A = "а"
const val ENDING_HOURS_OV = "ов"
const val ENDING_MINUTES_YOU = "ы"
const val ENDING_MINUTE_U = "у"


fun endingMinutes(time: Int): String {
    return when (time / SECOND % 10) {
        0, in 5..9 -> MINUTES
        1 -> if ((time / SECOND) == 11) MINUTES else MINUTES + ENDING_MINUTE_U
        else -> if ((time / (SECOND)) in 12..15) MINUTES else MINUTES + ENDING_MINUTES_YOU
    }
}

fun endingHours(time: Int): String {
    return when (time / (SECOND * SECOND) % 10) {
        0, in 5..9 -> HOURS + ENDING_HOURS_OV
        1 -> if ((time / (SECOND * SECOND)) == 11) HOURS + ENDING_HOURS_OV else HOURS
        else -> if ((time / (SECOND * SECOND)) in 12..15) HOURS + ENDING_HOURS_OV else HOURS + ENDING_HOURS_A
    }
}

fun printEnding(time: Int): String {
    return when {
        time <= SECOND -> "был(а) только что"
        time < SECOND * SECOND -> "был(а) ${time / SECOND} ${endingMinutes(time)} назад"
        time < 24 * SECOND * SECOND -> "был(а) в сети ${time / (SECOND * SECOND)} ${endingHours(time)} назад"
        time < 48 * SECOND * SECOND -> "был(а) сегодня"
        time < 72 * SECOND * SECOND -> "был(а) вчера"
        else -> "был(а) давно"
    }
}
