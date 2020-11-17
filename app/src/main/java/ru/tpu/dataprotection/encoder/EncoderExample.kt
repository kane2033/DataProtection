package ru.tpu.dataprotection.encoder

import java.nio.charset.StandardCharsets
import java.util.*
import javax.crypto.Cipher
import javax.crypto.KeyGenerator

class EncoderExample(private val algorithm: String) {

    private val keyGenerator: KeyGenerator = KeyGenerator.getInstance(algorithm) // Генератор ключа
    private val secretKey = keyGenerator.generateKey() // Генерация ключа шифра

    // Метод шифрования строки
    fun encode(inputStr: String): String {
        // Инициализация шифра
        val cipher: Cipher = Cipher.getInstance(algorithm)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey) // Иниц. шифрования с ключом
        // Возвращаем зашифрованную строку
        return Base64.getEncoder()
            .encodeToString(cipher.doFinal(inputStr.toByteArray(StandardCharsets.UTF_8)))
    }

    // Метод дешифрования строки
    fun decode(encodedString: String): String {
        // Инициализация шифра
        val cipher: Cipher = Cipher.getInstance(algorithm)
        // Включаем режим расшифрования с тем же ключом
        cipher.init(Cipher.DECRYPT_MODE, secretKey) // Иниц. дешифрования с ключом
        // Возвращаем дешифрованную строку
        return String(
            cipher.doFinal(
                Base64.getDecoder().decode(encodedString.toByteArray(StandardCharsets.UTF_8))
            )
        )
    }
}