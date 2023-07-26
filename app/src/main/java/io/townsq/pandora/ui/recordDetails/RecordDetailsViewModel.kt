package io.townsq.pandora.ui.recordDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.townsq.pandora.data.models.Record
import io.townsq.pandora.data.recordDetails.RecordDetailsRepository
import kotlinx.coroutines.launch

class RecordDetailsViewModel(
    private val recordDetailsRepository: RecordDetailsRepository,
    private val recordId: String
) : ViewModel() {

    private val _record: MutableLiveData<Record> = MutableLiveData()
    val record: LiveData<Record> = _record
    init {
        getRecordById(recordId)
    }
    private fun getRecordById(recordId: String) {
        viewModelScope.launch {
            val response = recordDetailsRepository.getRecordById(recordId)
            if (response.isSuccess) {
                _record.value = response.getOrNull()
            } else {
                println("error")
            }
        }
    }
}
