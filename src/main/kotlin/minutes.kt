
fun minutes(): Int {
    val min = timeAgo / second
    return min
}

fun endingMinuteMiddle(): String {
    val end = when ((timeAgo / second) % 10) {
        1 -> "минуту"
        2, 3, 4 -> "минуты"
        else -> "минут"
    }
    return end
}

fun endigMinute(): String {
    val end = when (timeAgo / second) {
        in 11..19 -> "минут"
        else -> endingMinuteMiddle()
    }
    return end
}