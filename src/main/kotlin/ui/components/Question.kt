package ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.ActiveQuestion

@Composable
fun questionUI(question:String){
    Card (Modifier.fillMaxWidth().padding(10.dp),backgroundColor = MaterialTheme.colors.primary) {
        Text(
            if (ActiveQuestion.showQuestion.value) {question}else{" "},
            color = MaterialTheme.colors.onPrimary,
            fontSize = 40.sp,
            lineHeight = 58.sp,
            modifier = Modifier.padding(5.dp)
        )
    }
}