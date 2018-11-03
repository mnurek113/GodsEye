package com.code.knab.godseye.sign_up.mvp

import android.content.SharedPreferences

interface SignUpMVP {

    interface View {
        fun signUpSuccessful()
        fun signUpFailed()

    }

    interface Presenter {
        fun save(login: String, password: String, repeatPassword: String, preferences: SharedPreferences)
        fun preferencesGet(preferences: SharedPreferences):SharedPreferences
    }

    interface Model {
        fun checkIfPasswordsAreTheSame(firstPassword: String, secondPassword: String): Boolean
        fun saveUserData(login: String, password: String, repeatPassword: String, preferences: SharedPreferences)

    }
}