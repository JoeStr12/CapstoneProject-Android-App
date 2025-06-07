package com.example.webscreenerandroid.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.webscreenerandroid.data.WebScreenViewModel


//
//Code with comments
//@Composable
//fun Output_results(modifier: Modifier = Modifier, webScreenViewModel: WebScreenViewModel = viewModel()) {
//
//    val webScreenUiState by webScreenViewModel.uiState.collectAsState()
//    //val networkIpAddress by webScreenViewModel.networkIpAddress.collectAsState()
//    val overallScrollState = rememberScrollState()
//
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .padding(top = 50.dp, start = 16.dp, end = 16.dp)
//            .verticalScroll(overallScrollState),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Title Section
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 8.dp),
//            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Text(text = "Webpage Title:")
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(text = webScreenUiState.webpageTitle)
//            }
//        }
//
//        // Response Code Section
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 8.dp),
//            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Text(text = "Response Status Code:")
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(text = webScreenUiState.responseCode?.toString() ?: "N/A")
//            }
//        }
//
//        // IP Address Section
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 8.dp),
//            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Text(text = "IP Address:")
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(text = webScreenUiState.ipAddress)
//            }
//        }
//
//        // Full HTTP Response Section
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight() // Allow this card to take remaining vertical space
//                .padding(bottom = 8.dp),
//            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Text(text = "Full HTTP Response:")
//                Spacer(modifier = Modifier.height(4.dp))
//                // Removed the nested Box with verticalScroll here
//                Text(text = webScreenUiState.fullHttpResponse)
//            }
//        }
//    }
//}



//clean code for screen shots
@Composable
fun Output_results(modifier: Modifier = Modifier, webScreenViewModel: WebScreenViewModel = viewModel()) {

    val webScreenUiState by webScreenViewModel.uiState.collectAsState()
    val overallScrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 50.dp, start = 16.dp, end = 16.dp)
            .verticalScroll(overallScrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Webpage Title:")
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = webScreenUiState.webpageTitle)
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Response Status Code:")
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = webScreenUiState.responseCode?.toString() ?: "N/A")
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "IP Address:")
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = webScreenUiState.ipAddress)
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(bottom = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Full HTTP Response:")
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = webScreenUiState.fullHttpResponse)
            }
        }
    }
}