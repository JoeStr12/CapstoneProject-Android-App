package com.example.webscreenerandroid

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.webscreenerandroid.data.WebScreenViewModel
import com.example.webscreenerandroid.ui.Output_results
import com.example.webscreenerandroid.ui.Ini_web_screen
import kotlinx.coroutines.launch


enum class Screens () {
    inputURLScreen,
    outDataScreen
}

//Contains the comments for code
//@Composable
//fun WebScreenApp(
//    webScreenViewModel: WebScreenViewModel = viewModel(),
//    navController: NavHostController = rememberNavController()
//
//) {
//
//    //gives us access to the UI state but only in read only.
//    val webScreenUiState by webScreenViewModel.uiState.collectAsState()
//
//    NavHost(navController = navController, startDestination = Screens.inputURLScreen.name) {
//        composable(route = Screens.inputURLScreen.name) {
//            Ini_web_screen(
//                webScreenViewModel = webScreenViewModel,
//                webScreenUiState = webScreenUiState, // Pass the state down
//                requestButtonClicked = {
//                    // this will also take a second functions that will run HTTP GET and parse through the response.
//                    // and output that response.
//                    //we implemented the HTTP in the viewmodel
//                    //here we also launch a new coroutine
//                    webScreenViewModel.viewModelScope.launch { // Launch coroutine here
//                        webScreenViewModel.fetchDataFromUrl(webScreenUiState.urlStringData)
//                        navController.navigate(Screens.outDataScreen.name)
//                    }
//                }
//
//            )
//        }
//
//        composable(route = Screens.outDataScreen.name) {
//            //new function here
//            Output_results(webScreenViewModel = webScreenViewModel)
//
//        }
//
//
//    }
//}

//non-comment for clean screen shots
@Composable
fun WebScreenApp(
    webScreenViewModel: WebScreenViewModel = viewModel(),
    navController: NavHostController = rememberNavController()

) {

    val webScreenUiState by webScreenViewModel.uiState.collectAsState()

    NavHost(navController = navController, startDestination = Screens.inputURLScreen.name) {
        composable(route = Screens.inputURLScreen.name) {
            Ini_web_screen(
                webScreenViewModel = webScreenViewModel,
                webScreenUiState = webScreenUiState,
                requestButtonClicked = {

                    webScreenViewModel.viewModelScope.launch {
                        webScreenViewModel.fetchDataFromUrl(webScreenUiState.urlStringData)
                        navController.navigate(Screens.outDataScreen.name)
                    }
                }

            )
        }

        composable(route = Screens.outDataScreen.name) {
            //new function here
            Output_results(webScreenViewModel = webScreenViewModel)

        }


    }
}