package ru.tpu.dataprotection.signature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.signature_fragment.*
import ru.tpu.dataprotection.R

class SignatureFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.signature_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val signatureExample = SignatureExample()

        // Делаем подпись
        signButton.setOnClickListener {
            try {
                signResultView.text =
                    signatureExample.sign(stringInputView.text.toString()).toString()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(
                    requireContext(),
                    "Ошибка при попытке подписать строку",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Проверяем подпись
        checkSignButton.setOnClickListener {
            try {
                val result =
                    "Статус проверки подписи: " + signatureExample.checkSign()
                        .toString()
                checkResultView.text = result
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(
                    requireContext(),
                    "Ошибка при попытке проверит ьстроку",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        // Делаем новые ключи
        refreshKeysButton.setOnClickListener {
            signatureExample.refreshKeyPair()
        }
    }
}