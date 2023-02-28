package com.nandro.randomgame.Views.rock_paper_scissors_game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nandro.randomgame.R
import com.nandro.randomgame.Views.rock_paper_scissors_game.RockPaperScissorsFragment.Companion.isPaperSelected
import com.nandro.randomgame.Views.rock_paper_scissors_game.RockPaperScissorsFragment.Companion.isRockSelected
import com.nandro.randomgame.Views.rock_paper_scissors_game.RockPaperScissorsFragment.Companion.isScissorsSelected
import com.nandro.randomgame.Views.rock_paper_scissors_game.RockPaperScissorsFragment.Companion.scramble
import com.nandro.randomgame.databinding.FragmentRockPaperResultBinding

class RockPaperResultFragment : Fragment() {
    lateinit var binding: FragmentRockPaperResultBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRockPaperResultBinding.inflate(inflater, container, false)
        val view = binding.root

        if (isRockSelected) {
            binding.rockPaperScissorsImage.setImageResource(R.drawable.batu)
        }
        if (isPaperSelected) {
            binding.rockPaperScissorsImage.setImageResource(R.drawable.kertas)
        }
        if (isScissorsSelected) {
            binding.rockPaperScissorsImage.setImageResource(R.drawable.gunting)
        }
        if (scramble == "Rock") {
            binding.tandaTanyaImage.setImageResource(R.drawable.batu)
        }
        if (scramble == "Paper") {
            binding.tandaTanyaImage.setImageResource(R.drawable.kertas)
        }
        if (scramble == "Scissors") {
            binding.tandaTanyaImage.setImageResource(R.drawable.gunting)
        }

        if (isRockSelected == true && scramble == "Paper") {
            binding.wonLoseMessage.text = "YOU LOSE!!"
            binding.wonLoseDescription.text = "Paper Beat Rock"
        } else if (isRockSelected == true && scramble == "Scissors") {
            binding.wonLoseMessage.text = "YOU WIN!!"
            binding.wonLoseDescription.text = "Rock Beat Scissors"
        } else if (isPaperSelected == true && scramble == "Rock") {
            binding.wonLoseMessage.text = "YOU WIN!!"
            binding.wonLoseDescription.text = "Paper Beat Rock"
        } else if (isPaperSelected == true && scramble == "Scissors") {
            binding.wonLoseMessage.text = "YOU LOSE!!"
            binding.wonLoseDescription.text = "Scissors Beat Paper"
        } else if (isScissorsSelected == true && scramble == "Rock") {
            binding.wonLoseMessage.text = "YOU LOSE!!"
            binding.wonLoseDescription.text = "Rock Beat Scissors"
        } else if (isScissorsSelected == true && scramble == "Paper") {
            binding.wonLoseMessage.text = "YOU WIN!!"
            binding.wonLoseDescription.text = "Scissors Beat Paper"
        } else {
            binding.wonLoseMessage.text = "DRAW!!"
            binding.wonLoseDescription.text = ""
        }


        binding.startButton.setOnClickListener {
            findNavController().navigate(R.id.action_rockPaperResultFragment_to_rockPaperScissorsFragment)
        }

        return view
    }

}