package com.example.challangechapter4

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    lateinit var preftlogin : SharedPreferences
    lateinit var preftRegister : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        preftlogin = requireContext().getSharedPreferences("login", Context.MODE_PRIVATE)
        preftRegister = requireContext().getSharedPreferences("register", Context.MODE_PRIVATE)

        val no = preftRegister.getString("Nomor", "")
        val user = preftRegister.getString("Username", "")
        val pass = preftRegister.getString("Password", "")

        if (preftlogin.contains("nama")){
            Navigation.findNavController(view).navigate(R.id.to_home)
        }

        btn_login.setOnClickListener { 
            val getnama = edt_username.text.toString()
            val password = edt_password.text.toString()

            if(getnama.isEmpty()|| password.isEmpty()){
                Toast.makeText(requireContext(), "Username dan Password Salah", Toast.LENGTH_LONG).show()
            }
            if (getnama == user && password == pass){
                preftlogin.edit().putString("nama", user).apply()
                it.findNavController().navigate(R.id.to_home)
            }
        }
        
        regiter.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.to_register)
        }
    }
}