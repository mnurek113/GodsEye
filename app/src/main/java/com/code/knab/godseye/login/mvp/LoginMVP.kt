package com.code.knab.godseye.login.mvp

import android.content.SharedPreferences

interface LoginMVP {

    interface View {
        fun onLoginSuccessful()
        fun onLoginFailed()
    }

    interface Presenter {
        fun logIn(login: String, password: String, sharedPreferences: SharedPreferences)
    }

    interface Model {
        fun logIn(login: String, password: String, sharedPreferences: SharedPreferences): Boolean
    }
}