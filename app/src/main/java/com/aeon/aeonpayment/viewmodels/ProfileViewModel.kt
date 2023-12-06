package com.aeon.aeonpayment.viewmodels

import com.aeon.aeonpayment.api.data.Payment

interface ProfileViewModel {

    fun getPayments(token: String): List<Payment>
}