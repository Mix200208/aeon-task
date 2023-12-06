package com.aeon.aeonpayment.viewmodels

interface LoginViewModel {

    fun registerUser(login: String, password: String)
    fun validatePassword(): Boolean
}