package com.example.databinding01

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.databinding01.model.Gender
import com.example.databinding01.model.UiUser
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class UserViewModel : ViewModel() {
    val listUser = MutableLiveData<List<UiUser>>()
    private val _page = MutableLiveData<Page>()
    val displayChild = _page.map { it.value }

    init {
        viewModelScope.launch {
            _page.value = Page.Loading
            fetchUsers()
            _page.value = Page.UserList
        }
    }

    fun sunmit() {
        listUser.value?.forEach { user ->
            Log.d("xxx ", "user: $user")
        }
    }

    private suspend fun fetchUsers() {
        delay(TimeUnit.SECONDS.toMillis(3L))
        listUser.value = listOf(
            createUser("AAA", 9999, Gender.FEMALE),
            createUser("BBB", 46, Gender.MALE),
            createUser("CCC", 90, Gender.MALE),
            createUser("DDD", 23)
        )
    }

    private fun createUser(name: String, age: Int = 0, gender: Gender? = null): UiUser {
        return UiUser(id = Random.nextLong()).apply {
            this.name = name
            this.age = age.toDouble()
            this.gender = gender
        }
    }

    sealed class Page(val value: Int) {
        object Loading : Page(0)
        object UserList : Page(1)
    }
}