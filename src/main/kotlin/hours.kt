
fun hours(): Int {
    val min = timeAgo / (second * second)
    return min
}

fun endingHoursMiddle(): String {
    val end = when (timeAgo / (second * second) % 10) {
        1 -> "час"
        2, 3, 4 -> "часа"
        else -> "часов"
    }
    return end
}

fun endingHours(): String {
    val end = when (timeAgo / (second * second)) {
        in 5..19 -> "часов"
        else -> endingHoursMiddle()
    }
    return end
}