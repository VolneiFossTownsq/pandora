package io.townsq.pandora.ui.createRecord


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.townsq.pandora.data.Driver
import io.townsq.pandora.data.Record
import io.townsq.pandora.data.RecordType
import io.townsq.pandora.data.Vehicle
import java.util.Date

class RecordViewModel : ViewModel() {

    private val _recordsLiveData = MutableLiveData<List<Record>>()
    val recordsLiveData: LiveData<List<Record>> = _recordsLiveData

    private val _selectedItemPosition = MutableLiveData<Int>()
    val selectedItemPosition: LiveData<Int> = _selectedItemPosition

    init {
        val mockRecords = getMockRecords()
        _recordsLiveData.value = mockRecords
        _selectedItemPosition.value = -1
    }

    fun updateSelectedItemPosition(position: Int) {
        val currentSelectedPosition = _selectedItemPosition.value
        _selectedItemPosition.value = if (currentSelectedPosition == position) {
            -1
        } else {
            position
        }
    }

    private fun getMockRecords(): List<Record> {
        val currentTime = Date().time
        return listOf(
            Record(
                "1",
                RecordType.MAINTENANCE,
                Vehicle("1", "Lance EVO", "ABC123", Driver("1", "João", "Silva", 123456)),
                Date(currentTime)
            ), Record(
                "2",
                RecordType.SHIFT_START,
                Vehicle("2", "Ralliart", "DEF456", Driver("2", "Maria", "Souza", 654321)),
                Date(currentTime)
            ), Record(
                "3", RecordType.GAS, Vehicle(
                    "3", "Civic", "GHI789", Driver("3", "Pedro", "Souza", 987654)
                ), Date(currentTime)
            ), Record(
                "4",
                RecordType.MAINTENANCE,
                Vehicle(
                    "4", "Jetta", "GHI789", Driver("4", "Eduarda", "Santos", 987654)
                ),
                Date(currentTime),
            ), Record(
                "5", RecordType.SHIFT_START, Vehicle(
                    "5", "Skyline", "GHI789", Driver("5", "Jorge", "Lima", 987654)
                ), Date(currentTime)
            ), Record(
                "6", RecordType.GAS, Vehicle(
                    "6", "350Z", "GHI789", Driver("6", "Jessica", "Pereira", 987654)
                ), Date(currentTime)
            )
        )
    }
}