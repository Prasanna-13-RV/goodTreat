package com.example.goodtreat


import android.os.Bundle
import android.util.Log
import android.util.Log.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.goodtreat.databinding.FragmentRegisterBinding

import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : Fragment() {
    private lateinit var binding : FragmentRegisterBinding
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        binding.loginLink.setOnClickListener {
            it.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }


        binding.signupbutton.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val pass  = binding.passwordInput.text.toString()
            val confirmPass = binding.confirmpasswordInput.text.toString()


            println(email + " " + pass + " " + confirmPass + " credentials")

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener{
                        if (it.isSuccessful) {
                            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                        }
                    }
                }
                else {
                    Toast.makeText(activity , "Password is not matching" , Toast.LENGTH_SHORT).show()
                }
            }else {
                Toast.makeText(activity, "Empty Fields are not allowed", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root

    }
}