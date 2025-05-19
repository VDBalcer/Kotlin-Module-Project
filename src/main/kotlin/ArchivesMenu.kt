import java.util.Scanner

class ArchivesMenu(menuTitle: String, itemsList: MutableList<Archive<Note>>) :
    ChoosingMenu<Archive<Note>>(
        menuTitle,
        itemsList
    ) {
    override fun createEntity() {
        var archiveName : String
        var isTitleValid : Boolean
        do {
            println("Введите название нового архива:")
            archiveName = Scanner(System.`in`).nextLine().trim()
            isTitleValid = Archive.isValidTitle(archiveName)
            if (!isTitleValid) println("Введите корректное название архива")
        } while (!isTitleValid)

        this.itemsList.add(Archive(archiveName, mutableListOf()))
    }

    override fun openNextScreen(archive: Archive<Note>) {
        val notesMenu = NotesMenu(archive)
        notesMenu.show()
    }

    override val creationCommand = "Создать архив"
}