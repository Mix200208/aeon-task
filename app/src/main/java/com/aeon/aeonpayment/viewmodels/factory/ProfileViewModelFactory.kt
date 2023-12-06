package com.aeon.aeonpayment.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aeon.aeonpayment.viewmodels.ProfileViewModelImpl

class ProfileViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModelImpl() as T
    }
}