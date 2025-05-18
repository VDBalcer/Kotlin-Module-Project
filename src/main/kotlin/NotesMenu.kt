import java.util.Scanner

class NotesMenu(archive: Archive<Note>) : ChoosingMenu<Note>(
    "Работа с архивом \"$archive\":",
    archive.notes
) {
    override val creationCommand = "Создать новую запись в архив"

    override fun createEntity() {
        var noteTitle : String
        var isTitleValid : Boolean
        do {
            println("Введите название новой заметки:")
            noteTitle = Scanner(System.`in`).nextLine().trim()
            isTitleValid = Note.isValidTitle(noteTitle)
            if (!isTitleValid) println("Введите корректное название для заметки")
        } while (!isTitleValid)
        var noteContent : String
        var isContentValid : Boolean
        do {
            println("Введите содержимое новой заметки:")
            noteContent = Scanner(System.`in`).nextLine().trim()
            isContentValid = Note.isValidContent(noteContent)
            if (!isContentValid) println("Содержимое заметки не может быть пустым")
        } while (!isContentValid)

        this.itemsList.add(Note(noteContent, noteContent))
    }

    override fun openNextScreen(note: Note) {
        val noteMenu = NoteOptionMenu(note, mutableListOf() )
        noteMenu.show()
    }
}