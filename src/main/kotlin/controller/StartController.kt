package controller

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommandHandler
import eu.vendeli.tgbot.annotations.InputHandler
import eu.vendeli.tgbot.api.message
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.internal.ProcessedUpdate
import java.io.File

class StartController {
    @CommandHandler(["/start"])
    suspend fun start(update: ProcessedUpdate, bot: TelegramBot, user: User) {
        message("Привет! Для добавление нового пункта в список желаний, просто напиши мне").send(user, bot)
        bot.inputListener.set(user.id, "addWish")
    }

    @CommandHandler(["/wishlist"])
    suspend fun wishlist(update: ProcessedUpdate, bot: TelegramBot, user: User) {
        //проверить наличие файла со списком желаний
        val file = File("wishlist/{${user.username}}.out")
        //если файл найден, то прочитать его содержимое и вывести пользователю
        if (file.exists()) {
            message("Привет! Вот твой список!").send(user, bot)
            for (wish in File("wishlist/{${user.username}}.out").readLines()) {
                //TO DO Добавить нумерацию в списке
                message(wish).send(user, bot)
                //TO DO Для каждого желания добавить кнопку УДАЛИТЬ
            }
        } else {
            message("Список подарков не найден!").send(user, bot)
        }
        bot.inputListener.set(user.id, "addWish")
    }

    @InputHandler(["addWish"])
    suspend fun startAddWish(update: ProcessedUpdate, user: User, bot: TelegramBot) {
        message("Отлично, я добавлю в список желаний: ${update.text}").send(user, bot)
        println(user.username)
        println(update.text)
        val userLogin = user.username.toString()
        val wish = update.text.toString()
        list.wish.addWish(userLogin, wish)
        bot.inputListener.set(user.id, "addWish")
    }

}