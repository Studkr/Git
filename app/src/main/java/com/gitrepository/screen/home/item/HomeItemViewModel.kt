package com.gitrepository.screen.home.item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope

import com.gitrepository.data.model.Item
import com.gitrepository.data.repository.ApiReopository
import com.gitrepository.data.repository.DataBaseRepository
import com.gitrepository.db.DataBaseEntity
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class HomeItemViewModel @Inject constructor(
    private val apiReopository: ApiReopository,
    private val dataBaseRepository: DataBaseRepository
) : ViewModel() {


    private val reposList = MutableStateFlow<List<Item>>(emptyList())
    private val savedList = dataBaseRepository.getSavedRepositoryList()
    private val secondResponse = MutableStateFlow<List<Item>>(emptyList())
    private val endPointResponse = reposList.combine(secondResponse){first, second ->
        first + second
    }
    val t = MutableStateFlow<List<Item>>(emptyList())

    val error = LiveEvent<String>()
    val currentData = endPointResponse.combine(savedList) { repo, saved ->
        repo.map {
            WithSavedData(
                item = it,
                isBookmark = saved.contains(DataBaseEntity(it.id, link = it.subscriptionURL))
            )
        }
    }.asLiveData()


    fun setData(data: String) {
        when (data) {

            "Saved" -> loadSaved()
        }
    }

    private fun loadSaved() {
        viewModelScope.launch {
            try {
                dataBaseRepository.getSavedRepositoryList().map { bookmarks ->
                    t.value = bookmarks.map {
                        apiReopository.getRepoById(it.id)
                    }
                }.collect()
            } catch (e: HttpException) {
                error.value = e.message
            }
        }
    }

    fun savedClicked(item: WithSavedData) {
        when (item.isBookmark) {
            true -> {
                deleteFromDataBaes(item = item.item)
            }
            false -> {
                savedToDataBase(item = item.item)
            }
        }
    }

    private fun savedToDataBase(item: Item) {
        viewModelScope.launch {
            dataBaseRepository.inset(DataBaseEntity(item.id, item.subscriptionURL))

        }
    }

    fun deleteFromDataBaes(item: Item) {
        viewModelScope.launch {
            dataBaseRepository.delete(DataBaseEntity(item.id, item.subscriptionURL))
        }
    }

    fun findRepo(text: CharSequence?) {
        viewModelScope.launch {
            try {
                reposList.value = apiReopository.searchRepository(text.toString()).items.take(15)
                secondResponse.value = apiReopository.searchRepository(text.toString()).items.takeLast(15)
            } catch (e: HttpException) {
                error.value = e.message()
            }

        }
    }
}

data class WithSavedData(
    val item: Item,
    val isBookmark: Boolean
)
