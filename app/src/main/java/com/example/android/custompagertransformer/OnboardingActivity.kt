package com.example.android.custompagertransformer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewPager()
    }

    private fun setupViewPager() {
        val viewPager : ViewPager = findViewById(R.id.viewpager)
        viewPager.adapter = PageAdapter(supportFragmentManager)
        viewPager.setPageTransformer(true, CustomPageTransformer())
    }
}
