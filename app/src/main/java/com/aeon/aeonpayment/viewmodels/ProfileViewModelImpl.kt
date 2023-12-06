package com.aeon.aeonpayment.viewmodels

import androidx.lifecycle.ViewModel
import com.aeon.aeonpayment.api.data.Payment

class ProfileViewModelImpl: ViewModel(), ProfileViewModel {

    override fun getPayments(token: String): List<Payment> {
        TODO("Not yet implemented")
    }
}