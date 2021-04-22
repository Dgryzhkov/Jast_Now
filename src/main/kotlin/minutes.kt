fun elevenMinutes(time: Int): String {
    val end = when ((time / SECOND) % 100) {
        11 -> MINUTES
        else -> endingMinutes(time)
    }
    return end
}

fun endingMinutes(time: Int): String {
    val end = when (time / SECOND % 10) {
        0, in 12..19 -> MINUTES
        1 -> MINUTES + ENDING_MINUTE_U
        in 2..4 -> MINUTES + ENDING_MINUTES_YOU
        in 5..9 -> MINUTES
        else -> MINUTES + ENDING_MINUTES_YOU
    }
    return end
}