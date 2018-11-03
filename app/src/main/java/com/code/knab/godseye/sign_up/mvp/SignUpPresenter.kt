package com.code.knab.godseye.sign_up.mvp

import android.content.SharedPreferences
import com.code.knab.godseye.login.mvp.LoginMVP
import com.code.knab.godseye.login.mvp.LoginModel

class SignUpPresenter(private val model: SignUpModel,
                      private val view: SignUpMVP.View): SignUpMVP.Presenter {


    override fun save(login: String, password: String, repeatPassword: String, preferences: SharedPreferences) {
        if(model.checkIfPasswordsAreTheSame(password,repeatPassword))
        {
            model.saveUserData(login,password,repeatPassword,preferences)
            view.signUpSuccessful()
        }
        else
        {
            view.signUpFailed()
        }
    }


    override fun preferencesGet(preferences: SharedPreferences): SharedPreferences {
        return preferences
    }



}