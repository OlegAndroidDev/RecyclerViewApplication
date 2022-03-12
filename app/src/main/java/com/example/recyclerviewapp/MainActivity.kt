package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewapp.views.FirstFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.main_frag_container,FirstFragment.newInstance("",""))
//            .addToBackStack("firstFragment")
//            .commit()
        fragmentNavigation(supportFragmentManager, FirstFragment.newInstance("", ""))
    }
}