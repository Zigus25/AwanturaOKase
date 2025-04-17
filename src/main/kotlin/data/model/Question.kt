package data.model

data class Question (
    val category: String,
    var question: String,
    val answers: List<String>,
    val correctAnswer: String
)
