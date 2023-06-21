package io.townsq.pandora.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.townsq.pandora.data.Driver
import io.townsq.pandora.data.Record
import io.townsq.pandora.data.RecordType
import io.townsq.pandora.data.Vehicle
import java.util.Date
import kotlin.time.Duration.Companion.days


class FeedViewModel : ViewModel() {


    private val _recordsLiveData = MutableLiveData<List<Record>>()
    val recordsLiveData: LiveData<List<Record>> = _recordsLiveData

    private val _filteredRecordsLiveData = MutableLiveData<List<Record>?>()
    val filteredRecordsLiveData: MutableLiveData<List<Record>?> = _filteredRecordsLiveData

    private val appliedFilters: MutableSet<RecordType> = mutableSetOf()

    init {
        val mockRecords = getMockRecords()
        _recordsLiveData.value = mockRecords
        applyFilters()
    }

    fun addFilter(recordType: RecordType) {
        appliedFilters.add(recordType)
        applyFilters()
    }

    fun removeFilter(recordType: RecordType) {
        appliedFilters.remove(recordType)
        applyFilters()
    }

    private fun applyFilters() {
        val allRecords = _recordsLiveData.value
        val filteredRecords = if (appliedFilters.isEmpty()) {
            allRecords
        } else {
            allRecords?.filter { appliedFilters.contains(it.recordType) }
        }
        _filteredRecordsLiveData.value = filteredRecords
    }



    private fun getMockRecords(): List<Record> {

        val currentTime = Date().time


        return listOf(
            Record(
                "1",
                RecordType.MAINTENANCE,
                Vehicle("1", "Lance EVO", "ABC123", Driver("1", "João", "Silva", 123456)),
                Date(currentTime)
            ),
            Record(
                "2",
                RecordType.SHIFT_START,
                Vehicle("2", "Ralliart", "DEF456", Driver("2", "Maria", "Souza", 654321)),
                Date(currentTime)
            ),
            Record(
                "3",
                RecordType.GAS,
                Vehicle(
                    "3", "Civic", "GHI789", Driver("3", "Pedro", "Souza", 987654)
                ),
                Date(currentTime)
            ),
            Record(
                "4",
                RecordType.MAINTENANCE,
                Vehicle(
                    "4", "Jetta", "GHI789", Driver("4", "Eduarda", "Santos", 987654)
                ),
                Date(currentTime),

                ),
            Record(
                "5",
                RecordType.SHIFT_START,
                Vehicle(
                    "5", "Skyline", "GHI789", Driver("5", "Jorge", "Lima", 987654)
                ),
                Date(currentTime)
            ),
            Record(
                "6",
                RecordType.GAS,
                Vehicle(
                    "6", "350Z", "GHI789", Driver("6", "Jessica", "Pereira", 987654)
                ),
                Date(currentTime)
            )
        )
    }

    fun filterRecord(query: String) {
        val filteredList = recordsLiveData.value?.filter { record ->
            val nameMatchesQuery = record.vehicle.name.contains(query, ignoreCase = true)
            val firstNameMatchesQuery = record.vehicle.driver.firstName.contains(query, ignoreCase = true)
            val recordTypeMatchesFilter = appliedFilters.isEmpty() || appliedFilters.contains(record.recordType)

            nameMatchesQuery || firstNameMatchesQuery
        }?.filter { record ->
            appliedFilters.isEmpty() || appliedFilters.contains(record.recordType)
        }

        _filteredRecordsLiveData.value = filteredList
    }
}
