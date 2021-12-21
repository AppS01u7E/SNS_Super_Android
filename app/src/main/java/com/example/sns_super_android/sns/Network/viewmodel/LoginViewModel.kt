package com.saehyun.trigris_android.feature.login.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sns_super_android.sns.Network.LOGIN_API
import com.example.sns_super_android.sns.Network.Response.TokenResponse
import com.example.sns_super_android.sns.Network.listner.TokenListener
import com.saehyun.trigris_android.feature.login.model.LoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(
) : ViewModel() {

    val success : MutableLiveData<Boolean> = MutableLiveData()
    val failed : MutableLiveData<Boolean> = MutableLiveData()

    fun login(loginRequest: LoginRequest) {

        val call = LOGIN_API.loginUser(loginRequest)
        call.enqueue(object : Callback<TokenResponse?> {
            override fun onResponse(call: Call<TokenResponse?>, response: Response<TokenResponse?>) {
                if(response.code() == 200) {
                    success.value = true
                } else {
                    failed.value = true
                }

            }

            override fun onFailure(call: Call<TokenResponse?>, t: Throwable) {

            }

        })
    }
}