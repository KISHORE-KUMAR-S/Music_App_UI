package com.android.musicappui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories

    fun loadCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            val categories = listOf("Hits", "Happy", "Workout", "Running", "TGIF", "Yoga")
            _categories.value = categories
        }
    }
}