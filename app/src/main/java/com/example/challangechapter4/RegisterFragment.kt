package com.example.challangechapter4

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {

    private lateinit var prefs : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefs = requireActivity().getSharedPreferences("register", Context.MODE_PRIVATE)

        btn_register.setOnClickListener {
            val nomor = edt_nomor.text.toString()
            val username = edt_username.text.toString()
            val email = edt_email.text.toString()
            val pass = edt_password.text.toString()
            val konfir = edt_konfirmasi.text.toString()
            val sp = prefs.edit()
            sp.putString("Nomor", nomor)
            sp.putString("Username", username)
            sp.putString("Email", email)
            sp.putString("Password", pass)
            sp.putString("Konfirmasi", konfir)
            sp.apply()
            Toast.makeText(requireContext(), "Register Berhasil", Toast.LENGTH_LONG).show()
            Navigation.findNavController(view).navigate(R.id.to_login)
        }
    }

}