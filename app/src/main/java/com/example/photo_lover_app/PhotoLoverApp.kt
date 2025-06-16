import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.photo_lover_app.R
import com.example.photo_lover_app.ui.PhotoLoverViewModel
import com.example.photo_lover_app.ui.home.HomeDestination
import com.example.photo_lover_app.ui.navigation.NavGraph
import com.example.photo_lover_app.ui.reminder.AddReminderDestination
import kotlinx.coroutines.launch

@Composable
fun PhotoLoverApp(navController: NavHostController = rememberNavController()) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.secondary
            ) {
                Text(
                    text = stringResource(R.string.menu),
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                    style = MaterialTheme.typography.titleLarge
                )
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = stringResource(R.string.home)
                        )
                    },
                    label = { Text(stringResource(R.string.home)) },
                    selected = false,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                    onClick = {
                        navController.navigate(HomeDestination.route)
                        scope.launch { drawerState.close() }
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        unselectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu_photos1),
                            contentDescription = stringResource(R.string.photos1)
                        )
                    },
                    label = { Text(stringResource(R.string.photos1)) },
                    selected = false,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                    onClick = {
                        navController.navigate(AddReminderDestination.route)
                        scope.launch { drawerState.close() }
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        unselectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu_photos2),
                            contentDescription = stringResource(R.string.photos2)
                        )
                    },
                    label = { Text(stringResource(R.string.photos2)) },
                    selected = false,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                    onClick = {
                        navController.navigate(AddReminderDestination.route)
                        scope.launch { drawerState.close() }
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        unselectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_menu_photos12),
                            contentDescription = stringResource(R.string.photos12)
                        )
                    },
                    label = { Text(stringResource(R.string.photos12)) },
                    selected = false,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                    onClick = {
                        navController.navigate(AddReminderDestination.route)
                        scope.launch { drawerState.close() }
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        unselectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.baseline_calendar_month_24),
                            contentDescription = stringResource(R.string.calendar)
                        )
                    },
                    label = { Text(stringResource(R.string.calendar)) },
                    selected = false,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                    onClick = {
                        navController.navigate(AddReminderDestination.route)
                        scope.launch { drawerState.close() }
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        unselectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.baseline_campaign_24),
                            contentDescription = stringResource(R.string.reminders)
                        )
                    },
                    label = { Text(stringResource(R.string.reminders)) },
                    selected = false,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
                    onClick = {
                        navController.navigate(AddReminderDestination.route)
                        scope.launch { drawerState.close() }
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        unselectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        }
    ) {
        NavGraph(
            navController = navController,
            onMenuClick = {
                scope.launch { drawerState.open() }
            })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoLoverAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {},
    onMenuClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Filled.Menu,
                    contentDescription = stringResource(R.string.menu)
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            navigationIconContentColor = MaterialTheme.colorScheme.onSecondary,
            titleContentColor = MaterialTheme.colorScheme.onSecondary,
            actionIconContentColor = MaterialTheme.colorScheme.onSecondary
        ))
}
