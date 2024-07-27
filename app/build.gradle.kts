plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // external plugin
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize") // data transfer
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.sitaram.document"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sitaram.document"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.activity:activity-compose:1.9.1")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.mockito:mockito-core:2.19.0")

    // navigation compose
    implementation("androidx.navigation:navigation-compose:2.7.7") // floating action button bar

    // compose
    implementation("androidx.compose.material:material:1.6.8")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.8")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.8")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.8")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")
    implementation("androidx.lifecycle:lifecycle-common:2.8.4")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    // ViewModel and LiveData for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")

    // tab layout
    implementation("com.google.accompanist:accompanist-pager:0.28.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.28.0")// for indicators

    // api image extract or coil image loading
    implementation("io.coil-kt:coil-compose:2.4.0")

    // coroutines threading
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // defaults icons
    implementation("androidx.compose.material:material-icons-extended-android:1.6.8")

    // splash screen
    implementation("androidx.core:core-splashscreen:1.0.1")

    // retrofit and Api
    implementation("com.github.bumptech.glide:glide:4.15.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.10")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.10")

    // Dependency Injection Dagger hilt and kapt
    implementation("com.google.dagger:hilt-android:2.49")
    implementation("androidx.hilt:hilt-work:1.2.0")
    implementation("androidx.work:work-runtime-ktx:2.9.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation("androidx.hilt:hilt-navigation-fragment:1.2.0")
    kapt("androidx.hilt:hilt-compiler:1.2.0")
    kapt("com.google.dagger:hilt-android-compiler:2.45")
    kapt("com.google.dagger:hilt-compiler:2.45")

    // Room and room pagination
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    implementation("androidx.room:room-paging:2.6.1")
    //noinspection KaptUsageInsteadOfKsp
    kapt("androidx.room:room-compiler:2.6.1")
    // ksp("androidx.room:room-compiler:2.6.1") // alter native kapt

    // lottie
    implementation("com.airbnb.android:lottie-compose:4.0.0")
    implementation("androidx.compose.foundation:foundation:1.6.8")
    implementation("androidx.viewpager2:viewpager2:1.1.0")

    // moshi alternative used for json
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
    //noinspection KaptUsageInsteadOfKsp
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")
}

// kapt supported
kapt {
    correctErrorTypes = true
    useBuildCache = true
}