package com.code.knab.godseye.login.mvp

import android.content.SharedPreferences

class LoginModel: LoginMVP.Model {

    override fun logIn(login: String, password: String, sharedPreferences: SharedPreferences): Boolean {


        if(login.equals(sharedPreferences.getString("login",null)) && password.equals(sharedPreferences.getString("password",null)))
            return true
        return false
    }
}