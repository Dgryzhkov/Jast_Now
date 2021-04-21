const val second = 60

val timeAgo = 3600

fun main() {

    println("был(а) в сети ${minutesHoursDay()} ")
}


fun minutesHoursDay(): String {
    val time = when (timeAgo) {
        in 0..second-1 -> " только что"
        in second..second * second-1 -> "${minutes()} ${endigMinute()} назад"
        in second * second ..24 * second * second-1 -> "${hours()} ${endingHours()} назад"
        in 24 * second * second ..24 * second * second * 2-1 -> "сегодня"
        in 24 * second * second * 2 ..24 * second * second * 3-1 -> "вчера"
        else -> "давно"
    }
    return time
}

