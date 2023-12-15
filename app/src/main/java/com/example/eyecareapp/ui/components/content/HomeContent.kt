package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R
import com.example.eyecareapp.data.CategoryGlassData
import com.example.eyecareapp.data.Glass
import com.example.eyecareapp.data.GlassData
import com.example.eyecareapp.ui.components.common.Banner
import com.example.eyecareapp.ui.components.common.CategoryCard
import com.example.eyecareapp.ui.components.common.GlassesCard
import com.example.eyecareapp.ui.components.common.Search
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun HomeContent(
    navigateToDetail:(Int) -> Unit,
    glass:List<Glass>,
    query: String,
    onQueryChange:(String)-> Unit,
    Category:(String)->Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Banner()
        Spacer(modifier = Modifier.padding(5.dp))
        Box(modifier = Modifier){
            Column {
                Text(
                    text = stringResource(id = R.string.category),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                )
                LazyRow {
                    items(CategoryGlassData.category, key = { it.id }) { category ->
                        CategoryCard(title = category.title, photo = category.image, category=Category )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Search(
            onQueryChange = onQueryChange,
            query = query
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = stringResource(id = R.string.list_kacamata),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        )
        Box(modifier = Modifier){
            LazyVerticalGrid(
                columns = GridCells.Adaptive(130.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
            ){
                items(glass, key={it.id}){
                    glass ->
                    GlassesCard(title =glass.title , image =glass.image ,
                        price =glass.price , type = glass.type,
                        modifier = Modifier
                            .clickable { navigateToDetail( glass.id) }
                        )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun prevHomeContent(){
    EyeCareAppTheme {
        HomeContent(
            navigateToDetail = {},
            query = "",
            onQueryChange = {},
            glass = GlassData.glass,
            Category = {}
        )
    }
}