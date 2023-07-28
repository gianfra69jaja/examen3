package com.gire.examen3_gianfranco_remaycuna.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.gire.examen3_gianfranco_remaycuna.R
import com.gire.examen3_gianfranco_remaycuna.databinding.ActivityMainBinding
import com.gire.examen3_gianfranco_remaycuna.view.fragments.FavoritosFragment
import com.gire.examen3_gianfranco_remaycuna.view.fragments.InformacionFragment
import com.gire.examen3_gianfranco_remaycuna.view.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        reemplazar_Fragmento(InformacionFragment())

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.info -> reemplazar_Fragmento(InformacionFragment())
                R.id.jugadores -> reemplazar_Fragmento(MainFragment())
                R.id.favoritos -> reemplazar_Fragmento(FavoritosFragment())

                else -> {

                }
            }
            true
        }
    }

    private fun reemplazar_Fragmento(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}