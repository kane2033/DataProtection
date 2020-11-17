package ru.tpu.dataprotection.hash

import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8

object HashExample {

    fun doHash(input: String, algorithm: String = "SHA-256") =
        MessageDigest.getInstance(algorithm).digest(
            input.toByteArray(UTF_8)
        ).toHex()

    private fun ByteArray.toHex() = joinToString("") { "%02x".format(it) }
}

