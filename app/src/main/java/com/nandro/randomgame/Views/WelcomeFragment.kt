package com.nandro.randomgame.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.nandro.randomgame.R

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        val colorButton = view.findViewById<MaterialButton>(R.id.color_generator_button)
        colorButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_colorGeneratorFragment)
        }
        return view
    }

}