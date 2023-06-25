package data.model

sealed interface Filter {
    object All : Filter
   class ByType(val type: Note.Type): Filter
}