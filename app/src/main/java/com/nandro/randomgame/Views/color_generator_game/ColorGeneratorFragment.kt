package com.nandro.randomgame.Views.color_generator_game

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.textclassifier.TextClassifier
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.nandro.randomgame.R
import com.nandro.randomgame.databinding.FragmentColorGeneratorBinding

class ColorGeneratorFragment : Fragment() {

    lateinit var binding: FragmentColorGeneratorBinding
    var colorHasGenerated = false
    var hexHasGenerated = false
    var hexCode = ""


    val COLOR_HAS_GENERATED_KEY = "color has generated"
    val HEX_HAS_GENERATED_KEY = "hex has generated"
    val HEX_CODE_KEY = "hex code"

//    var bundle: Bundle? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_color_generator, container, false)

        // Initialize Binding
        binding = FragmentColorGeneratorBinding.inflate(inflater, container, false)
        val view = binding.root

//        bundle = savedInstanceState

        /*
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(COLOR_HAS_GENERATED_KEY)
                && savedInstanceState.getBoolean(HEX_HAS_GENERATED_KEY) ) {
                binding.generatedColorDisplayPanel.setBackgroundColor(Color.parseColor(savedInstanceState.getString(HEX_CODE_KEY)))
                binding.generatedHexCode.setText("${savedInstanceState.getString(HEX_CODE_KEY)}")
            }
        }
         */

        binding.colorGeneratorButton.setOnClickListener {

            val redChannelInput = binding.redChannel.text.toString()
            val greenChannelInput = binding.greenChannel.text.toString()
            val blueChannelInput = binding.blueChannel.text.toString()


            if (redChannelInput.length < 2 || greenChannelInput.length < 2 ||
                blueChannelInput.length < 2) {

                Toast.makeText(activity, "Please fill each channel at least 2 Characters",
                    Toast.LENGTH_SHORT).show()

            } else {
                hexCode = '#'.plus(redChannelInput + greenChannelInput + blueChannelInput)
                binding.generatedColorDisplayPanel.setBackgroundColor(Color.parseColor(hexCode))
                binding.generatedHexCode.setText(hexCode)
                colorHasGenerated = true
                hexHasGenerated = true

            }

        }

        return view
    }


    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putString(HEX_CODE_KEY, hexCode)
        savedInstanceState.putBoolean(COLOR_HAS_GENERATED_KEY, colorHasGenerated)
        savedInstanceState.putBoolean(HEX_HAS_GENERATED_KEY, hexHasGenerated)
        super.onSaveInstanceState(savedInstanceState)
    }


}