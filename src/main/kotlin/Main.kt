import eu.vendeli.tgbot.TelegramBot
import kotlinx.coroutines.runBlocking
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.util.*


suspend fun main(){
    val bot = TelegramBot("5347737744:AAG3rIQlFpLpmSCEjo6Ge2MoM03DG6njjU4","controller")
    /**
     * Second parameter is the package in which commands/inputs will be searched.
     */


    bot.handleUpdates()
    // start long-polling listener
}


