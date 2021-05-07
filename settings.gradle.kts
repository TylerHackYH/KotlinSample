
rootProject.name = "KotlinSample"

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if(requested.id.namespace == "com.squareup") {
                useModule("com.squareup.sqldelight:gradle-plugin:1.5.0")
            }
        }
    }
}