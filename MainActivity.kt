package com.example.beyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.beyapp.screens.PantallaInicioSesion
import com.example.beyapp.screens.PantallaMenu
import com.example.beyapp.screens.PantallaTiposBeyblade
import com.example.beyapp.screens.PantallaTiposLanzamiento
import com.example.beyapp.screens.PantallaTiposPiezas
import com.example.beyapp.screens.PantallaSeleccionUsuario
import com.example.beyapp.screens.PantallaEjemplosBey
import com.example.beyapp.screens.PantallaEjemplosPiezas
import com.example.beyapp.ui.theme.BeyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeyAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "pantalla_inicio_sesion"
                    ) {
                        composable("pantalla_inicio_sesion") { PantallaInicioSesion(navController) }
                        composable("pantalla_menu") { PantallaMenu(navController) }
                        composable("pantalla_tipos_beyblade") { PantallaTiposBeyblade(navController) }
                        composable("pantalla_tipos_lanzamiento") { PantallaTiposLanzamiento(navController) }
                        composable("pantalla_tipos_piezas") { PantallaTiposPiezas(navController) }
                        composable("pantalla_seleccion_usuario") { PantallaSeleccionUsuario(navController) }

                        // RUTA PARA LOS EJEMPLOS DE BEYBLADE
                        composable("pantalla_ejemplos_bey/{tipoId}") { backStackEntry ->
                            val tipoId = backStackEntry.arguments?.getString("tipoId")?.toInt() ?: 1
                            PantallaEjemplosBey(navController, tipoId)
                        }

                        // RUTA PARA LOS EJEMPLOS DE PIEZAS
                        composable("pantalla_ejemplos_piezas/{piezaId}") { backStackEntry ->
                            val piezaId = backStackEntry.arguments?.getString("piezaId")?.toInt() ?: 1
                            PantallaEjemplosPiezas(navController, piezaId)
                        }
                    }
                }
            }
        }
    }
}
