package controller

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.annotations.CommandHandler
import eu.vendeli.tgbot.annotations.InputHandler
import eu.vendeli.tgbot.api.message
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.internal.ProcessedUpdate

class StartController {
    @CommandHandler(["/start"])
    suspend fun start(update: ProcessedUpdate, bot: TelegramBot, user: User) {
        message("Привет! Для добавление нового пункта в список желаний, просто напиши мне").send(user, bot)
        bot.inputListener.set(user.id, "addWish")
    }

    @InputHandler(["addWish"])
    suspend fun startAddWish(update: ProcessedUpdate, user: User, bot: TelegramBot) {
        message("Отлично, я добавлю в список желаний: ${update.text}").send(user, bot)
        bot.inputListener.set(user.id, "addWish")
    }

}