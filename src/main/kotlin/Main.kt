import eu.vendeli.tgbot.TelegramBot
import kotlinx.coroutines.runBlocking

suspend fun main(){
    val bot = TelegramBot("5347737744:AAG3rIQlFpLpmSCEjo6Ge2MoM03DG6njjU4","controller")
    /**
     * Second parameter is the package in which commands/inputs will be searched.
     */

    bot.handleUpdates()

    // start long-polling listener
}


