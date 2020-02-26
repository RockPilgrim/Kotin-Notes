package my.rockpilgrim.chucknorriskotlin.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.rockpilgrim.chucknorriskotlin.api.JokeRepository
import my.rockpilgrim.chucknorriskotlin.data.Event
import my.rockpilgrim.chucknorriskotlin.data.pogo.Joke

class MainViewModel : ViewModel() {

    val TAG = "MainViewModel"
    val jokeList: MutableLiveData<Event> = MutableLiveData()

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        loadJokes()
    }

    fun loadJokes() {
        jokeList.postValue(Event.Loading)
        this.viewModelScope.launch(Dispatchers.IO) {
            Log.i(TAG, "initJokes() corutines ${Thread.currentThread().name}")
            val list: List<Joke> = JokeRepository().getJokes(32).jokes
            jokeList.postValue(Event.Success(list))
        }
    }
}