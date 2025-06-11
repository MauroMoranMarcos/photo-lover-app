package com.example.photo_lover_app.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Photo Lover") },
                navigationIcon = {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Puedes reemplazar esta imagen por tu logo
            Text("¡Bienvenido a Photo Lover!", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Explora, guarda y comparte tus mejores fotos.", fontSize = 16.sp)
        }
    }
}
