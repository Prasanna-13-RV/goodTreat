package com.example.goodtreat

import android.opengl.GLES30
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.goodtreat.R
import com.example.goodtreat.databinding.FragmentLoginBinding

import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    private lateinit var firebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.loginLink.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.signupbutton.setOnClickListener {
            val email = binding.emailInputLogin.text.toString()
            val pass  =binding.confirmpasswordInput.text.toString()

            println(email + " " + pass + " " + " credentials")

            if (email.isNotEmpty() && pass.isNotEmpty() ) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener{
                    if (it.isSuccessful) {
                        findNavController().navigate(R.id.action_loginFragment_to_recipeFragment)
                    }
                }
            }else {
                Toast.makeText(activity, "Empty Fields are not allowed", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

}