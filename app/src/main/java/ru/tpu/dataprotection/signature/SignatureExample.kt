package ru.tpu.dataprotection.signature

import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.SecureRandom
import java.security.Signature

class SignatureExample(
    signatureAlgorithm: String = "SHA256WithDSA",
    keyPairAlgorithm: String = "DSA"
) {

    // Создание пары ключей
    private var keyPair: KeyPair = KeyPairGenerator.getInstance(keyPairAlgorithm).generateKeyPair()

    private val signature = Signature.getInstance(signatureAlgorithm)

    // Эл. подпись в виде массива байтов
    private var digitalSignature: ByteArray = byteArrayOf()
    private var data: ByteArray = byteArrayOf()

    // Метод пересоздания пары ключей
    fun refreshKeyPair() {
        keyPair = KeyPairGenerator.getInstance("DSA").generateKeyPair()
    }

    // Метод подписывает строку и возвращает подпись
    // в виде массива байтов
    fun sign(input: String): ByteArray {
        val secureRandom = SecureRandom()
        signature.initSign(keyPair.private, secureRandom)

        data = input.toByteArray(charset("UTF-8"))
        signature.update(data)

        // Возвращаем подпись
        digitalSignature = signature.sign()
        return digitalSignature
    }

    // Проверка подписи
    fun checkSign(): Boolean {
        signature.initVerify(keyPair.public)
        signature.update(data)
        return signature.verify(digitalSignature)
    }

}