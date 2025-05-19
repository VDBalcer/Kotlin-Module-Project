import java.util.Scanner

class NoteOptionMenu(val note: Note, noteCommandList : MutableList<String>) : ChoosingMenu<String>(
    "Работа с заметкой \"$note\":",
    noteCommandList
) {
    override fun createEntity() {
        println("Содержимое заметки:")
        println("-".repeat(30)) // Для визуального отделения содержимого
        println(note.content)
        println("-".repeat(30)) // Для визуального отделения содержимого
        Scanner(System.`in`).nextLine()
    }

    override fun openNextScreen(archive: String) {
        println("Данная функция находится в разработке")
    }

    override val creationCommand = "Прочесть заметку"
}