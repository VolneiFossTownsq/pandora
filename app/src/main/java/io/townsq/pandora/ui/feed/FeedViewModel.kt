package io.townsq.pandora.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.townsq.pandora.data.feed.FeedRepository
import io.townsq.pandora.data.models.Record
import io.townsq.pandora.data.models.RecordType
import kotlinx.coroutines.launch

class FeedViewModel(private val feedRepository: FeedRepository) : ViewModel() {

    private val _recordsLiveData = MutableLiveData<List<Record>>()
    val recordsLiveData: LiveData<List<Record>> = _recordsLiveData

    private val _filteredRecordsLiveData = MutableLiveData<List<Record>?>()
    val filteredRecordsLiveData: MutableLiveData<List<Record>?> = _filteredRecordsLiveData

    private val appliedFilters: MutableSet<RecordType> = mutableSetOf()

    init {
        fetchRecords()
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

    fun filterRecord(query: String) {
        val filteredList = recordsLiveData.value?.filter { record ->
            val nameMatchesQuery = record.vehicle.name.contains(query, ignoreCase = true)
            val firstNameMatchesQuery = record.vehicle.driver.firstName.contains(query, ignoreCase = true)

            nameMatchesQuery || firstNameMatchesQuery
        }?.filter { record ->
            appliedFilters.isEmpty() || appliedFilters.contains(record.recordType)
        }

        _filteredRecordsLiveData.value = filteredList
    }

    private fun fetchRecords() {
        viewModelScope.launch {
            val response = feedRepository.getRecords()
            if (response.isSuccess) {
                _recordsLiveData.value = response.getOrDefault(listOf())
            } else {
                _recordsLiveData.value = listOf()
            }
        }
    }
}
