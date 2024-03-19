package br.com.fiap.alertacidade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.alertacidade.screens.HomeScreen
import br.com.fiap.alertacidade.screens.LoginScreen
import br.com.fiap.alertacidade.screens.MenuScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "login"
            ){
                composable(route = "login"){
                    LoginScreen(navController)
                }
                composable(route = "menu") {
                    MenuScreen(navController)
                }
                composable(route = "home") {
                    HomeScreen()
                }
            }

        }
    }
}

