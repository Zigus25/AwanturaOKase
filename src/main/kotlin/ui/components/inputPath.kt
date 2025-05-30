package ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.*
import data.model.Team

@Composable
fun inputPath(e:Boolean, onClose:(path:String)->Unit){
    var expanded by remember { mutableStateOf(false) }
    expanded = e
    val value = mutableStateOf("")
    MaterialTheme {
        DropdownMenu(expanded, {  }){
            Box {
                OutlinedTextField(placeholder = { Text("Path to json file") },value = value.value, onValueChange = {
                    value.value = it
                },singleLine = true, modifier = Modifier
                    .onKeyEvent { keyEvent ->
                        if (keyEvent.key != Key.Enter) return@onKeyEvent false
                        if (keyEvent.type == KeyEventType.KeyUp) {
                            onClose(value.value)
                        }
                        true
                    })
            }
        }
    }
}