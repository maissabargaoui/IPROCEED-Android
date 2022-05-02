package com.example.iproceed

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay


class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler().postDelayed({
            var sharedPrefs = requireActivity().getSharedPreferences(getString(R.string.user), Context.MODE_PRIVATE)
            val token = sharedPrefs.getString(getString(R.string.token),null)

            if(token != null){
                println(token)
                val intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)
            }
            else
            {
                if(onBoardingFinished()){
                    findNavController().navigate(R.id.action_splashFragment_to_loginActivity2)
                }else{
                    findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
                }
            }}, 3000)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }

}