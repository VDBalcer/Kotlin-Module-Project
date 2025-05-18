import java.util.Scanner
import javax.swing.text.html.parser.Entity

abstract class ChoosingMenu<T>(
    private val title: String,
    val itemsList: MutableList<T>,
) {
    private var commandList: List<String> = listOf()

    abstract fun createEntity()

    abstract fun openNextScreen(entity: T)

    private fun isCommandValid(command: String): Pair<Boolean, String?> {
        val commandNumber = command.trim().toIntOrNull()
        if (commandNumber == null) return Pair(
            false,
            "Необходимо вводить цифру - номер команды из списка выше"
        )
        if (commandNumber < 0 || commandNumber >= commandList.size) return Pair(
            false,
            "Не существует комнды с таким номером. Пожалуйста, введите номер команды из списка выше"
        )
        return Pair(true, null)
    }

    private fun updateCommandList(): List<String> {
        return listOf("0. $creationCommand") +
                itemsList.mapIndexed { index, item ->
                    "${index + 1}. Открыть \"$item\""
                } +
                listOf("${itemsList.size + 1}. $exitCommand")
    }

    fun show() {
        /*Попадание сюда означает, что либо команды ещё не было вообще, либо была корректная команда,
        а значит списко комманд мог измениться, поэтому оновляем его и выводим повторно*/
        while (true) {
            commandList = updateCommandList()
            println("\n".repeat(2))
            println(title)
            commandList.forEach { println(it) }

            var command: String
            /*Если пользователь не ввел валидной команды, то список команд не изменился,
            а значит выводить его повторно нет смысла.*/
            do {
                print("Введите номер команды: ")
                command = Scanner(System.`in`).nextLine()
                val validation = isCommandValid(command)
                if (validation.second != null && !validation.first) println(validation.second)
            } while (!validation.first)

            when (val commandNumber = command.trim().toInt()) {
                0 -> createEntity()
                in 1..commandList.size - 2 -> openNextScreen(
                    itemsList[commandNumber - 1]
                )

                else -> break
            }
        }

    }

    abstract val creationCommand : String
    companion object {
        const val exitCommand = "Выход"
    }
}