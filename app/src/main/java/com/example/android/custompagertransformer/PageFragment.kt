package com.example.android.custompagertransformer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class PageFragment(
    private val pageType: Int,
    private val topImageId: Int,
    private val bottomImageId: Int,
    private val topTextId: Int,
    private val bottomTextId: Int
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate Layout based on Page Type
        val view: View = if (pageType == PageAdapter.pageTypeEven) inflater.inflate(
            R.layout.fragment_page,
            container,
            false
        ) else inflater.inflate(R.layout.fragment_page_alt, container, false)
        //Set Top Text
        val topTextView: TextView = view.findViewById(R.id.top_text)
        topTextView.text = getString(topTextId)
        //Set Top Image
        val topImageView: ImageView = view.findViewById(R.id.top_image)
        topImageView.setImageResource(topImageId)
        //Set Bottom Image
        val bottomImageView: ImageView = view.findViewById(R.id.bottom_image)
        bottomImageView.setImageResource(bottomImageId)
        //Set Top Text
        val bottomTextView: TextView = view.findViewById(R.id.bottom_text)
        bottomTextView.text = getString(bottomTextId)
        return view
    }

    companion object {
        fun newInstance(pageType: Int, topImageId: Int, bottomImageId: Int, topTextId: Int, bottomTextId: Int) =
            PageFragment(pageType, topImageId, bottomImageId, topTextId, bottomTextId)
    }
}
