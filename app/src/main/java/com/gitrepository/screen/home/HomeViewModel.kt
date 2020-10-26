package com.gitrepository.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gitrepository.data.repository.ApiReopository
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val apiReopository: ApiReopository
): ViewModel() {


    fun getData(){
        viewModelScope.launch {
            apiReopository.searchRepository("Android")
        }
    }
}