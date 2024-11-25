package com.juanfra.navigationdrawerejemplo

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

/*
Autor: Juan Francisco Sánchez González
Fecha: 23/11/2024
Clase: Actividad principal con un menú lateral (NavigationDrawer), que contiene una cabecera y diferentes
opciones, se implementa el manejador onClick del menú.
*/

class MainActivity : AppCompatActivity() {

    // Controles a utilizar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar DrawerLayout y NavigationView
        drawerLayout = findViewById(R.id.main)
        navigationView = findViewById(R.id.navigation_view)

        // Manejar las selecciones del menú
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Acción al seleccionar "Home"
                    showToast(getString(R.string.op_home_toast))
                }
                R.id.nav_profile -> {
                    // Acción al seleccionar "Profile"
                    showToast(getString(R.string.op_profile_toast))
                }
                R.id.nav_settings -> {
                    // Acción al seleccionar "Settings"
                    showToast(getString(R.string.op_settings_toast))
                }
            }
            // Cerrar el panel después de seleccionar una opción
            drawerLayout.closeDrawers()
            true
        }
    }

    // Mostrar mensaje Toast con la opción pulsada en el menú
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
