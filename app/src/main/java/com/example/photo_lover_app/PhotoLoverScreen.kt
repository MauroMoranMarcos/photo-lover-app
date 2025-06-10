import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.example.photo_lover_app.R
import com.example.photo_lover_app.ui.PhotoLoverViewModel

enum class PhotoLoverScreen(@StringRes val title: Int) {
    Home(title = R.string.home),
    Photos1(title = R.string.photos1),
    Photos2(title = R.string.photos2),
    Photos12(title = R.string.photos12)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoLoverAppBar(
    currentScreen: PhotoLoverScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        }
    )
}

@Composable
fun PhotoLoverApp(
    viewModel: PhotoLoverViewModel = viewModel()
) {}