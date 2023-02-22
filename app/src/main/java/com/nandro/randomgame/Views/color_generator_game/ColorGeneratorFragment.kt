package com.nandro.randomgame.Views.color_generator_game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.nandro.randomgame.R

class ColorGeneratorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_color_generator, container, false)
        val homeButton = view.findViewById<MaterialButton>(R.id.home_button)
        homeButton.setOnClickListener {
            findNavController().navigate(R.id.action_colorGeneratorFragment_to_welcomeFragment)
        }

        return view
    }
}