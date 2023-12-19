package com.example.eyecareapp.ui.components.common

import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun InputPassword(
    icon: ImageVector,
    placeholder: String,
    label: String,
    onValueChange: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = icon, contentDescription = label) },
        onValueChange = {
            text = it
            if(it.length >= 8){
                onValueChange(it)
            }
            isError = it.length < 8
        },
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeholder)
        },
        visualTransformation = PasswordVisualTransformation(),
        isError = isError,
        modifier = Modifier.width(300.dp),
        trailingIcon = {
            if(isError) Icon(Icons.Filled.Info,"Error",tint = Color.Red)
        }
    )
    if (isError) {
        Text(
            text = "Password must be 8 characters",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}
