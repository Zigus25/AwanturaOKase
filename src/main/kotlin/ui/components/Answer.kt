package ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.Question

@Composable
fun answer(answer:String){
    Card (Modifier.fillMaxWidth().padding(10.dp),backgroundColor = MaterialTheme.colors.primary) {
        Text(answer,
            color = MaterialTheme.colors.onPrimary,
            fontSize = 32.sp,
            lineHeight = 46.sp,
            modifier = Modifier.padding(5.dp)
        )
    }
}

@Composable
fun answers(question: Question){
    Column(Modifier.fillMaxWidth().padding(10.dp)) {
        Spacer(modifier = Modifier.height(10.dp))
        question.answers.forEach { answer ->
            answer(answer)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
