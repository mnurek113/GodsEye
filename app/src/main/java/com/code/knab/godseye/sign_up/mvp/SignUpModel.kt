package com.code.knab.godseye.sign_up.mvp

import android.content.Context
import android.content.SharedPreferences

class SignUpModel: SignUpMVP.Model {


    override fun saveUserData(login: String, password: String, repeatPassword: String, preferences: SharedPreferences) {
        var editor: SharedPreferences.Editor = preferences.edit()
        editor.putString("login", login)
        editor.putString("password", password)
        editor.commit()
    }

    override fun checkIfPasswordsAreTheSame(firstPassword: String, secondPassword: String): Boolean {

        if(firstPassword.equals(secondPassword) == true)
        {
            return true
        }
        return false
    }


}