const val SECOND = 60

fun main() {
    val timeAgo = 60 * 11

    println(
        when {
            timeAgo <= SECOND -> "был(а) только что"
            timeAgo < SECOND * SECOND -> "был(а) ${timeAgo / SECOND} ${ending(timeAgo)} назад"
            timeAgo < 24 * SECOND * SECOND -> "был(а) в сети ${timeAgo / (SECOND * SECOND)} ${ending(timeAgo)} назад"
            timeAgo < 48 * SECOND * SECOND -> "был(а) сегодня"
            timeAgo < 72 * SECOND * SECOND -> "был(а) вчера"
            else -> "был(а) давно"
        }
    )
}



