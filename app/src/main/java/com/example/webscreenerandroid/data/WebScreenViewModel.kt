package com.example.webscreenerandroid.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.InetAddress


//these are all the libraries I use for the network connectivity
//java.net.URL:
//https://docs.oracle.com/javase/8/docs/api/java/net/URL.html
// https://developer.android.com/reference/java/net/URL

//java.net.HttpURLConnection
//https://docs.oracle.com/javase/8/docs/api/java/net/HttpURLConnection.html
//https://developer.android.com/reference/java/net/HttpURLConnection

//java.net.InetAddress
//https://docs.oracle.com/javase/8/docs/api/java/net/InetAddress.html
//https://developer.android.com/reference/java/net/InetAddress

//java.io.InputStreamReader
// https://docs.oracle.com/javase/8/docs/api/java/io/InputStreamReader.html
// https://developer.android.com/reference/java/io/InputStreamReader

// java.io.BufferedReader
// https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html
// https://developer.android.com/reference/java/io/BufferedReader


// Good Resource to use for Kotlin network connectivity
// https://developer.android.com/develop/connectivity/network-ops/connecting
// https://developer.android.com/reference/java/net/package-summary




//code with comments
//class WebScreenViewModel : ViewModel() {
//
//    private val _uiState = MutableStateFlow(WebScreenUiState())
//    val uiState: StateFlow<WebScreenUiState> = _uiState.asStateFlow()
//
//    //This function is to get Data from the Ui and then store it into the UI state.
//    fun updateURLLink(newUrl: String) {
//        _uiState.update { currentState ->
//            currentState.copy(urlStringData = newUrl)
//        }
//    }
//
//
//    // use suspend function
//    // https://developer.android.com/codelabs/basic-android-kotlin-compose-coroutines-kotlin-playground?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-5-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-coroutines-kotlin-playground#1
//    // essentially this function has ability to pause and run. This is used to be able to run couroutine
//    suspend fun fetchDataFromUrl(url: String) {
//        //We build our corotine, and we change context. We use a specific coroutine, the Dispatcher.IO which is optimized for
//        // UI stuff and is good for network operations. So here we create a corotine for the network operations, to move away from the main thread
//        withContext(Dispatchers.IO) {
//            //we initialize our connection with the HttpURLConnection. We setting the HTTP connection
//            var connection: HttpURLConnection? = null
//
//            try {
//                // we capture URL string and convert it to proper link for API call
//                val urlObject = URL(url)
//
//                //this create the connection with the URL
//                connection = urlObject.openConnection() as HttpURLConnection
//
//                //this sends the client request of GET
//                connection.requestMethod = "GET"
//
//                // here we get the HTTP response code
//                // this code if correct, contains status code and HTML body
//                val responseCode = connection.responseCode
//                // making HTTP request, the HttpConnection provides two streams that we can read data.
//                //inputStrem contains content of successfull response (200-299)
//                val inputStream = if (responseCode in 200..299) {
//                    connection.inputStream
//                } else {
//                    //if not get good response, we consider stream to be ussually a custom error stream
//                    connection.errorStream
//                }
//                // so Http provides two streams, if connection good, then read inputStream
//                // if bad response read from error stream.
//                //
//
//                // The inputStream is in the form of data bytes
//                //this converts the bbytes into character encoding withj InputStreamerReader
//                //BufferedReader is the bufferm which makes the stream more efficiet by reading data in chunks.
//                val reader = BufferedReader(InputStreamReader(inputStream))
//                //this creates the container for our string. This allows for our string to be appended to, and good for looping
//                val responseBody = StringBuilder()
//
//                //we will hold lines
//                var line: String?
//
//                //this loop will read the stream line by line
//                //reader.readLine() reads the next line of text from the buffered reader.
//                // it returns the line as a sstring or null if the end of the stream has been reached.
//                // also { line = it } is a Kotlin scope function.
//                //  It takes the result of reader.readLine() (which is the line read, or null) and assigns it to the line variable.
//                // The loop continues as long as readLine() does not return null.
//                while (reader.readLine().also { line = it } != null) {
//                   // appends the current line to the stringBuilder,
//                    responseBody.append(line)
//                }
//                //closes reader buffer
//                reader.close()
//
//                val title = extractTitle(responseBody.toString())
//
//                val ipAddress = try {
//                    InetAddress.getByName(urlObject.host).hostAddress ?: "N/A"
//                } catch (e: Exception) {
//                    "N/A"
//                }
//
//                //we update the status variale with new content gotten.
//                _uiState.update { currentState ->
//                    currentState.copy(
//                        webpageTitle = title ?: "No Title Found",
//                        responseCode = responseCode,
//                        ipAddress = ipAddress,
//                        fullHttpResponse = responseBody.toString()
//                    )
//                }
//
//            } catch (e: Exception) {
//                _uiState.update { currentState ->
//                    currentState.copy(
//                        webpageTitle = "Error: ${e.message}",
//                        responseCode = null,
//                        ipAddress = "N/A",
//                        fullHttpResponse = "Error: ${e.message}"
//                    )
//                }
//            } finally {
//                connection?.disconnect()
//            }
//        }
//    }
//
//
//    private fun extractTitle(html: String?): String? {
//        html?.let {
//            val startIndex = it.indexOf("<title>")
//            if (startIndex != -1) {
//                val endIndex = it.indexOf("</title>", startIndex + "<title>".length)
//                if (endIndex != -1) {
//                    return it.substring(startIndex + "<title>".length, endIndex).trim()
//                }
//            }
//        }
//        return null
//    }
//}



// clean code without comments for screen shots
class WebScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(WebScreenUiState())
    val uiState: StateFlow<WebScreenUiState> = _uiState.asStateFlow()

    fun updateURLLink(newUrl: String) {
        _uiState.update { currentState ->
            currentState.copy(urlStringData = newUrl)
        }
    }


    suspend fun fetchDataFromUrl(url: String) {
        withContext(Dispatchers.IO) {
            var connection: HttpURLConnection? = null

            try {
                val urlObject = URL(url)
                connection = urlObject.openConnection() as HttpURLConnection

                connection.requestMethod = "GET"

                val responseCode = connection.responseCode
                val inputStream = if (responseCode in 200..299) {
                    connection.inputStream
                } else {
                    connection.errorStream
                }

                val buffReader = BufferedReader(InputStreamReader(inputStream))
                val responseBody = StringBuilder()

                var line: String?

                while (buffReader.readLine().also { line = it } != null) {
                    responseBody.append(line)
                }

                buffReader.close()

                val title = extractTitle(responseBody.toString())

                val ipAddress = try {
                    InetAddress.getByName(urlObject.host).hostAddress ?: "N/A"
                } catch (e: Exception) {
                    "N/A"
                }

                _uiState.update { currentState ->
                    currentState.copy(
                        webpageTitle = title ?: "No Title Found",
                        responseCode = responseCode,
                        ipAddress = ipAddress,
                        fullHttpResponse = responseBody.toString()
                    )
                }

            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(
                        webpageTitle = "Error: ${e.message}",
                        responseCode = null,
                        ipAddress = "N/A",
                        fullHttpResponse = "Error: ${e.message}"
                    )
                }
            } finally {
                connection?.disconnect()
            }
        }
    }


    private fun extractTitle(html: String?): String? {
        html?.let {
            val startIndex = it.indexOf("<title>")
            if (startIndex != -1) {
                val endIndex = it.indexOf("</title>", startIndex + "<title>".length)
                if (endIndex != -1) {
                    return it.substring(startIndex + "<title>".length, endIndex).trim()
                }
            }
        }
        return null
    }
}

