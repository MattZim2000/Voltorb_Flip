package com.example.voltorbflip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.voltorbflip.ui.theme.VoltorbFlipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        // Temporary High Score Idea: An array holding scores for the current game session.

        // Other Potential Idea: View Models & Live Data?

        // TODO: Create an empty array of 25 length.

        // TODO: Create an Integer var to hold the ever changing score.
    }

    // TODO: Create the startGame method for restarts and to begin the game.
    // fun startGame(Array) {
    // Randomly select 0 (Voltorb Bomb), 1, 2, or 3 for each element.
// }

    // TODO: Create the flipTile method for onClickListeners to simply the code.
    // fun flipTile(Integer from Array) {}
}

