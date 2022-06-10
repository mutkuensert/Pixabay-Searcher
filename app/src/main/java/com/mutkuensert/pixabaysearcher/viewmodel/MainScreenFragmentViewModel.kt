package com.mutkuensert.pixabaysearcher.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mutkuensert.pixabaysearcher.model.MainModel
import com.mutkuensert.pixabaysearcher.service.PixabayService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenFragmentViewModel @Inject constructor(
    private val service: PixabayService
) : ViewModel() {
    val mainModel = MutableLiveData<MainModel>()

    fun searchInPixabay(searchText: String){
        viewModelScope.launch (Dispatchers.IO) {
            val response = service.searchPictures(searchText = searchText)
            if (response.isSuccessful){
                response.body()?.let {
                    mainModel.postValue(it)
                }
            }
        }

    }

}