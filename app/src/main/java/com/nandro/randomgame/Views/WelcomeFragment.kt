package com.nandro.randomgame.Views

import android.app.StatusBarManager
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.nandro.randomgame.R
import com.nandro.randomgame.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val view = binding.root


        // Navigate to Color Generator Game
        binding.colorGeneratorButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_colorGeneratorFragment)
        }

        // Navigate to Guess The Word Game
        binding.guessTheWordButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_guessTheWordFragment)
        }

        // Navigate to Rock Paper Scissors Game
        binding.rockPaperScissorsButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_rockPaperScissorsFragment)
        }

        return view
    }

}