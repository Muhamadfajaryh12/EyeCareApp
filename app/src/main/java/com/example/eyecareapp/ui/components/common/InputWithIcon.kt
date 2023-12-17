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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun InputWithIcon(
    icon:ImageVector,
    placeholder:String,
    label:String,
    onValueChange:(String)->Unit
) {
    var text by remember { mutableStateOf("") }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = icon, contentDescription = label) },
        onValueChange = {
            text = it
            onValueChange(it)
        },
        label = { Text(text =  label) },
        placeholder = { Text(text = placeholder) },
        visualTransformation = if (label === "Password") PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier
            .width(300.dp)
    )
}
