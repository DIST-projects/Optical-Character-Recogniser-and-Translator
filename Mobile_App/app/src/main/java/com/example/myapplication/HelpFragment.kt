package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HelpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HelpFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var v : View
    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter
    private lateinit var indicatorsContainer: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view : View
        view = inflater.inflate(R.layout.fragment_help, container, false)
        v = view
        setOnBoardingItems()
        setupIndicator()
        setCurrentIndicator(0)
        return view

    }


    private fun setOnBoardingItems() {
        onboardingItemsAdapter = OnboardingItemsAdapter(
                listOf(
                        OnboardingItem(
                                onboardingImage = R.drawable.click,
                                title = "Take a Picture",
                                description = "Click a picture of any sign board you see. Make Sure that the entire image is captured."

                        ),

                        OnboardingItem(
                                onboardingImage = R.drawable.uploading,
                                title = "Upload Image",
                                description = "After Capturing the image, upload the image to the server."

                        ),
                        OnboardingItem(
                                onboardingImage = R.drawable.wait,
                                title = "Be Patient and Wait",
                                description = "Please wait for a few seconds while our servers work for a quick and robust solution."
                        ),
                OnboardingItem(
                                onboardingImage = R.drawable.receive,
                        title = "Receive The Translated meaning",
                description =  "Our servers will give the most suitable and relevant answers. If you want to continue uploading feel free to do so."
                ),
                        OnboardingItem(
                                onboardingImage = R.drawable.feedback,
                                title = "Feed backs",
                                description = "Feel free to contact us if you feel like. Our users are our greatest source of learning. Have a pleasant journey!!!."
                        )

                )
        )

        val onboardingViewPager = v!!.findViewById<ViewPager2>(R.id.onboardingViewPager)
        onboardingViewPager.adapter = onboardingItemsAdapter
        onboardingViewPager.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER
        v!!.findViewById<ImageView>(R.id.imageNext).setOnClickListener {
            if (onboardingViewPager.currentItem + 1 < onboardingItemsAdapter.itemCount){
                onboardingViewPager.currentItem += 1
            }
        }

    }


    private fun setupIndicator(){
        indicatorsContainer = v!!.findViewById(R.id.indicatorsContainer)
        val indicators = arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(14,70,14,70) //left = 14 top=70 right=14 bottom=70
        for (i in indicators.indices){
            indicators[i] = ImageView(requireContext().applicationContext)   //CHANGED
            indicators[i]?.let {
                it.setImageDrawable(
                        ContextCompat.getDrawable(
                              // requireActivity().application,
                                requireContext().applicationContext,
                                R.drawable.indicator_inactive_background
                        )
                )

                it.layoutParams = layoutParams
                indicatorsContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicator(position: Int){
        val childCount = indicatorsContainer.childCount
        for(i in 0 until childCount){
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if(i == position){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                                //requireActivity().application,
                                requireContext().applicationContext,
                                R.drawable.indicator_active_background
                        )
                )
            }
            else
            {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                                //requireActivity().application,
                                requireContext().applicationContext,
                                R.drawable.indicator_inactive_background
                        )
                )
            }
        }
    }













    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HelpFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                HelpFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}