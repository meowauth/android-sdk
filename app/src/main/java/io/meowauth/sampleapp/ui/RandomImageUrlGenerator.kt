package io.meowauth.sampleapp.ui

import java.util.*

object RandomImageUrlGenerator {

    fun getRandomImageUrl(): String {
        val uuid = UUID.randomUUID().toString().replace("-", "").lowercase()
        return "https://picsum.photos/700/700?random=$uuid"
    }
}
