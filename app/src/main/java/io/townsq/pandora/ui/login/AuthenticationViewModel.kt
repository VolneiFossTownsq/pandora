package io.townsq.pandora.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.townsq.pandora.data.login.LoginRepository
import io.townsq.pandora.data.models.Driver
import io.townsq.pandora.data.models.Login
import kotlinx.coroutines.launch

class AuthenticationViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _user: MutableLiveData<Driver> = MutableLiveData()
    val user: LiveData<Driver> = _user

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    init {
        println(user.value?.document)
    }

    fun sendLogin(userInfo: Login) {
        viewModelScope.launch {
            val response = loginRepository.postLogin(userInfo)
            if (response.isSuccess) {
                _user.value = response.getOrNull()
            } else {
                _loading.value = false
                println("error")
            }
        }
    }

}
