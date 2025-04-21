package ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.Team

@Composable
fun teamScore(team: Team) {
    Column(Modifier.height(180.dp)) {
        if (team.id!=0) {
            Card(Modifier.padding(10.dp).width(300.dp), backgroundColor = team.color) {
                Text(
                    team.bid.toString(),
                    color = team.fontColor,
                    fontSize = 60.sp,
                    lineHeight = 62.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }else{
            Spacer(modifier = Modifier.weight(1f))
        }
        Card(Modifier.padding(10.dp).width(300.dp), backgroundColor = team.color) {
            Text(
                team.amount.toString(),
                color = team.fontColor,
                fontSize = 60.sp,
                lineHeight = 62.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}