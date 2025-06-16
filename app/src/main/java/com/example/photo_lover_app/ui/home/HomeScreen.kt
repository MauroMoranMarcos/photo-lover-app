package com.example.photo_lover_app.ui.home

import PhotoLoverAppBar
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.photo_lover_app.R
import com.example.photo_lover_app.data.db.entities.Image
import com.example.photo_lover_app.ui.navigation.NavigationDestination
import com.example.photo_lover_app.ui.theme.PhotoloverappTheme
import java.time.Instant
import java.util.Date

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToReminder: () -> Unit,
    navigateToAddReminder: (Int) -> Unit,
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.primary,
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PhotoLoverAppBar(
                title = stringResource(HomeDestination.titleRes),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior,
                onMenuClick = onMenuClick
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToReminder,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add_reminder_title)
                )
            }
        },
    ) { innerPadding ->
        HomeBody(
            imageList = listOf(),
            onImageClick = navigateToAddReminder,
            modifier = modifier.fillMaxSize(),
            contentPadding = innerPadding,
        )
    }
}

@Composable
private fun HomeBody(
    imageList: List<Image>,
    onImageClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        if (imageList.isEmpty()) {
            Text(
                text = stringResource(R.string.no_image_description),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(contentPadding),
            )
        } else {
            ImageList(
                imageList = imageList,
                onImageClick = { onImageClick(it.id) },
                contentPadding = contentPadding,
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
private fun ImageList(
    imageList: List<Image>,
    onImageClick: (Image) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(items = imageList, key = { it.id }) { image ->
            PhotoLoverImage(image = image,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .clickable { onImageClick(image) })
        }
    }
}

@Composable
private fun PhotoLoverImage(
    image: Image, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = image.description,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = image.date.toString(),
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = stringResource(R.string.user_image, image.userId),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun HomeBodyPreview() {
    PhotoloverappTheme {
        HomeBody(listOf(
            Image(1, "Game1", "Image1", Date.from(Instant.now()), 1),
            Image(2, "Game2", "Image2", Date.from(Instant.now()), 2),
            Image(3, "Game3", "Image3", Date.from(Instant.now()), 3)
        ), onImageClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun HomeBodyEmptyListPreview() {
    PhotoloverappTheme {
        HomeBody(listOf(), onImageClick = {})
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun InventoryImagePreview() {
    PhotoloverappTheme {
        PhotoLoverImage(
            Image(4, "Game4", "Image4", Date.from(Instant.now()), 4),
        )
    }
}
