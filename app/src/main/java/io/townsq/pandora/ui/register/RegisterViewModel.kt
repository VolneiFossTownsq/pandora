package io.townsq.pandora.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.townsq.pandora.data.models.Driver
import io.townsq.pandora.data.models.Register
import io.townsq.pandora.data.register.RegisterRepository
import kotlinx.coroutines.launch

class RegisterViewModel(private val registerRepository: RegisterRepository) : ViewModel() {

    private val _registerResponse: MutableLiveData<Driver?> = MutableLiveData()
    val registerResponse: LiveData<Driver?> = _registerResponse

    fun postRegister(userData: Register) {
        viewModelScope.launch {
            val response = registerRepository.postRegister(userData)
            if (response.isSuccess) {
                _registerResponse.value = response.getOrNull()
            } else {
                println("error")
            }
        }
    }
}
