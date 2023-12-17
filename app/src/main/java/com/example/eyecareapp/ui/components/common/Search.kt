package com.example.eyecareapp.ui.components.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Search (
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit
){
    Box(
        modifier = modifier
            .width(300.dp)
            .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.extraLarge)
    ) {
        SearchBar(
            query = query,
            onQueryChange = onQueryChange,
            onSearch = {},
            active = false,
            onActiveChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            placeholder = {
                Text(
                    stringResource(id = R.string.search),
                    style = TextStyle(
                        fontSize = 14.sp
                    )
                )
            },
            shape = MaterialTheme.shapes.extraLarge,
            colors = SearchBarDefaults.colors(
                containerColor = Color.White
            ),
            modifier = Modifier.height(60.dp),
        ){}
    }
}
@Preview(showBackground = true)
@Composable
fun SearchPreview() {
    EyeCareAppTheme {
        Search(
            onQueryChange = {},
            query = ""
        )
    }
}