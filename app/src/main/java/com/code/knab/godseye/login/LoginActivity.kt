package com.code.knab.godseye.login

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.code.knab.godseye.R
import com.code.knab.godseye.login.mvp.LoginMVP
import com.code.knab.godseye.login.mvp.LoginModel
import com.code.knab.godseye.login.mvp.LoginPresenter
import kotlinx.android.synthetic.main.activity_sign_up.*

class LoginActivity : AppCompatActivity(), LoginMVP.View {

    private var sharedPrefs: SharedPreferences = getPreferences(Context.MODE_PRIVATE)
    private lateinit var editor: SharedPreferences.Editor

    private var loginModel: LoginModel = LoginModel()
    private var loginPresenter: LoginPresenter = LoginPresenter(loginModel, this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        logIn.setOnClickListener {
            login()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    private fun setLogin() {

        editor = sharedPrefs.edit()
        editor.putString("login", "misiek123")
        editor.putString("password", "password")
        editor.apply()

    }

    private fun login() {
        loginPresenter.logIn(loginEditText.text.toString(), passwordEditText.text.toString())
    }

    override fun onLoginSuccessful() {

    }

    override fun onLoginFailed() {

    }
}
