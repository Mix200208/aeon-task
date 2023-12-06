package com.aeon.aeonpayment.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aeon.aeonpayment.viewmodels.LoginViewModelImpl

class LoginViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModelImpl() as T
    }
}