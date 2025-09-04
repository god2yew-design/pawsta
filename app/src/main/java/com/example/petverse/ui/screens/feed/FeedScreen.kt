package com.example.petverse.ui.screens.feed

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.petverse.R
import com.example.petverse.domain.model.Post
import com.example.petverse.ui.components.PostCard

@Composable
fun FeedScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // TODO: Replace with actual ViewModel
    val posts by remember { mutableStateOf(getMockPosts()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.feed)) },
                actions = {
                    IconButton(onClick = { /* TODO: Open create post */ }) {
                        Icon(
                            painter = androidx.compose.ui.res.painterResource(R.drawable.ic_add),
                            contentDescription = stringResource(R.string.create_post)
                        )
                    }
                }
            )
        }
    ) { padding ->
        if (posts.isEmpty()) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.no_posts_yet),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        } else {
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(posts) { post ->
                    PostCard(
                        post = post,
                        onLikeClick = { /* TODO: Handle like */ },
                        onCommentClick = { /* TODO: Handle comment */ },
                        onShareClick = { /* TODO: Handle share */ },
                        onProfileClick = { /* TODO: Navigate to profile */ }
                    )
                }
            }
        }
    }
}

// TODO: Remove this mock data and replace with actual data from repository
private fun getMockPosts(): List<Post> {
    // Mock data will be added here
    return emptyList()
}