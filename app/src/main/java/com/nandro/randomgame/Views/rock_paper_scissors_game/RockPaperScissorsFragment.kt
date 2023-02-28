package com.nandro.randomgame.Views.rock_paper_scissors_game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.nandro.randomgame.R
import com.nandro.randomgame.databinding.FragmentRockPaperScissorsBinding

class RockPaperScissorsFragment : Fragment() {
    lateinit var binding: FragmentRockPaperScissorsBinding

    companion object {

        var isRockSelected = false
        var isPaperSelected = false
        var isScissorsSelected = false

        val listRockPaperScissors = listOf("Rock", "Paper", "Scissors")
        lateinit var scramble: String
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentRockPaperScissorsBinding.inflate(inflater, container, false)
        val view = binding.root

        /*
        if (binding.radioRock.isChecked) {
            isRockSelected = true
            isPaperSelected = false
            isScissorsSelected = false
        }
        if (binding.radioPaper.isChecked) {
            isRockSelected = false
            isPaperSelected = true
            isScissorsSelected = false
        }
        if (binding.radioPaper.isSelected) {
            isRockSelected = false
            isPaperSelected = false
            isScissorsSelected = true
        }
         */

        binding.radioRock.setOnClickListener {
            isRockSelected = true
            isPaperSelected = false
            isScissorsSelected = false
            scramble = listRockPaperScissors.random()
        }

        binding.radioPaper.setOnClickListener {
            isRockSelected = false
            isPaperSelected = true
            isScissorsSelected = false
            scramble = listRockPaperScissors.random()
        }

        binding.radioScissors.setOnClickListener {
            isRockSelected = false
            isPaperSelected = false
            isScissorsSelected = true
            scramble = listRockPaperScissors.random()
        }

        binding.startButton.setOnClickListener {

            if (isRockSelected == false && isPaperSelected == false && isScissorsSelected == false) {
                Toast.makeText(activity, "Please choose at least one of three option above",
                Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(R.id.action_rockPaperScissorsFragment_to_rockPaperResultFragment)
            }

        }

        return view
    }

    // Reset The State to the Beginning
    // if we not override this, it still have the previous state
    override fun onDestroyView() {
        super.onDestroyView()
        isRockSelected = false
        isPaperSelected = false
        isScissorsSelected = false
    }

}