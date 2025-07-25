plugins {
	java
	id("org.springframework.boot") version "3.5.4-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.cw-spring"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		// 어노테이션 의존성
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	// ~/.gradle/caches/modules-2 (~/.m2/repository 랑 같은 거)
	mavenCentral()
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")

	//redis
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	//implementation ("org.springframework.session:spring-session-data-redis")
	///implementation ("org.springframework.boot:spring-boot-starter-cache")

	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
	archiveFileName.set("app.jar")
}

/**
 * tasks.named<Jar>("jar") {
 * }
*/
