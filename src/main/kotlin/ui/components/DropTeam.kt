package ui.components

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun dropTeam(e:Boolean,onClose:(id:Int)->Unit){
    var expanded by remember { mutableStateOf(false) }
    expanded = e
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(
            content = { Text("Blue") },
            onClick = {
                expanded = false
                onClose(1)
            }
        )
        DropdownMenuItem(
            content = { Text("Yellow") },
            onClick = {
                expanded = false
                onClose(3)
            }
        )
        DropdownMenuItem(
            content = { Text("Green") },
            onClick = {
                expanded = false
                onClose(2)
            }
        )
    }
}