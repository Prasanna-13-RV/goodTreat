package com.example.recipe.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import com.example.recipe.R
import com.example.recipe.databinding.ActivityMainBinding
import com.example.recipe.ui.fragment.firebase.MyRecipeFragment
import com.example.recipe.ui.fragment.remote.ShowRecipesFragment
import com.example.recipe.viewmodel.RecipeViewModel
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        toolbar.menu.hasVisibleItems()

        // Set the Toolbar as the ActionBar
//        val activity = requireActivity() as AppCompatActivity
        this.setSupportActionBar(toolbar)

        // Enable the back button
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Handle the back button click event
        toolbar.setNavigationOnClickListener {
            // Define your back button functionality here
            // For example, you can pop the fragment from the back stack
            this.onBackPressed()
        }

        binding.myTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    when (it.position) {
                        0 -> replaceFragment(ShowRecipesFragment(), "All Recipe")
                        1 -> replaceFragment(MyRecipeFragment(), "My Recipe")
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        replaceFragment(ShowRecipesFragment(), "All Recipe")
    }

    private fun replaceFragment(fragment: Fragment, string: String) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
        title = string

    }


}