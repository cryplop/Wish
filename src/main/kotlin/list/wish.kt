package list

import java.io.File

class wish {
    suspend fun addWish(user:String, wish:String){
        val file = File("wishlist/{$user}.out")

        file.writeText(wish, Charsets.UTF_8)
    }

    companion object {
        fun addWish(user:String, wish:String) {
            val file = File("wishlist/{$user}.out")

            file.writeText(wish, Charsets.UTF_8)
        }
    }
}