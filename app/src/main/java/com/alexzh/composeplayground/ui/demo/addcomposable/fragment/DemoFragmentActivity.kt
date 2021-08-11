package com.alexzh.composeplayground.ui.demo.addcomposable.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexzh.composeplayground.R

class DemoFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcomposable_demo)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DemoFragment())
                .commitNow()
        }
    }
}