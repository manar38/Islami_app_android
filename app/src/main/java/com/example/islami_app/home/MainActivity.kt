package com.example.islami_app.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami_app.R
import com.example.islami_app.databinding.ActivityMainBinding
import com.example.islami_app.home.tabs.hadith.HadithFragment
import com.example.islami_app.home.tabs.quran.QuranFragment
import com.example.islami_app.home.tabs.RadioFragment
import com.example.islami_app.home.tabs.TasbehFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavView.setOnItemSelectedListener { menuItem ->
           // binding.bottomNavView.selectedItemId = R.id.nav_quran
            var fragment: Fragment = when (menuItem.itemId) {
                R.id.nav_quran -> {
                    QuranFragment()
                }

                R.id.nav_hadith -> {
                    HadithFragment()
                }

                R.id.nav_sebha -> {
                    TasbehFragment()

                }

                R.id.nav_radio -> {
                    RadioFragment()
                }

                else -> {
                    RadioFragment()
                }
            }
            showFragment(fragment)
            return@setOnItemSelectedListener true
        }
    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}