/*
 * Copyright (c) 2012-2019 Arne Schwabe
 * Distributed under the GNU GPL v2 with additional terms. For full terms see the file doc/LICENSE.txt
 */


buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
    }
}

allprojects {
    extra.apply{
        set("minSdkVersion", 26)
        set("targetSdkVersion", 27)

        when {
            System.getenv("CI") == "true" -> {
                println("I run on Github CI")
                set("ndkSelectedVersion", "21.3.6528147")
            }
            System.getenv("JITPACK") == "true" -> {
                println("I run on JITPACK CI")
                set("ndkSelectedVersion", "21.1.6352462")
            }
            else -> {
                println("I run somewhere")
                set("ndkSelectedVersion", "21.3.6528147")
            }
        }
    }
    repositories {
        google()
        jcenter()
        maven(url = "https://jitpack.io")
    }
}
