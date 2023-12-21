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
fun InputNumber(
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
            isError = !isValidNumber(it)
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
            text = "Input must be numeric",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

fun isValidNumber(input: String): Boolean {
    val numberRegex = Regex("^[0-9]+$")
    return numberRegex.matches(input)
}
