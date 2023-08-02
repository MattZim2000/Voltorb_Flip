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

        scoreViewModel.allScores.observe(this) { scores ->
            scores.let { adapter.submitList(it) }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newScoreActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(NewScoreActivity.EXTRA_REPLY)?.let { reply ->
                val score = Score(12, reply.toInt())
                scoreViewModel.insert(score)
            }
        } else {
            Toast.makeText(
                applicationContext,
                "Empty not saved",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}