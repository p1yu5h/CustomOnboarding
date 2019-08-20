package com.example.android.custompagertransformer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PageFragment.newInstance(
                pageTypeEven,
                R.drawable.page_one_img_top,
                R.drawable.page_one_img_bottom,
                R.string.page_one_text_top,
                R.string.page_one_text_bottom
            )
            1 -> PageFragment.newInstance(
                pageTypeOdd,
                R.drawable.page_two_img_top,
                R.drawable.page_two_img_bottom,
                R.string.page_two_text_top,
                R.string.page_two_text_bottom
            )
            2 -> PageFragment.newInstance(
                pageTypeEven,
                R.drawable.page_three_img_top,
                R.drawable.page_three_img_bottom,
                R.string.page_three_text_top,
                R.string.page_three_text_bottom
            )
            else -> return PageFragment.newInstance(
                pageTypeEven,
                R.drawable.page_one_img_top,
                R.drawable.page_one_img_bottom,
                R.string.page_one_text_top,
                R.string.page_one_text_bottom
            )
        }
    }

    override fun getCount(): Int {
        return 3
    }

    companion object {
        const val pageTypeEven: Int = 0
        const val pageTypeOdd: Int = 1
    }
}