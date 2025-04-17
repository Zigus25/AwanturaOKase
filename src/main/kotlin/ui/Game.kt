package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import data.ActiveQuestion
import data.Teams
import ui.components.answers
import ui.components.questionUI
import ui.components.teamScore

@Composable
fun gameUI(){
    MaterialTheme {
        Column (Modifier.fillMaxSize()) {
            Row (Modifier.fillMaxWidth()) {
                questionUI(ActiveQuestion.activeQuestion.value.question)
            }
            Row {
                if (ActiveQuestion.showAnswer.value) {
                    answers(ActiveQuestion.activeQuestion.value)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(Modifier.fillMaxWidth()) {
                Spacer(Modifier.weight(1f, true))
                Teams.teams.forEach { team ->
                    teamScore(team)
                    Spacer(modifier = Modifier.weight(1f, true))
                }
            }
        }
    }
}