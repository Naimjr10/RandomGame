package com.nandro.randomgame.Views.rock_paper_scissors_game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.navigation.fragment.findNavController
import com.nandro.randomgame.R
import com.nandro.randomgame.Views.rock_paper_scissors_game.RockPaperScissorsFragment.Companion.computerImage
import com.nandro.randomgame.Views.rock_paper_scissors_game.RockPaperScissorsFragment.Companion.isPaperSelected
import com.nandro.randomgame.Views.rock_paper_scissors_game.RockPaperScissorsFragment.Companion.isRockSelected
import com.nandro.randomgame.Views.rock_paper_scissors_game.RockPaperScissorsFragment.Companion.isScissorsSelected

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

        updatePlayerImage()
        updateComputerImage()

        updateWonLostText()

        // Start a new game
        binding.startButton.setOnClickListener {
            findNavController().navigate(R.id.action_rockPaperResultFragment_to_rockPaperScissorsFragment)
        }

        return view
    }

    fun updatePlayerImage() {
        if (isRockSelected) {
            binding.rockPaperScissorsImage.setImageResource(R.drawable.batu)
        }
        if (isPaperSelected) {
            binding.rockPaperScissorsImage.setImageResource(R.drawable.kertas)
        }
        if (isScissorsSelected) {
            binding.rockPaperScissorsImage.setImageResource(R.drawable.gunting)
        }
    }

    fun updateComputerImage() {
        if (computerImage == "Rock") {
            binding.tandaTanyaImage.setImageResource(R.drawable.batu)
        }
        if (computerImage == "Paper") {
            binding.tandaTanyaImage.setImageResource(R.drawable.kertas)
        }
        if (computerImage == "Scissors") {
            binding.tandaTanyaImage.setImageResource(R.drawable.gunting)
        }
    }

    fun updateWonLostText() {
        if (isRockSelected == true && computerImage == "Paper") {
            binding.wonLostMessage.text = "YOU LOSE!!"
            binding.wonLoseDescription.text = "Paper Beat Rock"
        } else if (isRockSelected == true && computerImage == "Scissors") {
            binding.wonLostMessage.text = "YOU WIN!!"
            binding.wonLoseDescription.text = "Rock Beat Scissors"
        } else if (isPaperSelected == true && computerImage == "Rock") {
            binding.wonLostMessage.text = "YOU WIN!!"
            binding.wonLoseDescription.text = "Paper Beat Rock"
        } else if (isPaperSelected == true && computerImage == "Scissors") {
            binding.wonLostMessage.text = "YOU LOSE!!"
            binding.wonLoseDescription.text = "Scissors Beat Paper"
        } else if (isScissorsSelected == true && computerImage == "Rock") {
            binding.wonLostMessage.text = "YOU LOSE!!"
            binding.wonLoseDescription.text = "Rock Beat Scissors"
        } else if (isScissorsSelected == true && computerImage == "Paper") {
            binding.wonLostMessage.text = "YOU WIN!!"
            binding.wonLoseDescription.text = "Scissors Beat Paper"
        } else {
            binding.wonLostMessage.text = "DRAW!!"
//            binding.wonLoseDescription.text = ""
            binding.wonLoseDescription.isInvisible = true
        }
    }

}