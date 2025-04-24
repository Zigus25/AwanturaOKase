package data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import data.model.Team

object Teams {

    var teams =
        mutableStateListOf(
            Team(Color.Black,Color.White,0,0,0),
            Team(Color.Cyan,Color.Black, 1, 10000, 0),
            Team(Color.Green,Color.Black, 2, 10000, 0),
            Team(Color.Yellow,Color.Black, 3, 10000, 0)
        )

    fun changeBid(id:Int,amount:Int){
        val teamBid = teams[id].bid
        val teamAmount = teams[id].amount
        if(teamAmount >= (amount - teamBid)) {
            teams[id] = teams[id].copy(amount = teamAmount - (amount - teamBid))
            teams[0] = teams[0].copy(amount = teams[0].amount + (amount - teamBid))
            teams[id] = teams[id].copy(bid = amount)
        }
    }

    fun winner(){
        var id = 0
        var max = 0
        for (i in 1..3){
            if (teams[i].bid>max){
                max = teams[i].bid
                id = i
            }
        }
        teams[id] = teams[id].copy(amount = teams[id].amount + teams[0].amount)
        setBid(0)
        teams[0] = teams[0].copy(amount = 0)
        ActiveQuestion.nextQuestion()
    }

    fun hint(amount:Int,id:Int){
        teams[id] = teams[id].copy(amount = teams[id].amount - amount)
    }

    fun setBank(amount:Int,id:Int){
        teams[id] = teams[id].copy(amount = amount)
    }

    fun setBid(amount:Int){
        for(i in 0..3){
            teams[i] = teams[i].copy(bid = amount)
        }
    }

    fun factoryReset() {
        teams[0]  = Team(Color.Black,Color.White,0,0,0)
        teams[1]  = Team(Color.Cyan,Color.Black, 1, 10000, 0)
        teams[2]  = Team(Color.Green,Color.Black, 2, 10000, 0)
        teams[3]  = Team(Color.Yellow,Color.Black, 3, 10000, 0)
    }
}