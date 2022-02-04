import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
}

//subprojects{

    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }

    group = "me.adityakumar"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }



    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }
//}