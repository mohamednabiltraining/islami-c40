package com.route.islamic41.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.route.islamic41.R
import com.route.islamic41.ui.home.hadeth.HadethFragment
import com.route.islamic41.ui.home.quran.QuranFragment
import com.route.islamic41.ui.home.radio.RadioFragment
import com.route.islamic41.ui.home.tasbeh.TasbehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNav = findViewById(R.id.navigation_home)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_quran -> {
                    showTab(QuranFragment())
                }

                R.id.navigation_hadeth -> {
                    showTab(HadethFragment())
                }

                R.id.navigation_radio -> {
                    showTab(RadioFragment())
                }

                R.id.navigation_tasbeh -> {
                    showTab(TasbehFragment())
                }
            }

            return@setOnItemSelectedListener true
        }
        bottomNav.selectedItemId = R.id.navigation_quran
    }

    fun showTab(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
