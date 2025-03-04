import java.util.Scanner

class ArchiveMenu {
    fun createNewArchive() {
        println("Введите название архива")
        val command = Scanner(System.`in`).nextLine()
        if (command == "") {
            println("Название архива не может быть пустым")
        } else {
            val newNoteList: MutableList<Note> = ArrayList()
            archivesList.add(Archive(command, newNoteList))
        }
    }

    fun showArchive(archive: Archive) {
        val noteMenu = NoteMenu()
        while (!isNoteComplete) {
            val menuItems = noteMenu.createNotesMenu(archive)
            showMenu(menuItems, "---===Заметки архива ${archive.archiveName}===---")
            userCommand(menuItems)
        }
    }

    fun createArchivesMenu(archiveItems: MutableList<Archive>): MutableList<MenuItem> {
        val menuItems = mutableListOf<MenuItem>()
        var i = 0
        menuItems.add(MenuItem(i, "Создать архив") { createNewArchive() })
        for (archiveItem in archiveItems) {
            i++
            menuItems.add(MenuItem(i, archiveItem.archiveName) { showArchive(archiveItem) })
        }
        i++
        menuItems.add(MenuItem(i, "Выход") { isComplete = true })
        return menuItems
    }
}