package io.townsq.pandora.ui.createRecord

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.townsq.pandora.data.feed.FeedRepository
import io.townsq.pandora.data.models.Record
import io.townsq.pandora.data.models.RecordType
import io.townsq.pandora.data.models.Vehicle
import io.townsq.pandora.data.record.RecordRepository
import kotlinx.coroutines.launch

class RecordViewModel(private val recordRepository: RecordRepository) : ViewModel() {

    private val _vehiclesLiveData = MutableLiveData<List<Vehicle>>()
    val vehiclesLiveData: LiveData<List<Vehicle>> = _vehiclesLiveData

    private val _selectedVehicle: MutableLiveData<Vehicle?> = MutableLiveData()
    val selectedVehicle: LiveData<Vehicle?> = _selectedVehicle

    private val _selectedRecordType: MutableLiveData<RecordType?> = MutableLiveData()
    val selectedRecordType: LiveData<RecordType?> = _selectedRecordType

    private val _selectedItemPosition = MutableLiveData<Int>()
    val selectedItemPosition: LiveData<Int> = _selectedItemPosition

    init {
        getVehiclesByDriverId("648a30cd4cd7ec04e92df3c6")
    }

    fun updateSelectedItemPosition(position: Int) {
        val currentSelectedPosition = _selectedItemPosition.value
        _selectedItemPosition.value = if (currentSelectedPosition == position) {
            -1
        } else {
            position
        }
    }

    fun setSelectedVehicle(vehicle: Vehicle?) {
        _selectedVehicle.value = vehicle
    }

    fun setSelectedRecordType(recordType: RecordType?) {
        _selectedRecordType.value = recordType
    }

    private fun getVehiclesByDriverId(driverId: String) {
        viewModelScope.launch {
            val response = recordRepository.getVehiclesByDriverId(driverId)
            if (response.isSuccess) {
                _vehiclesLiveData.value = listOfNotNull(response.getOrNull())
            } else {
                println("an error has occurred")
            }
        }
    }

}
