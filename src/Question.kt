enum class Difficulty {
    EASY, MEDIUM, HARD
}

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

class Quiz {
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

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
        }
        question2.let {
            println(it.questionText)
            println(it.answer)
        }
        question3.let {
            println(it.questionText)
            println(it.answer)
        }
    }
}

fun main() {
    Quiz().apply {
        printQuiz()
    }
}