import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
	id("org.springframework.boot") version "3.0.6" apply false
	id("io.spring.dependency-management") version "1.1.0" apply false
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22" apply false
}

repositories {
	mavenCentral()
}

subprojects {
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	repositories {
		mavenCentral()
	}

	group = "com.mckulpa.demo.kubernetes"
	java.sourceCompatibility = JavaVersion.VERSION_17

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "17"
		}
	}

	tasks.getByName<BootBuildImage>("bootBuildImage") {
		val dockerUsername = System.getenv("DOCKER_USERNAME") ?: "local"
		imageName.set("$dockerUsername/k8s-demo-${project.name}:${project.version}")
		docker {
			publishRegistry {
				username.set(System.getenv("DOCKER_USERNAME"))
				password.set(System.getenv("DOCKER_PASSWORD"))
			}
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}