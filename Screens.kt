package com.example.beyapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.beyapp.R
import com.example.beyapp.sampleBeys
import com.example.beyapp.sampleLaunches
import com.example.beyapp.samplePieces
import com.example.beyapp.sampleExamples
import com.example.beyapp.samplePieceExamples
import androidx.compose.ui.text.style.TextOverflow



// PANTALLA: PantallaInicioSesion

@Composable
fun PantallaInicioSesion(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var usuario by remember { mutableStateOf("") }
            var contrasena by remember { mutableStateOf("") }

            Text("Inicio de Sesión", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(24.dp))

            TextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Usuario") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = contrasena,
                onValueChange = { contrasena = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = {
                navController.navigate("pantalla_menu")
            }) {
                Text("Iniciar Sesión")
            }

            Spacer(modifier = Modifier.height(24.dp))
            Text("O inicia sesión con:", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Logo de Google
                Image(
                    painter = painterResource(id = R.drawable.logo_google),
                    contentDescription = "Logo de Google",
                    modifier = Modifier
                        .size(48.dp)
                        .clickable { navController.navigate("pantalla_seleccion_usuario") },
                    contentScale = ContentScale.Fit
                )

                // Logo de Facebook
                Image(
                    painter = painterResource(id = R.drawable.logo_facebook),
                    contentDescription = "Logo de Facebook",
                    modifier = Modifier
                        .size(48.dp)
                        .clickable { navController.navigate("pantalla_seleccion_usuario") },
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}


// PANTALLA: PantallaSeleccionUsuario

@Composable
fun PantallaSeleccionUsuario(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Selecciona tu usuario:", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("pantalla_menu") }) {
                Text("Usuario de Google")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.navigate("pantalla_menu") }) {
                Text("Usuario de Facebook")
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text("Volver")
            }
        }
    }
}


// PANTALLA: PantallaMenu

@Composable
fun PantallaMenu(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Menú Principal", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(24.dp))

            // Imagen para Tipos de Beyblade
            Image(
                painter = painterResource(id = R.drawable.tipos_de_beys),
                contentDescription = "Tipos de Beyblade",
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(120.dp)
                    .clickable { navController.navigate("pantalla_tipos_beyblade") },
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Imagen para Tipos de Lanzamiento
            Image(
                painter = painterResource(id = R.drawable.tipos_de_lanzamientos),
                contentDescription = "Tipos de Lanzamiento",
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(120.dp)
                    .clickable { navController.navigate("pantalla_tipos_lanzamiento") },
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Imagen para Tipos de Piezas
            Image(
                painter = painterResource(id = R.drawable.tipos_de_piezas),
                contentDescription = "Tipos de Piezas",
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(120.dp)
                    .clickable { navController.navigate("pantalla_tipos_piezas") },
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { navController.navigate("pantalla_inicio_sesion") }) {
                Text("Volver a Inicio de Sesión")
            }
        }
    }
}


// PANTALLA: PantallaTiposBeyblade (Diseño de Tarjeta con Imagen)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaTiposBeyblade(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tipos de Beyblade") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            items(sampleBeys) { bey ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clickable { navController.navigate("pantalla_ejemplos_bey/${bey.id}") }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = bey.imageId),
                            contentDescription = bey.name,
                            modifier = Modifier
                                .size(70.dp)
                                .padding(end = 16.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = bey.name, style = MaterialTheme.typography.titleLarge)
                            Text(
                                text = bey.description,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }
}


// PANTALLA: PantallaTiposLanzamiento (Diseño de Tarjeta con Imagen y Descripción)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaTiposLanzamiento(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tipos de Lanzamiento") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

            items(sampleLaunches) { lanzamiento ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = lanzamiento.imageId),
                            contentDescription = lanzamiento.name,
                            modifier = Modifier
                                .size(70.dp)
                                .padding(end = 16.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = lanzamiento.name, style = MaterialTheme.typography.titleLarge)
                            Text(
                                text = lanzamiento.description,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 8,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }
}


// PANTALLA: PantallaTiposPiezas (Diseño de Tarjeta con Imagen)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaTiposPiezas(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tipos de Piezas") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(innerPadding)) {

            itemsIndexed(items = samplePieces) { index, pieza ->
                val pieceId = index + 1 // ID para Blade=1, Ratchet=2, Bit=3
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)

                        .clickable { navController.navigate("pantalla_ejemplos_piezas/$pieceId") }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(

                            painter = painterResource(id = pieza.imageId),
                            contentDescription = pieza.name,
                            modifier = Modifier
                                .size(70.dp)
                                .padding(end = 16.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = pieza.name, style = MaterialTheme.typography.titleLarge)
                            Text(
                                text = pieza.description,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 4,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }
}



// PANTALLA: PantallaEjemplosBey (Ejemplos de Beyblade)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaEjemplosBey(navController: NavController, tipoId: Int) {
    val beyType = sampleBeys.find { it.id == tipoId }
    val title = beyType?.name ?: "Ejemplos de Beyblade"

    val examples = sampleExamples.filter { it.beyTypeId == tipoId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejemplos - $title") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver a Tipos de Beyblade"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        if (examples.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize().padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("No hay ejemplos disponibles para este tipo aún.", style = MaterialTheme.typography.titleMedium)
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(innerPadding).padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(examples) { example ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(example.name, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Image(
                            painter = painterResource(id = example.imageId),
                            contentDescription = example.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp), // ALTURA ÓPTIMA
                            contentScale = ContentScale.Fit
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}


// PANTALLA: PantallaEjemplosPiezas (Ejemplos de Piezas)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaEjemplosPiezas(navController: NavController, piezaId: Int) {

    val pieceName = samplePieces.getOrNull(piezaId - 1)?.name ?: "Pieza"

    val examples = samplePieceExamples.filter { it.pieceId == piezaId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejemplos - $pieceName") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver a Tipos de Piezas"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        if (examples.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize().padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("No hay ejemplos disponibles para esta pieza aún.", style = MaterialTheme.typography.titleMedium)
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(innerPadding).padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(examples) { example ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(example.name, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Image(
                            painter = painterResource(id = example.imageId),
                            contentDescription = example.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp), // Misma ALTURA ÓPTIMA que los Beyblades
                            contentScale = ContentScale.Fit
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

