package ru.tpu.dataprotection.auth

import java.util.*

class AuthExample {

    private val users = mutableMapOf("user" to "1234", "test" to "test")

    fun login(name: String, password: String): String {
        return try {
            if (users.getValue(name) == password) {
                "Authorization: Basic " + Base64.getEncoder()
                    .encodeToString("$name:$password".toByteArray())
            } else {
                "Неправильный пароль."
            }
        } catch (e: NoSuchElementException) {
            "Такого пользователя не существует"
        }
    }

    fun register(name: String, password: String): String {
        return if (users.containsKey(name)) {
            "Такой пользователь уже существует"
        } else {
            users[name] = password
            return "Пользователь успешно зарегистрирован"
        }
    }

}