package com.practice.dagger2practice.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practice.dagger2practice.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState ?: supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, OptionsFragment())
            .commit()
    }
}