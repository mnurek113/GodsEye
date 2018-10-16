package com.code.knab.godseye.login.mvp

class LoginPresenter(private val model: LoginModel,
                     private val view: LoginMVP.View): LoginMVP.Presenter {

    override fun logIn(login: String, password: String) {
        if(model.logIn(login, password))
            view.onLoginSuccessful()
        else
            view.onLoginFailed()
    }
}