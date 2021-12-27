import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.plugins
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    kotlin("jvm") version "1.6.10"
    application
    alias(libs.plugins.google.protobuf)
}

group = "me.vianney"
version = "1.0-SNAPSHOT"

java.sourceSets["main"].java {
    srcDir("src/main/kotlin")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.grpc.kotlin.stub)
    implementation(libs.grpc.protobuf)
    implementation(libs.grpc.stub)
    implementation(libs.google.protobuf.java.util)
    implementation(libs.google.protobuf.kotlin)
    implementation(libs.kotlin.coroutines)
    runtimeOnly(libs.grpc.netty)
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("com.paperatus.matrix.client.MainKt")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
