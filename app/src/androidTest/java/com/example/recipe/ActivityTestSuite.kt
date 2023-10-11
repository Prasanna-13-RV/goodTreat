package com.example.recipe

import com.example.recipe.ui.MainActivity
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses


@RunWith(Suite::class)
@SuiteClasses(
    MainActivity::class,
)
class ActivityTestSuite  {
}