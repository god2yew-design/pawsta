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
import com.example.petverse.domain.model.*
import com.example.petverse.ui.components.PostCard
import java.util.Date

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
    return listOf(
        Post(
            id = "1",
            author = User(
                id = "user1",
                name = "John Doe",
                email = "john@example.com",
                avatarUrl = null,
                bio = "Dog lover and pet photographer",
                location = "New York, NY",
                isBusiness = false,
                badges = listOf()
            ),
            pet = Pet(
                id = "pet1",
                ownerId = "user1",
                name = "Max",
                species = "dog",
                breed = "Golden Retriever",
                sex = "male",
                ageMonths = 36,
                weightKg = 30.0,
                bio = "Friendly golden boy who loves the park!",
                temperament = listOf("friendly_with_kids", "friendly_with_dogs"),
                lookingStatus = null,
                galleryCount = 5,
                bloodlineParentId = null,
                photos = listOf(),
                createdAt = Date()
            ),
            mediaType = MediaType.PHOTO,
            mediaUrl = "https://via.placeholder.com/400x300",
            caption = "Max enjoying his morning walk in Central Park! 🐕 #GoldenRetriever #DogLife",
            tags = listOf("dog", "golden_retriever", "park"),
            likeCount = 24,
            commentCount = 5,
            isLikedByCurrentUser = false,
            comments = listOf(),
            createdAt = Date(),
            updatedAt = Date()
        ),
        Post(
            id = "2",
            author = User(
                id = "user2",
                name = "Sarah Wilson",
                email = "sarah@example.com",
                avatarUrl = null,
                bio = "Cat mom and rescue volunteer",
                location = "Los Angeles, CA",
                isBusiness = false,
                badges = listOf()
            ),
            pet = Pet(
                id = "pet2",
                ownerId = "user2",
                name = "Luna",
                species = "cat",
                breed = "Persian",
                sex = "female",
                ageMonths = 24,
                weightKg = 4.5,
                bio = "Sweet Persian girl who loves cuddles",
                temperament = listOf("calm", "dependent"),
                lookingStatus = null,
                galleryCount = 3,
                bloodlineParentId = null,
                photos = listOf(),
                createdAt = Date()
            ),
            mediaType = MediaType.PHOTO,
            mediaUrl = "https://via.placeholder.com/400x300",
            caption = "Luna found her perfect sunbeam spot today ☀️🐱 #CatLife #PersianCat",
            tags = listOf("cat", "persian", "sunshine"),
            likeCount = 18,
            commentCount = 3,
            isLikedByCurrentUser = false,
            comments = listOf(),
            createdAt = Date(),
            updatedAt = Date()
        )
    )
}