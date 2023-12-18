import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun PaymentContent() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier) {
            Text(
                text = "Transaksi Bank",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            LazyColumn() {
                items(dummyBank) {
                        bank ->
                    RowPayment(name = bank.name, image = bank.imageResId)
                }
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Column(modifier = Modifier) {
            Text(
                text = "Transaksi Virtual",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            LazyColumn() {
                items(dummyMBank) {
                        bank ->
                    RowPayment(name = bank.name, image = bank.imageResId)
                }
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Column(modifier = Modifier) {
            Text(
                text = "Transaksi Tunai",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            LazyColumn() {
                items(dummyCOD) {
                        bank ->
                    RowPayment(name = bank.name, image = bank.imageResId)
                }
            }
        }
    }
}

@Composable
fun RowPayment(
    name: String,
    image: Int
) {
    var isChecked by remember { mutableStateOf(false) }

    Spacer(modifier = Modifier.padding(3.dp))
    Row(
        modifier = Modifier
            .width(300.dp)
            .padding(5.dp)
            .border(2.dp, Color.Gray) // Border tebal
            .shadow(2.dp, shape = MaterialTheme.shapes.medium) // Shadow
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = name,
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 10.dp)
        )
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .height(20.dp)
                .width(60.dp)
        )
    }
}

data class BankInfo(val name: String, val imageResId: Int)

val dummyBank = listOf(
    BankInfo("Bank Central Asia", R.drawable.bca),
    BankInfo("Bank Tabungan Negara", R.drawable.btn)
)

val dummyMBank = listOf(
    BankInfo("Gopay", R.drawable.gopay),
    BankInfo("OVO", R.drawable.ovo),
    BankInfo("Dana", R.drawable.dana)
)

val dummyCOD = listOf(
    BankInfo("Cash On Delivery", R.drawable.cod)
)

@Preview(showBackground = true)
@Composable
fun PaymentContentPreview() {
    EyeCareAppTheme {
        PaymentContent()
    }
}
