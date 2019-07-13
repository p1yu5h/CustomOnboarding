package com.example.android.custompagertransformer

import android.view.View
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs


class CustomPageTransformer : ViewPager.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        val pageHeight = page.height
        val imgTop : ImageView = page.findViewById(R.id.top_image)
        val imgBottom : ImageView = page.findViewById(R.id.bottom_image)

        if (position <= -1.0f || position >= 1.0f) {
            imgTop.translationX = pageWidth * position
            imgTop.alpha = 0.0f
            imgBottom.translationX = pageWidth * position
            imgBottom.alpha = 0.0f
        } else if (position == 0.0f) {
            imgTop.translationX = pageWidth * position
            imgTop.alpha = 1.0f
            imgBottom.translationX = pageWidth * position
            imgBottom.alpha = 1.0f
        } else {
            // position is between -1.0f & 0.0f OR 0.0f & 1.0f
            imgTop.translationX = -position * pageWidth
            imgTop.translationY = position * pageHeight
            imgTop.alpha = 1.0f - 5 * abs(position)

            imgBottom.translationX = -position * pageWidth
            imgBottom.translationY = -position * pageHeight
            imgBottom.alpha = 1.0f - 5 * abs(position)
        }
    }
}