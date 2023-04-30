import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import model.Note

class ViewModel {
    private var _state: MutableStateFlow<Note> = MutableStateFlow(
        value = Note("Title 1", "Content 1", Note.Type.TEXT)
    )
    val state: StateFlow<Note> = _state

    suspend fun update() {
        var count = 1
        while (true) {
            delay(2000)
            count++
            _state.value = Note("Title $count", "Content $count", Note.Type.TEXT)
        }
    }
}
fun main(): Unit = runBlocking {

    val viewModel = ViewModel()
    launch{ viewModel.update() }
    viewModel.state.collect(::println)

//    val res = flow {
//        delay(1000)
//        emit(1)
//        delay(1000)
//        emit(2)
//        delay(1000)
//        emit(3)
//        delay(1000)
//        emit(4)
//    }
//        .transform {
//            if (it % 2 == 0) emit("Item $it")
//        }
//    launch {
//        res.collect {
//            println(it)
//        }
//    }

//    val flow1 = flowOf(1,2,3,4)
//    val flow2 = flowOf("a", "b", "c")

    // Enlaza los valores entre secuencias. Si algún valor no tiene pareja no lo enlaza.
    // flow1.zip(flow2) { a, b -> "$a -> $b" }.collect { println(it) }
    // Combine siempre buscar un valor para combinar
//    flow1.combine(flow2) { a, b -> "$a -> $b" }.collect { println(it) }
//    // Valores terminales
//    println(flow1.combine(flow2) { a, b -> "$a -> $b" }.toList())

    // Ojo, flow no permite cambiar su contexto. Pero podemos modificarlo con flowOn()
    // En los flows no debemos utilizar bloques try catch porque estos bloques se ejecutan en el contexto del flow
//    val flow = flow {
//        emit(2)
//        throw IllegalStateException("Exception message")
//    }
//    flow
//        .flowOn(Dispatchers.IO)
//        .catch { cause: Throwable ->  println(cause.message) }
//        .collect { println(it) }

}