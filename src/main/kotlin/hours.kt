fun elevenHours(time: Int): String {
    val end = when ((time / (SECOND * SECOND)) % 100) {
        11 -> HOURS + ENDING_HOURS_OV
        else -> endingHours(time)
    }
    return end
}

fun endingHours(time: Int): String {
    val end = when (time / (SECOND * SECOND) % 10) {
        0, in 12..19 -> HOURS + ENDING_HOURS_OV
        1 -> HOURS
        in 2..4 -> HOURS + ENDING_HOURS_A
        in 5..9 -> HOURS + ENDING_HOURS_OV
        else -> HOURS + ENDING_HOURS_A
    }
    return end
}