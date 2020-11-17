package ru.tpu.dataprotection.hash

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.hash_fragment.*
import ru.tpu.dataprotection.R
import java.security.NoSuchAlgorithmException

class HashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.hash_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hashButton.setOnClickListener {
            try {
                val result = HashExample.doHash(
                    stringInputView.text.toString(),
                    algorithmInputView.text.toString()
                )
                resultView.text = result
            }
            catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
                Toast.makeText(requireContext(),
                    "Выбран неккоректный алгоритм",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}