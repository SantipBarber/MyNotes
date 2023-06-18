package data.remote

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.logging.*

val notesClient = HttpClient(OkHttp) {
    install(Logging)
}