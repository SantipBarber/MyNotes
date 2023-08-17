package com.spbarber.devexperto.data.remote

import com.spbarber.devexperto.data.model.Note
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Json

expect val NOTES_URL:String

object NotesRepository {

    suspend fun save(note: Note) = notesClient.post(NOTES_URL) {
        setBody(note)
        contentType(Json)
    }

    suspend fun getAll(): List<Note> = notesClient.request(NOTES_URL).body()

    suspend fun getById(id: Long): Note = notesClient.request("$NOTES_URL/$id").body()

    suspend fun delete(note: Note) = notesClient.delete("$NOTES_URL/${note.id}")

    suspend fun update(note: Note) {
        notesClient.put(NOTES_URL) {
            setBody(note)
            contentType(Json)
        }
    }
}