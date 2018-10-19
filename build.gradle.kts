import org.gradle.api.JavaVersion.*
import org.gradle.api.tasks.testing.logging.TestLogEvent.*
import org.gradle.api.tasks.wrapper.Wrapper.DistributionType
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	java
	kotlin("jvm") version "1.3.0-rc-190"
	id("com.github.ben-manes.versions") version "0.20.0"
}

group = "com.ianbrandt.kotlin"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
	jcenter()
	maven("https://dl.bintray.com/kotlin/kotlin-eap")
}

dependencies {
	val junitVersion = "5.3.1"

	implementation(kotlin("stdlib-jdk8"))
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.30.2")
	testImplementation("org.assertj:assertj-core:3.11.1")
	testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

java {
	sourceCompatibility = VERSION_1_8
	targetCompatibility = VERSION_1_8
}

tasks {

	withType<KotlinCompile> {
		kotlinOptions.jvmTarget = VERSION_1_8.toString()
	}

	getByName<Test>("test") {
		useJUnitPlatform()
		testLogging {
			events(PASSED, SKIPPED, FAILED, STANDARD_OUT, STANDARD_ERROR)
		}
	}

	getByName<Wrapper>("wrapper") {
		gradleVersion = "4.10.2"
		distributionType = DistributionType.ALL
	}
}
