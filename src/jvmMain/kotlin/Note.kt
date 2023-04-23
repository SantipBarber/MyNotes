
data class Note(
    val title: String,
    val description: String,
    val type: Type
) {
    enum class Type {
        TEXT,
        AUDIO
    }
}

fun getNotes(callback: (List<Note>) -> Unit) {
    Thread.sleep(2_000)
    val notes = (1..10).map {
        Note(
            title = "Title $it",
            description = "Description $it",
            if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT
        )
    }
    callback(notes)
}