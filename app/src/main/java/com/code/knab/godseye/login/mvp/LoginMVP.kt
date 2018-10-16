package com.code.knab.godseye.login.mvp

interface LoginMVP {

    interface View {
        fun onLoginSuccessful()
        fun onLoginFailed()
    }

    interface Presenter {
        fun logIn(login: String, password: String)
    }

    interface Model {
        fun logIn(login: String, password: String): Boolean
    }
}