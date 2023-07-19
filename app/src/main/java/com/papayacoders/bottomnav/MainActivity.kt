package com.papayacoders.bottomnav

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.papayacoders.bottomnav.screen.Add
import com.papayacoders.bottomnav.screen.Home
import com.papayacoders.bottomnav.screen.Profile
import com.papayacoders.bottomnav.screen.Reels
import com.papayacoders.bottomnav.screen.Search
import com.papayacoders.bottomnav.ui.theme.ThreadsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThreadsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MainView()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainView() {

    val navController = rememberNavController()


    Scaffold(bottomBar = { MyBottomAppBar(navController = navController) }) {


        NavHost(navController = navController, startDestination = ScreenRoute.Home.name) {


            composable(route = ScreenRoute.Home.name) {
                Home(navController = navController)
            }

            composable(route = ScreenRoute.Search.name) {
                Search(navController = navController)
            }

            composable(route = ScreenRoute.Add.name) {
                Add(navController = navController)
            }

            composable(route = ScreenRoute.Reels.name) {
                Reels(navController = navController)
            }

            composable(route = ScreenRoute.Profile.name) {
                Profile(navController = navController)
            }
        }
    }

}


@Composable
fun MyBottomAppBar(navController: NavController) {
    BottomAppBar() {


        //Home
        BottomNavigationItem(
            selected = true,
            onClick = {
                navController.popBackStack()
                navController.navigate(ScreenRoute.Home.name)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "",
                )
            })

        //Search
        BottomNavigationItem(
            selected = true,
            onClick = {
                navController.popBackStack()
                navController.navigate(ScreenRoute.Search.name)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "",
                )
            })

        //Add
        BottomNavigationItem(
            selected = true,
            onClick = {
                navController.popBackStack()
                navController.navigate(ScreenRoute.Add.name)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            })

        //Reels
        BottomNavigationItem(
            selected = true,
            onClick = {
                navController.popBackStack()
                navController.navigate(ScreenRoute.Reels.name)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "",
                )
            })

        //Profile
        BottomNavigationItem(
            selected = true,
            onClick = {
                navController.popBackStack()
                navController.navigate(ScreenRoute.Profile.name)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                )
            })


    }
}

