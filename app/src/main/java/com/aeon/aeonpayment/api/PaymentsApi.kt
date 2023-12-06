package com.aeon.aeonpayment.api

import com.aeon.aeonpayment.api.data.Payment
import com.aeon.aeonpayment.api.data.Payments
import com.aeon.aeonpayment.api.data.RegistrationBody
import com.aeon.aeonpayment.api.data.RegistrationResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface PaymentsApi {
    @Headers("app-key: 12345", "v: 1")
    @POST("/login")
    suspend fun registerUser(
        @Body registrationBody: RegistrationBody
    ): RegistrationResponse

    @Headers("app-key: 12345", "v: 1")
    @GET("/payments/{token}")
    suspend fun getPayments(@Path("token") token:String): Payments
}