package com.mojoboxx.vistaraworld

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.mojoboxx.vistaraworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var button: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //set the initial fragment
        replaceFragment(HomeFragment())
        binding.apply {
            navBar.apply {
                button = listOf(cabBtn, clubVistaraBtn, cvMallBtn, hotelBtn, playBtn)
                button.setSelectedBackground(playBtn)
            }
        }
        setBottomNavBar()
    }

    private fun setBottomNavBar() {
        binding.apply {
            navBar.apply {
                cabBtn.setOnClickListener {
                    replaceFragment(CabFragment())
                    button.setSelectedBackground(cabBtn)
                }
                clubVistaraBtn.setOnClickListener {
                    replaceFragment(ClubVistaraFragment())
                    button.setSelectedBackground(clubVistaraBtn)
                }
                cvMallBtn.setOnClickListener {
                    replaceFragment(CVMallFragment())
                    button.setSelectedBackground(cvMallBtn)
                }
                hotelBtn.setOnClickListener {
                    replaceFragment(HotelFragment())
                    button.setSelectedBackground(hotelBtn)
                }
                playBtn.setOnClickListener {
                    replaceFragment(HomeFragment())
                    button.setSelectedBackground(playBtn)
                }
            }
        }
    }

    //For replace the fragment
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    //For change selected button background colour
    private fun Collection<Button>.setSelectedBackground(selectedButton: Button) {
        for (button in this) {
            val isSelected = (button == selectedButton)
            button.apply {
                backgroundTintList = when {
                    isSelected -> {
                        getColorStateList(R.color.white)
                    }
                    else -> {
                        getColorStateList(R.color.bg_btn)
                    }
                }
            }
            button.isActivated = isSelected
        }
    }
}