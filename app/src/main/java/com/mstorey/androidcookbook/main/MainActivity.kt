package com.mstorey.androidcookbook.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mstorey.androidcookbook.R
import com.mstorey.androidcookbook.main.examples.layout.LayoutExamplesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.main_container, LayoutExamplesFragment()).commit()
    }
}
