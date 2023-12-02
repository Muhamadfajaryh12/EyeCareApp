package com.example.eyecareapp.ui.components.common

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun InputWithIcon(
    icon:ImageVector,
    placeholder:String,
    label:String
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = icon, contentDescription = "emailIcon") },
        onValueChange = {
            text = it
        },
        label = { Text(text =  label) },
        placeholder = { Text(text = placeholder) },
        modifier = Modifier
            .width(300.dp)
    )
}
