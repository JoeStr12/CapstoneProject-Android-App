# Website Screener


## Table of Contents

* [Introduction](#introduction)
* [Features](#features)
* [How to Run the App](#how-to-run-the-app)
* [Project Structure & Key Components](#project-structure--key-components)
* [Technologies Used](#technologies-used)


---

## Introduction

This Android application serves as a basic web screener, allowing users to input a URL and retrieve key information about the webpage, including its title, HTTP response status code, IP address, and the full HTML body. It demonstrates fundamental concepts of Android UI with Jetpack Compose and network communication using Java's `java.net` library.


## Features

* **URL Input:** Simple and intuitive input field for entering website URLs.
* **HTTP Request:** Performs a GET request to the specified URL.
* **Information Extraction:** Extracts and displays:
    * Website Title
    * HTTP Response Status Code
    * IP Address of the host
    * Full HTML Response Body
* **Clean UI:** Utilizes Jetpack Compose for a modern and responsive user interface.
* **Asynchronous Networking:** Uses Kotlin Coroutines to handle network operations without blocking the main UI thread.

## How to Run the App

To run this Android application, you will need **Android Studio Arctic Fox (2020.3.1) or newer** installed on your system.

### Prerequisites

* Android Studio (with Android SDK installed)
* A device (physical or emulator) running Android API Level 21 or higher.

### Steps to Run

1.  **Clone the Repository:**
    Open your terminal or Git Bash and run the following command:
    ```bash
    git clone https://github.com/JoeStr12/CapstoneProject-Android-App.git
    ```

2.  **Open in Android Studio:**
    * Launch Android Studio.
    * Select `Open an existing Android Studio project` or go to `File > Open`.
    * Navigate to the directory where you cloned the repository (`YourRepoName`) and select the project. Android Studio will then import and sync the project.

3.  **Build the Project:**
    * Android Studio should automatically build the project. If not, go to `Build > Make Project` (or press `Ctrl + F9` / `Cmd + F9`).
    * Allow time for Gradle to sync and download all necessary dependencies.

4.  **Run on an Emulator or Device:**
    * Connect an Android device to your computer with USB debugging enabled, or launch an Android Virtual Device (AVD) using the AVD Manager (`Tools > Device Manager`).
    * Select your desired device/emulator from the dropdown menu in the Android Studio toolbar.
    * Click the **Run 'app'** button (green triangle icon) in the toolbar.

    The app should now launch on your selected device or emulator.

## Project Structure & Key Components

This section outlines the main components and architectural choices of the application.

* **`MainActivity.kt`**: The entry point of the Android application.
* **`WebScreenApp` Composable**: Manages the overall UI and navigation using Jetpack Compose.
* **`WebScreenViewModel`**: A ViewModel responsible for holding UI state and handling communication with the data layer (network operations).
* **`UiState.kt`**: Data class representing the current UI state, observed by Composables.
* **Networking Logic**: Implemented using `java.net` classes (`URL`, `HttpURLConnection`, `InputStreamReader`, `BufferedReader`, etc.) for direct control over HTTP requests.
* **Navigation**: Handled by Jetpack Compose Navigation, defining routes for input and output screens.
* **Coroutines**: Used for asynchronous network operations to ensure a responsive UI.

## Technologies Used

* **Kotlin**
* **Jetpack Compose** (for UI)
* **Android Jetpack Navigation Compose**
* **Kotlin Coroutines**
* **`java.net` library** (for networking)
* **Gradle** (for build management)


---
