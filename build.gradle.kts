import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

val queryDslVersion = "5.0.0"

plugins {
	id("org.springframework.boot") version "3.0.9"
	id("io.spring.dependency-management") version "1.1.2"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	kotlin("plugin.jpa") version "1.7.22"

	// QueryDSL
	kotlin("kapt") version "1.8.21"

	// JPA support
	id("org.jetbrains.kotlin.plugin.allopen") version "1.7.22" apply false
	id("org.jetbrains.kotlin.plugin.noarg") version "1.7.22" apply false

	// QueryDSL
	id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"

}

allprojects {
	group = "com.pophory"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "17"
		}
	}
}

subprojects {
	apply {
		plugin("org.jetbrains.kotlin.jvm")
		plugin("kotlin-spring")
	}

	dependencies {
		implementation(kotlin("stdlib"))

		// database
		runtimeOnly("com.h2database:h2")
		runtimeOnly("org.postgresql:postgresql")

		// test
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("org.springframework.security:spring-security-test")
		testImplementation("io.kotest:kotest-runner-junit5:5.4.1")
		testImplementation("io.kotest:kotest-assertions-core:5.4.1")
		testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
		testImplementation(platform("org.junit:junit-bom:5.9.1"))
		testImplementation("org.junit.jupiter:junit-jupiter")
	}
}

project(":module-domain") {
	apply {
		plugin("io.spring.dependency-management")
		plugin("org.springframework.boot")
		plugin("org.jetbrains.kotlin.plugin.allopen")
		plugin("org.jetbrains.kotlin.plugin.noarg")
		// QueryDsl
		plugin("kotlin-kapt")
	}

	noArg {
		annotation("jakarta.persistence.Entity")
		annotation("jakarta.persistence.Embeddable")
	}

	allOpen {
		annotation("jakarta.persistence.Entity")
		annotation("jakarta.persistence.MappedSuperclass")
		annotation("jakarta.persistence.Embeddable")
	}


	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("org.springframework.boot:spring-boot-starter-security")
		implementation("com.querydsl:querydsl-jpa:$queryDslVersion:jakarta")
		kapt("com.querydsl:querydsl-apt:$queryDslVersion:jakarta")
		kapt ("jakarta.annotation:jakarta.annotation-api")
		kapt ("jakarta.persistence:jakarta.persistence-api")

	}

	// QueryDSL Qclass path
	kotlin.sourceSets.main {
		setBuildDir("$buildDir")
	}

	val jar: Jar by tasks
	val bootJar: BootJar by tasks

	bootJar.enabled = false
	jar.enabled = true
}

project(":module-api") {
	apply {
		plugin("io.spring.dependency-management")
		plugin("org.springframework.boot")
	}

	dependencies {
		api(project(":module-domain"))
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		runtimeOnly("com.h2database:h2")
	}
}
