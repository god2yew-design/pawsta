package com.example.petverse.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petverse.domain.model.Post
import com.example.petverse.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            getPostsUseCase().fold(
                onSuccess = { posts ->
                    _posts.value = posts
                },
                onFailure = { exception ->
                    _error.value = exception.message ?: "Failed to load posts"
                }
            )

            _isLoading.value = false
        }
    }

    fun refreshPosts() {
        loadPosts()
    }

    fun likePost(postId: String) {
        // TODO: Implement like functionality
    }

    fun commentOnPost(postId: String, comment: String) {
        // TODO: Implement comment functionality
    }
}