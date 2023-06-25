package com.spbarber.devexperto
fun getAppTitle() = "My notes - ${getPlatformName()}"

expect fun getPlatformName(): String