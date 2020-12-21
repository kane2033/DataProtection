package ru.tpu.dataprotection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.main_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gotoEncodeButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_encoderFragment)
        }

        gotoHashButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_hashFragment)
        }

        gotoSignatureButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_signatureFragment)
        }

        gotoAuthButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_authFragment)
        }
    }
}