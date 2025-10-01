package com.org.pais_b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.org.components.CustomButton
import com.org.models.UserModel
import com.org.screens.BaseScreen
import com.org.screens.SplashScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PaisBApp()
            }
        }
    }
}

@Composable
fun PaisBApp() {
    var showSplash by remember { mutableStateOf(true) }

    if (showSplash) {
        SplashScreen(
            appName = "País B 🇧🇷",
            onTimeout = { showSplash = false }
        )
    } else {
        MainNavigation()
    }
}

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onNavigateToProfile = { navController.navigate("profile") }
            )
        }
        composable("profile") {
            ProfileScreen()
        }
    }
}

@Composable
fun HomeScreen(onNavigateToProfile: () -> Unit) {
    var isLoading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    BaseScreen(
        title = stringResource(R.string.home_title),
        showBackButton = false,
        actions = {
            IconButton(onClick = { /* Settings */ }) {
                Icon(Icons.Default.Settings, contentDescription = "Settings")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.welcome_message),
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Exemplo usando CustomButton do módulo compartilhado
            CustomButton(
                text = stringResource(R.string.test_button),
                onClick = {
                    isLoading = true
                    // Simular operação
                    scope.launch {
                        delay(2000)
                        isLoading = false
                    }
                },
                isLoading = isLoading
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = onNavigateToProfile) {
                Text(text = stringResource(R.string.profile_title))
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    // Exemplo usando UserModel do módulo compartilhado
    val user = UserModel(
        id = "bra_001",
        name = "João Silva",
        email = "joao.silva@brasil.com"
    )

    BaseScreen(
        title = stringResource(R.string.profile_title),
        showBackButton = true
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp)
        ) {
            Text(
                text = "Perfil do Usuário",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "ID: ${user.id}")
            Text(text = "Nome: ${user.name}")
            Text(text = "Email: ${user.email}")
        }
    }
}
