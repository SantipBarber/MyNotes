import Note.*

fun main() {

    // Un set es una lista de elementos únicos
    // Una list no se puede modificar. Es inmutable
    // Una mutableList se puede modificar
    // Un map es una lista de pares clave-valor. Se pueden asignar con la función Pair o bien key to value
    // Una secuencia es una lista de elementos que se pueden procesar de forma secuencial

    /*val emptyList: List<Note> = emptyList()
    val list2 = emptyList + Note(
        title = "Title 6",
        description = "Description 6"
    )
    println(list2)
    list.add(
        Note(
            title = "Title 6",
            description = "Description 6"
        )
    )
    println(list)*/

    // En las listas se pueden añadir aplicar elementos funcionales
    val collectionFiltered = list.filter { it.title.contains('4') }
    println(collectionFiltered) // No muestra los elementos que contienen 4
    val collectionNotFiltered = list.filterNot { it.title.contains('4') }
    println(collectionNotFiltered) // Muestra los elementos que no contienen 4
    // Podemos mapear el filtrado
    val collectionNotFilteredMappedForTitle = list.filterNot { it.title.contains('4') }.map { it.title }
    println(collectionNotFilteredMappedForTitle) // Muestra los títulos que no contienen 4
    // También podemos ordenar las listas por el valor que nos interese
    val collectionNotFilteredSortedByTitleAndMappedByTitle = list
        .filterNot { it.title.contains('4') }
        .sortedBy { it.title }
        .map { it.title }
    println(collectionNotFilteredSortedByTitleAndMappedByTitle) // Muestra los títulos que no contienen 4 ordenados por título


}


val list: MutableList<Note> = mutableListOf(
    Note(
        title = "Title 1",
        description = "Description 1",
        Type.TEXT
    ),
    Note(
        title = "Title 2",
        description = "Description 2",
        Type.AUDIO
    ),
    Note(
        title = "Title 3",
        description = "Description 3",
        Type.TEXT
    ),
    Note(
        title = "Title 4",
        description = "Description 4",
        Type.TEXT
    ),
    Note(
        title = "Title 5",
        description = "Description 5",
        Type.TEXT
    ),
    Note(
        title = "Title 6",
        description = "Description 6",
        Type.AUDIO
    ),
    Note(
        title = "Title 7",
        description = "Description 7",
        Type.TEXT
    ),
    Note(
        title = "Title 8",
        description = "Description 8",
        Type.TEXT
    ),
    Note(
        title = "Title 9",
        description = "Description 9",
        Type.AUDIO
    ),
    Note(
        title = "Title 10",
        description = "Description 10",
        Type.TEXT
    ),
)