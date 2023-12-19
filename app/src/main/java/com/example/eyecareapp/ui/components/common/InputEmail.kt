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
import androidx.compose.ui.unit.dp

@Composable
fun InputEmail(
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
            isError = !isValidEmail(it)
            if (!isError) {
                onValueChange(it)
            }
        },
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(text = placeholder)
        },
        isError = isError,
        modifier = Modifier.width(300.dp),
        trailingIcon = {
            if(isError) Icon(Icons.Filled.Info,"Error",tint = Color.Red)
        }
    )
    if (isError) {
        Text(
            text = "Email must be correct",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

 fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")
    return emailRegex.matches(email)
}