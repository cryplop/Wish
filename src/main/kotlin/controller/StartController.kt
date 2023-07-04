package controller

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommandHandler
import eu.vendeli.tgbot.annotations.InputHandler
import eu.vendeli.tgbot.api.message
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.internal.ProcessedUpdate
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.util.*


class StartController {
    @CommandHandler(["/start"])
    suspend fun start(update: ProcessedUpdate, bot: TelegramBot, user: User) {
        message("Привет! Для добавление нового пункта в список желаний, просто напиши мне").send(user, bot)
        bot.inputListener.set(user.id, "addWish")
        val urls:String = "jdbc:postgresql://localhost/wish"
        val props = Properties()
        props.setProperty("user", "postgres")
        props.setProperty("password", "1")
        props.setProperty("ssl", "true")
        val conn: Connection = DriverManager.getConnection(urls, props)

        //val url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true"
       // val conn: Connection = DriverManager.getConnection(url)

        val st: Statement = conn.createStatement()
        val rs: ResultSet = st.executeQuery("SELECT * FROM users")
        while (rs.next()) {
            print("Column 1 returned ")
            println(rs.getString(1))
        }
        rs.close()
        st.close()
    }

    @InputHandler(["addWish"])
    suspend fun startAddWish(update: ProcessedUpdate, user: User, bot: TelegramBot) {
        message("Отлично, я добавлю в список желаний: ${update.text}").send(user, bot)
        bot.inputListener.set(user.id, "addWish")
    }

}