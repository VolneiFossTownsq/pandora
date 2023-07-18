package io.townsq.pandora.ui.createRecord

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.townsq.pandora.data.feed.FeedRepository
import io.townsq.pandora.data.models.CreateRecord
import io.townsq.pandora.data.models.Record
import io.townsq.pandora.data.models.RecordType
import io.townsq.pandora.data.models.Vehicle
import io.townsq.pandora.data.record.RecordRepository
import kotlinx.coroutines.launch

class RecordViewModel(private val recordRepository: RecordRepository) : ViewModel() {

    private val _vehicleList: MutableLiveData<List<Vehicle>> = MutableLiveData()
    val vehicleList: LiveData<List<Vehicle>> = _vehicleList
    private val _selectedVehicle: MutableLiveData<Vehicle?> = MutableLiveData()
    val selectedVehicle: LiveData<Vehicle?> = _selectedVehicle
    private val _selectedRecordType: MutableLiveData<RecordType?> = MutableLiveData()
    val selectedRecordType: LiveData<RecordType?> = _selectedRecordType
    private val _postIsSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val postIsSuccess: LiveData<Boolean> = _postIsSuccess
    fun setSelectedVehicle(vehicle: Vehicle?) {
        _selectedVehicle.value = vehicle
    }
    fun setSelectedRecordType(recordType: RecordType?) {
        _selectedRecordType.value = recordType
    }
    fun getVehiclesByDriverId(driverId: String) {
        viewModelScope.launch {
            val response = recordRepository.getVehiclesByDriverId(driverId)
            if (response.isSuccess) {
                _vehicleList.value = listOf(response.getOrNull()!!)
            } else {
                _vehicleList.value = listOf()
            }
        }
    }
    fun postNewRecord(serviceCost: Float = 0.toFloat()) {
        viewModelScope.launch {
            val response = recordRepository.postCreateRecord(
                CreateRecord(
                selectedRecordType.value?.queryValue?.uppercase().toString(),
                selectedVehicle.value?.id.toString(),
                System.currentTimeMillis().toString(),
                serviceCost
            )
            )
            _postIsSuccess.value = response.isSuccess
        }
    }

}
