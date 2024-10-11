package com.example.profiki.Common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBar (
    searchText: String,
    onValueChange: (String) -> Unit,
    clearText: () -> Unit,
    modifier: Modifier
){
    OutlinedTextField(
        textStyle = TextStyle(
            textAlign = TextAlign.Start),
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        value = searchText,
        onValueChange = onValueChange,
        placeholder = {
            Text("Search",
                color = Color.Gray,
                textAlign = TextAlign.Start,
                fontSize = 14.sp
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = Color.Red)
        },
        trailingIcon = {
            if (searchText.isNotEmpty() ){
                IconButton(
                    onClick = clearText
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Close Icon",
                        tint = Color.Red
                    )
                }
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White
        )
    )
}