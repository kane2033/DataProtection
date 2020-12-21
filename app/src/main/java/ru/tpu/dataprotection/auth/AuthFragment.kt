package ru.tpu.dataprotection.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.auth_fragment.*
import ru.tpu.dataprotection.R

class AuthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.auth_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val authExample = AuthExample()

        loginButton.setOnClickListener {
            val result = authExample.login(
                userNameInputView.text.toString(),
                passwordInputView.text.toString()
            )
            authResultView.text = result
        }

        registerButton.setOnClickListener {
            val result = authExample.register(
                userNameInputView.text.toString(),
                passwordInputView.text.toString()
            )
            authResultView.text = result
        }
    }
}