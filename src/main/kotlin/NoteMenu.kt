import java.util.Scanner

class NoteMenu {
    fun createNotesMenu(archive: Archive): MutableList<MenuItem> {
        val menuItems = mutableListOf<MenuItem>()
        var i = 0
        menuItems.add(MenuItem(i, "Создать заметку", { createNewNote(archive) }))
        for (note in archive.notesList) {
            i++
            menuItems.add(MenuItem(i, note.noteName) { showNote(note) })
        }
        i++
        menuItems.add(MenuItem(i, "Выход") { isNoteComplete = true })
        return menuItems
    }

    fun showNote(note: Note) {
        println("\nНазвание заметки: ${note.noteName}")
        println("Заметка: ${note.noteContent}\n")
    }

    fun createNewNote(archive: Archive) {
        println("Введите название заметки")
        val command = Scanner(System.`in`).nextLine()
        if (command == "") {
            println("Название заметки не может быть пустым")
        } else {
            println("Введите заметку")
            val content = Scanner(System.`in`).nextLine()
            archive.notesList.add(Note(command, content))
        }
    }
}
