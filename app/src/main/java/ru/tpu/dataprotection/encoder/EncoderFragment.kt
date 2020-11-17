package ru.tpu.dataprotection.encoder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.encoder_fragment.*
import ru.tpu.dataprotection.R
import java.lang.Exception

class EncoderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.encoder_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Инициализация класса, шифрующего по алгоритму DES
        val encoder = EncoderExample("DES")

        // Шифрование по нажатию кнопки
        encodeButton.setOnClickListener {
            val inputStr = inputView.text.toString()
            try {
                inputView.setText(encoder.encode(inputStr))
            }
            catch (e: Exception) {
                Toast.makeText(context, "Ошибка при попытке шифрования строки",
                    Toast.LENGTH_SHORT).show()
            }
        }

        // Дешифрование по нажатию кнопки
        decodeButton.setOnClickListener {
            val inputStr = inputView.text.toString()
            try {
                inputView.setText(encoder.decode(inputStr))
            }
            catch (e: Exception) {
                Toast.makeText(context, "Ошибка при попытке дешифрования строки",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}