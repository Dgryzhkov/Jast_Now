const val MINUTE = 60
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun ending(
    time: Int,
    one: String,
    few: String,
    many: String
) = "$time " + if (time % 100 in 11..14) many else when (time % 10) {
    1 -> one
    2, 3, 4 -> few
    else -> many
}

fun minutes(minutes: Int) = ending(
    time = minutes,
    one = "минуту",
    few = "минуты",
    many = "минут"
)

fun hours(hours: Int) = ending(
    time = hours,
    one = "час",
    few = "часа",
    many = "часов"
)

fun message(seconds: Int) = when {
    seconds < MINUTE -> "был(а) только что"
    seconds < HOUR -> "был(а) в сети ${minutes(seconds / MINUTE)} назад"
    seconds < DAY -> "был(а) в сети ${hours(seconds / HOUR)} назад"
    seconds < 2 * DAY -> "был(а) сегодня"
    seconds < 3 * DAY -> "был(а) вчера"
    else -> "был(а) давно"
}

/* то что  придумал
const val SECOND = 60
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
*/
