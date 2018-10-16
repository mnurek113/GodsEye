package com.code.knab.godseye

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class LoginActivity : AppCompatActivity() {

    private var sharedPrefs: SharedPreferences = getPreferences(Context.MODE_PRIVATE)
    private lateinit var editor: SharedPreferences.Editor



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setLogin()

        logIn.setOnClickListener {
            login()
        }
    }

    private fun setLogin() {

        editor = sharedPrefs.edit()
        editor.putString("login", "misiek123")
        editor.putString("password", "password")
        editor.apply()

    }

    private fun login() {
        if(loginEditText.text.toString().equals(sharedPrefs.getString("login", null)) &&
                passwordEditText.text.toString().equals(sharedPrefs.getString("password", null)))
            Toast.makeText(this, "good", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "not good", Toast.LENGTH_SHORT).show()
    }
}
