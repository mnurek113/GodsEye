package com.code.knab.godseye.login.mvp

import android.content.SharedPreferences

class LoginPresenter(private val model: LoginModel,
                     private val view: LoginMVP.View): LoginMVP.Presenter {

    override fun logIn(login: String, password: String, sharedPreferences: SharedPreferences) {
        if(model.logIn(login, password,sharedPreferences))
            view.onLoginSuccessful()
        else
            view.onLoginFailed()
    }
}