plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.project.common.navigation.impl"
    compileSdk = BuildVariables.COMPILE_SDK
    defaultConfig {
        minSdk = BuildVariables.MIN_SDK
        targetSdk = BuildVariables.TARGET_SDK
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {}
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":common:navigation:api"))
    implementation(project(":presentation:splash"))
    implementation(project(":presentation:auth"))
    implementation(project(":presentation:home"))
    implementation(project(":presentation:general"))
    implementation(project(":presentation:settings"))
    implementation(project(":common:core"))
    implementation(libs.navigation)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
}