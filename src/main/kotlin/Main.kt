
val archivesList: MutableList<Archive> = ArrayList()
var isComplete = false
var isNoteComplete = false

fun main() {
    start()
}

fun start() {
    while (!isComplete) {
        isNoteComplete = false
        val archiveMenu = ArchiveMenu()
        val menuItems = archiveMenu.createArchivesMenu(archivesList)
        showMenu(menuItems, "\n---===Главное меню===---")
        userCommand(menuItems)
    }
}
