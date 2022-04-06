package com.example.challangechapter4

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.alert_input.*
import kotlinx.android.synthetic.main.alert_input.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var prefs : SharedPreferences
//    var dbschool : SchoolDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        prefs = requireContext().getSharedPreferences("login", Context.MODE_PRIVATE)

//        val getnama = "Welcome, ${prefs.getString("Username","")}"
//        text_username.text = getnama

//        dbschool = SchoolDatabase.getIntance(requireContext())

        btn_add.setOnClickListener {
            val custum = LayoutInflater.from(requireContext())
                .inflate(R.layout.alert_input, null, false)
            val alert = AlertDialog.Builder(requireContext())
                .setView(custum)
                .create()

            custum.btn_input.setOnClickListener {

            }
            alert.dismiss()
        }

        text_logout.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.to_login)
        }
    }

}
