package com.example.voltorbflip

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class GameOverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        var scoreText: TextView = findViewById(R.id.score_text)

        val intent = intent
        val str = intent.getStringExtra("message_key")
        scoreText.text = str

        val switchToGame: Button = findViewById(R.id.play_again_button)
        switchToGame.setOnClickListener {
            val intentGameActivity = Intent(this, GameActivity::class.java)
            startActivity(intentGameActivity)
        }

        val saveScore: Button = findViewById(R.id.save_score_button)
        saveScore.setOnClickListener {
            val intentScoreActivity = Intent(this, ScoreActivity::class.java)
            intentScoreActivity.putExtra("score", str)
            startActivity(intentScoreActivity)
        }
    }
}