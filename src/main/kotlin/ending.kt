const val HOURS = "час"
const val MINUTES = "минут"
const val ENDING_HOURS_A = "а"
const val ENDING_HOURS_OV = "ов"
const val ENDING_MINUTES_YOU = "ы"
const val ENDING_MINUTE_U = "у"

fun minutesOrHours(time: Int): String {
    return if (time in 0..3599) MINUTES else HOURS
}

fun ending(time: Int): String {
    return when (if (minutesOrHours(time) == MINUTES) (time / SECOND % 10) else (time / (SECOND * SECOND) % 10)) {
        0, in 5..9 -> if (minutesOrHours(time) == MINUTES) MINUTES else HOURS + ENDING_HOURS_OV
        1 -> if (minutesOrHours(time) == MINUTES) if (time / SECOND == 11) MINUTES else MINUTES + ENDING_MINUTE_U else
            if (((time / (SECOND * SECOND)) % 100) == 11) HOURS + ENDING_HOURS_OV else HOURS
        else -> if (minutesOrHours(time) == MINUTES) MINUTES + ENDING_MINUTES_YOU else HOURS + ENDING_HOURS_A
    }
}

fun printEnding(time: Int): String {
    return when {
        time <= SECOND -> "был(а) только что"
        time < SECOND * SECOND -> "был(а) ${time / SECOND} ${ending(time)} назад"
        time < 24 * SECOND * SECOND -> "был(а) в сети ${time / (SECOND * SECOND)} ${ending(time)} назад"
        time < 48 * SECOND * SECOND -> "был(а) сегодня"
        time < 72 * SECOND * SECOND -> "был(а) вчера"
        else -> "был(а) давно"
    }
}
