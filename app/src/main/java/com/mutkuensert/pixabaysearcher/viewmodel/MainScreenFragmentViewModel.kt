package com.mutkuensert.pixabaysearcher.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mutkuensert.pixabaysearcher.service.PixabayService
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainScreenFragmentViewModel @Inject constructor(
    val service: PixabayService
) : ViewModel() {

    fun searchInPixabay(searchText: String){
        viewModelScope.launch (Dispatchers.IO) {
            val response = service.searchPictures(searchText = searchText)
            if (response.isSuccessful){
                println(response.body()?.hits)
            }
        }

    }

}