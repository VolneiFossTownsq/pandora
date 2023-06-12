package io.townsq.pandora.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.townsq.pandora.data.Driver
import io.townsq.pandora.data.Record
import io.townsq.pandora.data.RecordType
import io.townsq.pandora.data.Vehicle
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Calendar
import java.util.Date
import java.util.Locale

class FeedViewModel : ViewModel() {


    private val _recordsLiveData = MutableLiveData<List<Record>>()
    val recordsLiveData: LiveData<List<Record>> = _recordsLiveData

    init {
        val mockRecords = getMockRecords()
        _recordsLiveData.value = mockRecords
    }


    private fun getMockRecords(): List<Record> {

        val currentTime = Date().time

        return listOf(
            Record(
                "1",
                RecordType.MAINTENANCE,
                Vehicle("1", "Carro 1", "ABC123", Driver("1", "João", "Silva", 123456)),
                Date(currentTime)
            ),
            Record(
                "2",
                RecordType.SHIFT_START,
                Vehicle("2", "Carro 2", "DEF456", Driver("2", "Maria", "Souza", 654321)),
                Date(currentTime)
            ),
            Record(
                "3",
                RecordType.GAS,
                Vehicle(
                    "3", "Carro 3", "GHI789",
                    Driver("3", "Pedro", "Santos", 987654)
                ),
                Date(currentTime)
            ),
        )
    }
}
