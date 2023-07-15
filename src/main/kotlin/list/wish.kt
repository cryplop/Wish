package list

import java.io.File

class wish {
    companion object {
        fun addWish(user:String, wish:String) {
            val wishlist = File("wishlist/{$user}.out")
            wishlist.appendText(wish)
            wishlist.appendText("\n")
        }
    }
}

