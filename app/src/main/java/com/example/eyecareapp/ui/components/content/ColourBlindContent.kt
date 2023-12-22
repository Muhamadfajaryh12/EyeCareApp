
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.eyecareapp.data.Option
import com.example.eyecareapp.data.Quiz
import com.example.eyecareapp.ui.common.UiState
import com.example.eyecareapp.ui.screen.Test.ColourBlind.ColourBlindViewModel

@Composable
fun ColourBlindContent(
    navigateToResult : (String)->Unit,
    onNextClick:()->Unit,
    quiz: Quiz,
    navigateBack : () -> Unit,
    viewModel : ColourBlindViewModel
) {
    var selectedOption by remember { mutableStateOf(emptyList<String>()) }
    var selected by remember { mutableStateOf<Option?>(null) }
    val LifecycleOwner = LocalLifecycleOwner.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription ="Back",
                    modifier = Modifier
                        .clickable { navigateBack() }
                        .padding(end = 5.dp)
                )
                Text(
                    text = "Colour Blind Test",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(
                model = quiz.image,
                contentDescription = "Colour Blind Test Image",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                LazyColumn(
                    modifier = Modifier
                        .background(
                            color = Color(0xFF4682A9),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(quiz.option) { option ->
                        AnswerOptionItem(
                            option = option.opsi,
                            isSelected = selected == option,
                            onOptionSelected = {
                                selectedOption = selectedOption + option.value
                                selected =  if(selected == option) null else option
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(10.dp))
            if(quiz.id == 10){
                Button(
                    onClick = {
                        viewModel.predict(selectedOption).observe(LifecycleOwner){
                                user-> when(user){
                            is UiState.Loading->{}
                            is UiState.Success->{
                                if(user.data.success == true){
                                    navigateToResult(user.data.predict.toString())
                                }
                            }
                            is UiState.Error->{
                            }
                        }
                        }
                    },modifier= Modifier.width(300.dp)
                ) {
                    Text(text = "Send")
                }
            }else{
                Button(
                    onClick = {
                        if(selected?.opsi != null){
                            onNextClick()
                        }
                    },modifier= Modifier.width(300.dp)
                ) {
                    Text(text = "Next")
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                }
            }
            }
        }
    }
}

@Composable
fun AnswerOptionItem(
    option: String,
    isSelected:Boolean,
    onOptionSelected : ()->Unit) {
    Spacer(modifier = Modifier.padding(5.dp))
    Row(
        modifier = Modifier
            .width(300.dp)
            .shadow(elevation = 1.dp)
            .height(50.dp)
            .padding(5.dp)
            .background(Color.White)
            .clickable { onOptionSelected() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Spacer(modifier = Modifier.padding(start=10.dp))
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .border(1.dp, Color.Black, CircleShape)
                .width(20.dp)
                .height(20.dp)
                .background(if (isSelected) Color(0XFF4682A9) else Color.White)
        )
        Text(text = option,modifier = Modifier.padding(start=10.dp))
    }
    Spacer(modifier = Modifier.padding(5.dp))
}


//@Preview(showBackground = true)
//@Composable
//fun PreviewColourBlindTestScreen() {
//    EyeCareAppTheme {
//        ColourBlindContent(
//            navigateToResult = {},
//            onNextClick = {},
//            answerOptions = Data.data.forEach{
//                test -> test.option
//            }
//        )
//    }
//}
