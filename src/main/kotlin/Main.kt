fun main(args: Array<String>) {
    val mockArchivesList : MutableList<Archive<Note>> = mutableListOf(
        Archive("Тестовый архив 1", mutableListOf(
            Note("Записка 1", "Содержимое записки 1")
        )),
        Archive("Тестовый архив 2", mutableListOf(
            Note("Записка 1", "Содержимое записки 1 из архива 2")
        )),
        Archive("Тестовый архив 4", mutableListOf(
            Note("Записка 1", "Содержимое записки 1 из архива 4"),
            Note("Записка 3", "Содержимое записки 3 из архива 4")
        ))
    )

//    val archivesMenu = ArchivesMenu("Список архивов:", mockArchivesList)

    val archivesList: MutableList<Archive<Note>> = mutableListOf()
    val archivesMenu = ArchivesMenu("Список архивов:", archivesList)
    archivesMenu.show()
}