import java.util.Scanner

fun showMenu(menuItems: MutableList<MenuItem>, menuTitle: String) {
    println(menuTitle)
    for (item in menuItems) {
        println("${item.index}. ${item.name}")
    }
    println("Введите пункт меню")
}

fun userCommand(menuItems: MutableList<MenuItem>) {
    val command = Scanner(System.`in`).nextLine().toIntOrNull()
    if (command != null) {
        if (command in 0..menuItems.size) {
            val selectedMenuItem = menuItems.find { it.index == command }
            selectedMenuItem?.action?.invoke()
        } else {
            println("Такого пункта нет. Введите существующий пункт меню")
        }
    } else {
        println("Ошибка ввода! Введите номер пункта")
    }
}