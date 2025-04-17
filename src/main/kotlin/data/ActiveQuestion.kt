package data

import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import data.model.Question
import java.io.File

object ActiveQuestion {
    private var questions: List<Question> = listOf()
    private var index = mutableStateOf(0)
    var activeQuestion = mutableStateOf(Question("","", listOf("","","",""),""))
    var showAnswer = mutableStateOf(false)
    var showQuestion = mutableStateOf(false)
    fun nextQuestion() {
        Teams.setBid(0)
        for (i in 1..3) {
            Teams.changeBid(i,500)
        }
        activeQuestion.value = questions[index.value]
        index.value += 1
        activeQuestion.value.question = "${index.value}. ${questions[index.value-1].question}"
        showAnswer.value = false
        showQuestion.value = false
    }
    fun showQuestion() {
        showQuestion.value = true
    }

    fun showAnswer() {
        showAnswer.value = true
    }

    fun import(path:String) {
        questions = convert(path)
        nextQuestion()
    }

    private fun convert(path:String):List<Question>{
        val input:StringBuilder = StringBuilder("")
        val lines = File(path).readLines()
        lines.forEach {
            input.append(it)
        }
        val questions: Array<Question> = Gson().fromJson(input.toString(), Array<Question>::class.java)
        return questions.toList()
    }
}