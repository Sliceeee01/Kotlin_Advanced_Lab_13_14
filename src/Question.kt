enum class Difficulty {
    EASY, MEDIUM, HARD
}

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    val question1 = Question<String>(
        questionText = "Речка спятила с ума – По домам пошла сама. ___",
        answer = "водопровод",
        difficulty = Difficulty.MEDIUM
    )

    val question2 = Question<Boolean>(
        questionText = "Небо зелёное. Правда или ложь",
        answer = false,
        difficulty = Difficulty.EASY
    )

    val question3 = Question<Int>(
        questionText = "Сколько дней между полнолуниями?",
        answer = 28,
        difficulty = Difficulty.HARD
    )

    companion object StudentProgress {
        var total: Int = 0
        var answered: Int = 0
    }

    override val progressText: String
        get() = "${StudentProgress.answered} of ${StudentProgress.total} answered"

    override fun printProgressBar() {
        repeat(StudentProgress.answered) { print("█") }
        repeat(StudentProgress.total - StudentProgress.answered) { print("░") }
        println()
        println(progressText)
    }
}

fun main() {
    Quiz.total = 10
    Quiz.answered = 3

    val quiz = Quiz()
    quiz.printProgressBar()
}