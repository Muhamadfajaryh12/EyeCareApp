package com.example.eyecareapp.ui.components.common

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Search (modifier: Modifier = Modifier){
    SearchBar(
        query="",
        onQueryChange={},
        onSearch={},
        active = false,
        onActiveChange = {},
        leadingIcon={
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        placeholder={
            Text(text = "Search")
        },
        shape = MaterialTheme.shapes.extraLarge,
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        modifier = modifier
            .width(300.dp)

    ){}
}
@Preview(showBackground = true)
@Composable
fun SearchPreview() {
    EyeCareAppTheme {
        Search()
    }
}