plugins {
    // Applying Android application plugin
    alias(libs.plugins.android.application)
    // Applying Kotlin plugin for Android
    alias(libs.plugins.jetbrains.kotlin.android)
}
/*
Plugins: These are extensions that add specific features or
functionality to a development environment (like Android Studio).
They help manage dependencies and automate tasks like compiling,
testing, and packaging the app.
*/

android {
    // Defining the app's namespace (package name)
    namespace = "com.example.kotlin.mypokedexapp"
    // Setting the compile SDK version (Android SDK version used for compiling the app)
    compileSdk = 34
    /*
    * SDK (Software Development Kit): A collection of tools, libraries, and documentation that developers
    * use to build applications for a specific platform (like Android). It includes compilers, debuggers,
    * and libraries necessary to create and run applications on that platform. The Android SDK, for example,
    * provides everything needed to develop Android apps.
    * */

    defaultConfig {
        // Unique application ID for the app
        applicationId = "com.example.kotlin.mypokedexapp"
        // Minimum Android SDK version the app supports
        minSdk = 21
        // Target Android SDK version
        targetSdk = 34
        // Application version code (used for app updates)
        versionCode = 1
        // Application version name (for display purposes)
        versionName = "1.0"

        // Test instrumentation runner for running UI tests
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        // Configuration for the release build
        release {
            // Disabling code minification (obfuscation) for the release version
            isMinifyEnabled = false

            /*
            * Minification means shrinking the size of the code (by removing unused
            * code and shortening variable names) to make the app smaller and harder
            * to reverse-engineer.
            * */

            // ProGuard configuration files for optimizing and obfuscating the app code
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            /*
            * ProGuard is a tool that is used to optimize and obfuscate your app’s code.
            * It shrinks the code, making it harder for someone to decompile and understand.
            * The method getDefaultProguardFile("proguard-android-optimize.txt") gets the default
            * ProGuard configuration provided by Android, which includes common rules for Android apps.
            * "proguard-rules.pro" is your own custom file, where you can add specific rules to tell
            * ProGuard which parts of your code should not be optimized or obfuscated.
            * */
        }
    }
    compileOptions {
        // Setting Java compatibility for compiling the source code
        sourceCompatibility = JavaVersion.VERSION_1_8
        // Setting Java compatibility for the target code
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        // Setting Kotlin JVM target to version 1.8
        jvmTarget = "1.8"
    }

    buildFeatures {
        // Enabling ViewBinding to easily bind views in the layout to code
        viewBinding = true

        /*
        * ViewBinding is a tool in Android that helps you easily
        * connect the elements you create in a layout (like buttons or text boxes)
        * with your code. Normally, you’d have to write extra code to find each element
        * by its ID (using findViewById()), but ViewBinding does this automatically for you.
        * For example, if you have a button in your layout, ViewBinding creates a special class
        * for you to directly work with that button in your code without writing extra lines to
        * "find" it. It makes your code cleaner and helps avoid mistakes like working with a view
        * that does not exist.
        * */
    }
}

dependencies {
    // Core Android KTX extensions for Kotlin
    implementation(libs.androidx.core.ktx)
    // AndroidX AppCompat library for backward compatibility with older Android versions
    implementation(libs.androidx.appcompat)
    // Material Design components library
    implementation(libs.material)
    implementation(libs.androidx.navigation.fragment)

    // JUnit library for unit testing
    testImplementation(libs.junit)
    // AndroidX JUnit extensions for Android testing
    androidTestImplementation(libs.androidx.junit)
    // Android Espresso library for UI testing
    androidTestImplementation(libs.androidx.espresso.core)

    //Retrofit is used for network calls, with a Gson converter to parse JSON responses from a web API into Java/Kotlin objects
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Gson converter for parsing JSON responses using Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Glide library for image loading and caching
    implementation("com.github.bumptech.glide:glide:4.12.0")
    // Annotation processor for Glide to generate necessary code during compilation
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
    // Glide transformations for applying effects to images
    implementation("jp.wasabeef:glide-transformations:4.3.0")

    // Kotlin Coroutines for handling asynchronous tasks
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")

    // AndroidX Fragment library with Kotlin extensions
    implementation("androidx.fragment:fragment-ktx:1.5.0")
    // AndroidX Activity library with Kotlin extensions
    implementation("androidx.activity:activity-ktx:1.5.0")

    // Data Binding library for connecting UI components with data
    implementation("androidx.databinding:databinding-runtime:7.1.2")

    // ViewModel library for managing UI-related data lifecycle-aware
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    // LiveData library for observing data changes in a lifecycle-aware way
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
}
