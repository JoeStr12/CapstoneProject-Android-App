package com.example.webscreenerandroid.data

data class WebScreenUiState(
    val urlStringData: String = "",
    val webpageTitle: String = "",
    val responseCode: Int? = null,
    val ipAddress: String = "",
    val fullHttpResponse: String = ""
)
