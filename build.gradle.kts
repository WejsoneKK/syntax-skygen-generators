plugins {
    id("java-library")
    alias(libs.plugins.paperweight.userdev)
    alias(libs.plugins.shadow)
    alias(libs.plugins.run.paper)
    alias(libs.plugins.gremlin.gradle)
}

repositories {
    mavenCentral()
    maven("https://repo.okaeri.cloud/releases")
    maven("https://repo.eternalcode.pl/releases")
    maven("https://repo.panda-lang.org/releases")

}

configurations.compileOnly {
    extendsFrom(configurations.runtimeDownload.get())
}

dependencies {
    paperweight.paperDevBundle(libs.versions.paper.api.get())
    implementation(libs.gremlin.runtime)

    implementation(libs.thriump.gui)
    implementation(libs.eternalcommons.adventure)
    implementation(libs.eternalcommons.shared)
    implementation(libs.multification.okaeri)
    implementation(libs.multification.paper)
    implementation(libs.okaeri.configs.serdes.bukkit)
    implementation(libs.okaeri.configs.serdes.adventure)
    implementation(libs.okaeri.configs.serdes.commons)
    implementation(libs.okaeri.configs.serdes.okaeri)
    implementation(libs.okaeri.configs.serdes.okaeri.bukkit)
    implementation(libs.okaeri.configs.snakeyaml)
    implementation(libs.okaeri.placeholders.adventure)
    implementation(libs.okaeri.placeholders.core)
    implementation(libs.okaeri.placeholders.bukkit)
    implementation(libs.litecommands.paper)
    implementation(libs.litecommands.adventure)


}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    runServer {
        minecraftVersion(libs.versions.minecraft.get())
        jvmArgs("-Xms2G", "-Xmx2G", "-Dcom.mojang.eula.agree=true")
    }

    processResources {
        val props = mapOf("version" to version)
        filesMatching("paper-plugin.yml") {
            expand(props)
        }
    }
}
