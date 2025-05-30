package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.ActiveQuestion
import data.Teams
import ui.components.*

@Composable
fun hostUI(){
    MaterialTheme {
        Column (Modifier.fillMaxSize()) {
            Row (Modifier.fillMaxWidth()) {
                Column {
                    Text("Category: "+ActiveQuestion.activeQuestion.value.category, fontSize = 30.sp)
                    questionUI(ActiveQuestion.activeQuestion.value.question)
                }
            }
            Row {
                if (ActiveQuestion.showAnswer.value) {
                    answers(ActiveQuestion.activeQuestion.value)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row {
                Text("Answer: "+ActiveQuestion.activeQuestion.value.correctAnswer)
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(Modifier.fillMaxWidth()) {

                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {
                    ActiveQuestion.nextQuestion()
                }) {
                    Text(text = "Next question", fontSize = 20.sp,color = MaterialTheme.colors.onPrimary)
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {
                    ActiveQuestion.showQuestion()
                }) {
                    Text(text = "Show question", fontSize = 20.sp,color = MaterialTheme.colors.onPrimary)
                }

                Spacer(modifier = Modifier.weight(1f))
                val visG = remember { mutableStateOf(false) }
                val visY = remember { mutableStateOf(false) }
                val visB = remember { mutableStateOf(false) }
                val visBank = remember { mutableStateOf(false) }
                val visBankAmount = remember { mutableStateOf(false) }
                val visPath = remember { mutableStateOf(false) }
                val visHint = remember { mutableStateOf(false) }
                val visHintPrice = remember { mutableStateOf(false) }
                Button(onClick = {
                    visB.value = true
                }) {
                    changeAmount(visB.value, Teams.teams[1]){amount->
                        visB.value=false
                        Teams.changeBid(1, amount)
                    }
                    Text("Team blue", fontSize = 20.sp,color = MaterialTheme.colors.onPrimary)
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {
                    visG.value = true
                }) {
                    changeAmount(visG.value, Teams.teams[2]){amount->
                        visG.value=false
                        Teams.changeBid(2, amount)
                    }
                    Text("Team green", fontSize = 20.sp,color = MaterialTheme.colors.onPrimary)
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {
                    visY.value = true
                }) {
                    changeAmount(visY.value, Teams.teams[3]){amount->
                        visY.value=false
                        Teams.changeBid(3, amount)
                    }
                    Text("Team yellow", fontSize = 20.sp,color = MaterialTheme.colors.onPrimary)
                }

                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {
                    ActiveQuestion.showAnswer()
                }){
                    Text("Answers", fontSize = 20.sp,color = MaterialTheme.colors.onPrimary)
                }

                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {
                    Teams.winner()
                }) {
                    Text("Winner", fontSize = 20.sp,color = MaterialTheme.colors.onPrimary)
                }

                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {
                        visBank.value = true
                    }) {
                    val iD = remember{ mutableStateOf(0) }
                    dropTeam(visBank.value){ id->
                        visBank.value=false
                        visBankAmount.value = true
                        iD.value = id
                    }
                    changeAmount(visBankAmount.value, Teams.teams[iD.value]){ amount->
                        visBankAmount.value=false
                        Teams.setBank(amount,iD.value)
                    }
                    Text("Set bank", fontSize = 20.sp,color = MaterialTheme.colors.onPrimary)
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {
                    visHint.value = true
                }){
                    val iD = remember{ mutableStateOf(0) }
                    dropTeam(visHint.value){id->
                        visHint.value=false
                        visHintPrice.value=true
                        iD.value=id
                    }
                    changeAmount(visHintPrice.value, Teams.teams[iD.value]){amount->
                        visHintPrice.value=false
                        Teams.hint(amount,iD.value)
                    }
                    Text("Buy hint", fontSize = 20.sp,color = MaterialTheme.colors.onPrimary)
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {
                    visPath.value = true
                }){
                    inputPath(visPath.value){ path->
                        ActiveQuestion.import(path)
                        visPath.value=false
                    }
                    Text("Import", fontSize = 20.sp,color = MaterialTheme.colors.onPrimary)
                }
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}