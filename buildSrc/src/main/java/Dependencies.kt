package academy.compose.buildsrc

object Versions {
    val minSdk = 21
    val targetSdk = 29
    val compileSdk = 29
    val kotlin = Deps.Kotlin.version
}

object Deps {

    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.0-alpha02"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21"

    const val junit = "junit:junit:4.12"

    object Kotlin {
        const val version = "1.4.21"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
        const val common = "org.jetbrains.kotlin:kotlin-stdlib-common:$version"
        const val serialization = "org.jetbrains.kotlin:kotlin-serialization:$version"

        private const val serializationVersion = "1.0.0-RC"

        const val serializationRuntimeNative =
            "org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:$serializationVersion"

        const val serializationRuntime =
            "org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion"

        const val kotlinSerialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$serializationVersion"
    }

    object Lifecycle {
        const val lifecycleVersion = "2.2.0"

        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
        const val extensions = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"
        const val common = "androidx.lifecycle:lifecycle-common:$lifecycleVersion"
        const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion"
        const val runtime = "androidx.lifecycle:lifecycle-runtime:$lifecycleVersion"
    }

    object AndroidX {
        const val annotation = "androidx.annotation:annotation:1.1.0"
        const val coreKtx = "androidx.core:core-ktx:1.2.0"
        const val appCompat = "androidx.appcompat:appcompat:1.1.0"

        const val activity = "androidx.activity:activity:1.2.0-alpha07"
        const val activityKtx = "androidx.activity:activity-ktx:1.2.0-alpha07"

        const val junit = "androidx.test.ext:junit:1.1.1"
    }

    object Compose {
        const val version = "1.0.0-alpha09"

        const val core = "androidx.compose.ui:ui:$version"
        const val foundation = "androidx.compose.foundation:foundation:$version"
        const val layout = "androidx.compose.foundation:foundation-layout:$version"
        const val livedata = "androidx.compose.runtime:runtime-livedata:$version"
        const val material = "androidx.compose.material:material:$version"
        const val icons = "androidx.compose.material:material-icons-core:$version"
        const val iconsExtended = "androidx.compose.material:material-icons-extended:$version"
        const val runtime = "androidx.compose.runtime:runtime:$version"
        const val text = "androidx.compose.foundation:foundation-text:$version"
        const val tooling = "androidx.ui:ui-tooling:1.0.0-alpha07"
        const val test = "androidx.ui:ui-test:$version"
    }

    object Google {
        val material = "com.google.android.material:material:1.2.0-alpha03"

        object Hilt {
            private const val hiltVersion = "2.29-alpha"
            val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
            val hilt = "com.google.dagger:hilt-android:$hiltVersion"
            val viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02"
            val compiler = "androidx.hilt:hilt-compiler:1.0.0-alpha02"
            val hiltCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
        }
    }
}