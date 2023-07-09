package com.spbarber.devexperto.data.remote

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*

val notesClient = HttpClient {
    install(Logging)
    install(ContentNegotiation) { json() }
}