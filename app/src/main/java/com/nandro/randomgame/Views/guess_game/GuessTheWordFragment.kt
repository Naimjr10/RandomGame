package com.nandro.randomgame.Views.guess_game

import android.content.DialogInterface
import android.opengl.Visibility
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.nandro.randomgame.R
import com.nandro.randomgame.databinding.FragmentGuessTheWordBinding
import kotlin.properties.Delegates

class GuessTheWordFragment : Fragment() {
    lateinit var binding: FragmentGuessTheWordBinding

    val wordList = listOf("Kangaroo", "Chicken", "Cow", "Cat", "Giraffe", "Gorilla", "Shark")
    val wordToGuess = wordList.random().uppercase()
    var incorrectGuesses = ""
    var livesLeft = wordToGuess.length + 3
    var oldGuessedLetter = ""
    var wordGuessingResult = ""
//    var isRevealed = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize Binding, get the root of the layout and Inflate it
        binding = FragmentGuessTheWordBinding.inflate(inflater, container, false)
        val view = binding.root


        onGuessingScreen()

        binding.guessButton.setOnClickListener {

            makeGuessAndUpdateScreen(binding.letterInputEditText.text.toString().uppercase())
            isWon()
            isLost()

        }

        return view
    }

    /*
    fun updateScreen() {

    }

     */

    fun onGuessingScreen() {
        // Make Views invisible
        binding.wonLostMessageTextView.isInvisible = true
        binding.revealOrNewButton.isInvisible = true
        binding.wordToGuessTextView.text = "_".repeat(wordToGuess.length)



        binding.livesLeftTextView.text = "You have $livesLeft lives left"
        binding.clueBodyTextView.text = generateClue()
    }

    fun onWonLostScreen() {
        // Make Views invisible
        binding.letterInputEditText.isInvisible = true
        binding.guessButton.isInvisible = true
        binding.clueHeaderTextView.isInvisible = true
        binding.clueBodyTextView.isInvisible = true

        // Make Views Visible
        binding.wordToGuessTextView.text = wordToGuess
        updateImageView()
        binding.wonLostMessageTextView.isVisible = true
        binding.revealOrNewButton.isVisible = true
        // When got clicked, it will reset the state and back on guessing screen (New game)
        binding.revealOrNewButton.setOnClickListener {
            findNavController().navigate(R.id.action_guessTheWordFragment_self)
        }

    }

    fun isLost() {
        if (livesLeft < 1) {
            binding.wonLostMessageTextView.text = "YOU LOST!! The word was $wordToGuess"
            onWonLostScreen()

        }
    }

    private fun isWon() {
        if (binding.wordToGuessTextView.text == wordToGuess) {
            binding.wonLostMessageTextView.text = "YOU WON!! The word was $wordToGuess"
            onWonLostScreen()

        }
    }

    fun updateImageView() {
        if (wordToGuess == "KANGAROO") {
            binding.imageToGuessImageView.setImageResource(R.drawable.chad_kangaroo)
        }
        if (wordToGuess == "CHICKEN") {
            binding.imageToGuessImageView.setImageResource(R.drawable.chicken)
        }
        if (wordToGuess == "COW") {
            binding.imageToGuessImageView.setImageResource(R.drawable.cooooow_copy)
        }
        if (wordToGuess == "CAT") {
            binding.imageToGuessImageView.setImageResource(R.drawable.cute_cat_2)
        }
        if (wordToGuess == "GIRAFFE") {
            binding.imageToGuessImageView.setImageResource(R.drawable.giraffe)
        }
        if (wordToGuess == "GORILLA"){
            binding.imageToGuessImageView.setImageResource(R.drawable.gorilla)
        }
        if (wordToGuess == "SHARK") {
            binding.imageToGuessImageView.setImageResource(R.drawable.shark)
        }

    }

    fun generateClue(): String {
        if (wordToGuess == "KANGAROO") {
            return "Animals that can knock out your teeth"
        } else if (wordToGuess == "CHICKEN") {
            return "KFC Restaurant"
        } else if (wordToGuess == "COW") {
            return "A grass-eating mammal that can read"
        } else if (wordToGuess == "CAT") {
            return "The cutest animal in the world"
        } else if (wordToGuess == "GIRAFFE") {
            return "Living things with long necks"
        } else if (wordToGuess == "GORILLA"){
            return "Human ancestor, maybe ¯\\_(ツ)_/¯"
//            U+1F644
        } else {
            return "Baby _____ , doo-doo, doo-doo, doo-doo"
        }
    }

    fun makeGuessAndUpdateScreen(letterInput: String) {
        // Check if the letter input has been filled
        if (letterInput.length == 1) {

            // Check if the letter input is in wordToGuess
            if ( letterInput in wordToGuess ) {
                var loop = 0

                // Scan wordToGuess
                for (letter in wordToGuess) {

//                        Toast.makeText(activity, "Letter ${++loop} replaced by", Toast.LENGTH_SHORT).show()

                    // Check if letter in wordToGuess is in guessedLetter
                    if (letter in oldGuessedLetter)  {
//                            Toast.makeText(activity, "Old guessed letter", Toast.LENGTH_SHORT).show()

                        // Scan guessedLetter
                        for (i in oldGuessedLetter) {
                            // if letter in wordToGuess equal to letter in guessedLetter, add it to the result
                            if (letter == i) {
                                wordGuessingResult += i
                            }
                        }
                    } else if (letter.toString() == letterInput ) {
//                        Toast.makeText(activity, "New guessed letter, and save the old guessed letter", Toast.LENGTH_SHORT).show()
                        wordGuessingResult += letterInput
                        oldGuessedLetter += letterInput
                    } else {
//                        Toast.makeText(activity, "Underscore (hidden)", Toast.LENGTH_SHORT).show()
                        wordGuessingResult += "_"
                    }

                }
                binding.wordToGuessTextView.text = wordGuessingResult
                wordGuessingResult = ""
            } else {
//                Toast.makeText(activity, "Wrong!", Toast.LENGTH_SHORT).show()
                incorrectGuesses += "$letterInput "
                binding.incorrectGuessesTextView.text = "Incorrect guesses : ${ incorrectGuesses }"
                binding.livesLeftTextView.text = "You have ${--livesLeft} lives left"
            }

        }

    }

}

            /*
            findNavController().navigate(R.id.action_guessTheWordFragment_self)
            val alertDialog = AlertDialog.Builder(activity as AppCompatActivity)

            alertDialog.setMessage("Are you sure want to reveal?")
            alertDialog.setNegativeButton("No", DialogInterface.OnClickListener {
                    dialog, which -> Toast.makeText(activity,"Asu angel tenan", Toast.LENGTH_SHORT).show() } )

            alertDialog.setPositiveButton("Yes", DialogInterface.OnClickListener {
                    dialog, which -> Toast.makeText(activity,"Asu angel", Toast.LENGTH_SHORT).show() } )

            alertDialog.show()
             */

        /*
        if (isRevealed == true) {
            Toast.makeText(activity, "Revealed == True", Toast.LENGTH_SHORT).show()
        } else {

            Toast.makeText(activity, "Revealed == False", Toast.LENGTH_SHORT).show()
            binding.revealOrNewButton.text = "Reveal the word"
            binding.revealOrNewButton.setOnClickListener {
                Toast.makeText(activity, "Reveal got Clicked", Toast.LENGTH_SHORT).show()
                isRevealed = true
                Toast.makeText(activity, "Revealed is $isRevealed", Toast.LENGTH_SHORT).show()
            }

        }
         */