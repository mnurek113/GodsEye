package com.code.knab.godseye.login.mvp

import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import com.code.knab.godseye.login.LoginActivity

class LoginModel: LoginMVP.Model {

    override fun logIn(login: String, password: String, sharedPreferences: SharedPreferences): Boolean {




        if(login.equals(sharedPreferences.getString("login",null)) && password.equals(sharedPreferences.getString("password",null)))
            return true
        return false
    }
}