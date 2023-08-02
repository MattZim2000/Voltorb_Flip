package com.example.voltorbflip

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ScoreActivity : ComponentActivity() {
    private val newScoreActivityRequestCode = 1
    private val scoreViewModel: ScoreViewModel by viewModels {
        ScoreViewModelFactory((application as ScoresApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.high_scores)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = ScoreListAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val intent = intent
        if(intent != null) {
            if (intent.hasExtra("score")) {
                val str = intent.getStringExtra("score")!!.toInt()

                scoreViewModel.insert(Score(str, str))
            }
        }

        scoreViewModel.allScores.observe(this) { scores ->
            scores.let { adapter.submitList(it) }
        }
    }
}