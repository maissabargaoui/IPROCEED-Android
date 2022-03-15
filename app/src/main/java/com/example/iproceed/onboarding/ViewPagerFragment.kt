package com.example.iproceed.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iproceed.R
import com.example.iproceed.onboarding.screens.FirstScreen
import com.example.iproceed.onboarding.screens.SecondScreen
import com.example.iproceed.onboarding.screens.ThirdScreen
import kotlinx.android.synthetic.main.fragment_view_pager2.view.*



class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager2, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()

        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        view.viewPager2.adapter = adapter

        return view
    }

}