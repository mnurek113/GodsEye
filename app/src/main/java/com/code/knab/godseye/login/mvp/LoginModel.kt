package com.code.knab.godseye.login.mvp

import android.content.SharedPreferences

class LoginModel: LoginMVP.Model {

    override fun logIn(login: String, password: String): Boolean {
        if(login.equals("misiek123") && password.equals("password"))
            return true
        return false
    }
}