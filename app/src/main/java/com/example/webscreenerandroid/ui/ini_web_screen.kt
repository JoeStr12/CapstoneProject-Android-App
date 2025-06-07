package com.example.webscreenerandroid.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.webscreenerandroid.data.WebScreenUiState
import com.example.webscreenerandroid.data.WebScreenViewModel

// code with commments
//@Composable
//fun Ini_web_screen (
//    webScreenViewModel: WebScreenViewModel,
//    webScreenUiState: WebScreenUiState,
//    requestButtonClicked: () -> Unit,
//    modifier: Modifier = Modifier) {

    // var urlString by remember { mutableStateOf("") } // temporary. Moving to variable to viewModel

    //We observe the read only uiState Stateflow, if there is a change we do a recomposition.
    //This the above is done at the local level, this line monitors if there is a data change in the
    // data layer. and recomposites the app to update taht state to the app.
    //val webScreenUiState by webScreenViewModel.uiState.collectAsState() //hoisting this up

//
//    Box(
//        modifier = modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "Web Site Screener",
//                modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
//            )
//
//            Spacer(modifier = Modifier.height(16.dp)) // Add some vertical spacing
//
//            GetURL(
////                //value = urlString, old
//                value = webScreenUiState.urlStringData,
//                onValueChange = { webScreenViewModel.updateURLLink(it) }, // hosting this up
//                Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
//            )
//
//            Spacer(modifier = Modifier.height(16.dp)) // Add some vertical spacing
//
//            Button(
//                onClick = requestButtonClicked,
//                modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally))
//            {
//                Text(text = "Request")
//            }
//        }
//    }
//}


//@Composable
//fun GetURL ( value : String,
//             onValueChange: (String) -> Unit, // parameter for passing a function. A whole function.
//             modifier: Modifier = Modifier) {
//    TextField(
//        value = value,
//        onValueChange = onValueChange, // hoist up, this is our funtions this is equal to onValueChange(string) { ret string }
//        // TextField has a state variable (the input in text box). When inputedtext gets put into the box, it will run tthe onValueChange function.
//        // and it runs onValueChange = { urlString = it }, which updates the state mutable variable. Hence we recompose.
//        modifier = modifier.fillMaxWidth().padding(horizontal = 32.dp) // Make it wider and add padding
//    )
//}

//clean code for screen shots
@Composable
fun Ini_web_screen (
    webScreenViewModel: WebScreenViewModel,
    webScreenUiState: WebScreenUiState,
    requestButtonClicked: () -> Unit,
    modifier: Modifier = Modifier) {

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Web Site Screener",
                modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))
            GetURL(
                value = webScreenUiState.urlStringData,
                onValueChange = { webScreenViewModel.updateURLLink(it) },
                Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = requestButtonClicked,
                modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally))
            {
                Text(text = "Request")
            }
        }
    }
}


@Composable
fun GetURL ( value : String,
             onValueChange: (String) -> Unit,
             modifier: Modifier = Modifier) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth().padding(horizontal = 32.dp)
    )
}