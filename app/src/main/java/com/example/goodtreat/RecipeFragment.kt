package com.example.goodtreat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.goodtreat.R
import com.example.goodtreat.databinding.FragmentRecipeBinding

class RecipeFragment : Fragment() {
    private lateinit var binding : FragmentRecipeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeBinding.inflate(inflater, container, false)
        binding.constraintLayout1.setOnClickListener {
            it.findNavController().navigate(R.id.action_recipeFragment_to_spaghettiFragment)
        }
        binding.constraintLayout2.setOnClickListener {
            it.findNavController().navigate(R.id.action_recipeFragment_to_fluffyScrambledFragment)
        }
        binding.constraintLayout3.setOnClickListener {
            it.findNavController().navigate(R.id.action_recipeFragment_to_cinnamonRollsFragment)
        }
        binding.constraintLayout4.setOnClickListener {
            it.findNavController().navigate(R.id.action_recipeFragment_to_mayoChickenFragment)
        }
        binding.constraintLayout5.setOnClickListener {
            it.findNavController().navigate(R.id.action_recipeFragment_to_marzettiFragment)
        }
        binding.constraintLayout6.setOnClickListener {
            it.findNavController().navigate(R.id.action_recipeFragment_to_kalbibbqFragment)
        }
        binding.constraintLayout7.setOnClickListener {
            it.findNavController().navigate(R.id.action_recipeFragment_to_bbqGalbiFragment)
        }
        binding.constraintLayout8.setOnClickListener {
            it.findNavController().navigate(R.id.action_recipeFragment_to_gyroMeatFragment)
        }
        binding.constraintLayout9.setOnClickListener {
            it.findNavController().navigate(R.id.action_recipeFragment_to_burgersFragment)
        }
        binding.constraintLayout10.setOnClickListener {
            it.findNavController().navigate(R.id.action_recipeFragment_to_lambStewFragment)
        }
        return binding.root
    }
}