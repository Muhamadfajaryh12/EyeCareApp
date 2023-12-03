
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun ColourBlindContent(
    navigateToResult : ()->Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .clickable { /* Handle back action */ }
                )
                Text(
                    text = "Colour Blind Test",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.colourblindtest),
                contentDescription = "Colour Blind Test Image",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            )

            Spacer(modifier = Modifier.padding(10.dp))
            Column(
                modifier = Modifier
                    .background(
                        color = Color(0xFF4682A9), // Warna biru dongker
                shape = RoundedCornerShape(5.dp) // Rounded corners
            )
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(answerOptions) { option ->
                        AnswerOptionItem(option = option)
                    }
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Button(onClick = { navigateToResult()},
                    modifier=Modifier
                        .width(300.dp)
                        .clip(shape= RoundedCornerShape(5.dp))
                ) {
                    Text(text = "Selesai")
                }
            }
        }
    }
}

@Composable
fun AnswerOptionItem(option: String) {
    Spacer(modifier = Modifier.padding(10.dp))
    Box(
        modifier = Modifier
            .width(300.dp)
            .clip(shape = RoundedCornerShape(5.dp))
            .background(Color.White)
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = option,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

val answerOptions = listOf("Option 1", "Option 2", "Option 3")

@Preview(showBackground = true)
@Composable
fun PreviewColourBlindTestScreen() {
    EyeCareAppTheme {
        ColourBlindContent(navigateToResult = {})
    }
}
