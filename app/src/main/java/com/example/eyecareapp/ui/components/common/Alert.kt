
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun Alert(
    title:String,
    message:String,
    icon:ImageVector,
    tint:Color
) {
    var openDialog by remember { mutableStateOf(true) }

    DisposableEffect(openDialog) {
        onDispose {
            openDialog = false
        }
    }

    if (openDialog) {
        Dialog(onDismissRequest = { openDialog = false }) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    contentColor = Color.Black,
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(imageVector = icon , contentDescription =  message , tint=tint)
                    Text( text = title,
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = tint
                    )
                    Text(
                        text = message,
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                        Button(onClick = {openDialog = false  }, modifier = Modifier.width(100.dp), shape = RoundedCornerShape(5.dp)) {
                                Text(text = "Close")
                        }

                }
            }
        }
    }
}
@Preview
@Composable
fun prevAlert(){
    EyeCareAppTheme {
        Alert(
            title="",
            message ="",
            icon=Icons.Default.Warning,
            tint=Color.Red
        )
    }
}