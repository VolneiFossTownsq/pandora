package io.townsq.pandora.ui.createRecord

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.townsq.pandora.data.feed.FeedRepository
import io.townsq.pandora.data.models.Record
import kotlinx.coroutines.launch

class RecordViewModel(private val recordRepository: FeedRepository) : ViewModel() {

    private val _recordsLiveData = MutableLiveData<List<Record>>()
    val recordsLiveData: LiveData<List<Record>> = _recordsLiveData

    private val _selectedItemPosition = MutableLiveData<Int>()
    val selectedItemPosition: LiveData<Int> = _selectedItemPosition

    init {
        fetchRecords()
    }

    fun updateSelectedItemPosition(position: Int) {
        val currentSelectedPosition = _selectedItemPosition.value
        _selectedItemPosition.value = if (currentSelectedPosition == position) {
            -1
        } else {
            position
        }
    }

    fun fetchRecords(){
        viewModelScope.launch {
            val recordsResult = recordRepository.getRecords()
            if (recordsResult.isSuccess) {
                _recordsLiveData.value = recordsResult.getOrNull()
                _selectedItemPosition.value = -1
            }
        }
    }
}
