package com.example.voltorbflip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
import java.util.prefs.Preferences

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        val switchToGame: Button = findViewById(R.id.play_button)
        switchToGame.setOnClickListener {
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            startActivity(intent)
        }

        //switch to high score layout on click
        val highScoreButton: Button = findViewById(R.id.score_button)
        highScoreButton.setOnClickListener { setContentView(R.layout.high_scores) }


        //temp button to test the dynamic button builder
        val muteButton: Button = findViewById(R.id.mute_button)
        muteButton.setOnClickListener {
            val intent = Intent(this, DynamicButtons::class.java)
            startActivity(intent)
        }
        // Temporary High Score Idea: An array holding scores for the current game session.

        // Other Potential Idea: View Models & Live Data?

    }
}

