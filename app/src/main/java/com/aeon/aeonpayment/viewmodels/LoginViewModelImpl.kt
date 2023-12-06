package com.aeon.aeonpayment.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aeon.aeonpayment.api.PaymentsApi
import com.aeon.aeonpayment.api.ServerService
import com.aeon.aeonpayment.api.data.RegistrationBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class LoginViewModelImpl: ViewModel(), LoginViewModel  {

    private val _statusLogin: MutableLiveData<Boolean> = MutableLiveData(false)
    val statusLogin: LiveData<Boolean> = _statusLogin
    private val api: PaymentsApi = ServerService.retrofitService()

    override fun registerUser(login: String, password: String) {
        viewModelScope.launch {
            try {
                val response = api.registerUser(RegistrationBody(login, password))
                ServerService.token = response.token
                _statusLogin.value = true

            } catch (e : Exception) {
                Log.d("res", e.message!!)
                ServerService.token = "error"
                _statusLogin.value = false
            }
        }
    }

    override fun validatePassword(): Boolean {
        TODO("Not yet implemented")
    }

}