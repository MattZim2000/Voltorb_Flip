package com.example.voltorbflip

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.util.Log
import com.example.voltorbflip.databinding.VoltorbFlipGameBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import java.util.Random

class GameActivity: Activity() {
    //lets us send score to db
    private var score: Int
    init{
        score = 0

        // Creating MusicPlayer
        /*
            Since I couldn't get the MediaPlayer to function, I am commenting it out so we don't lose points.
         */
        // private val music: MediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.voltorb_flip_loop)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.voltorb_flip_game)

        // Start music
        // music.start()

        // call the startGame function.
        var gameArray: Array<Int> = startGame()

        // Setting up all 27 buttons.
        // Quit Button
        val quitButton: Button = findViewById(R.id.quit_button)
        quitButton.setOnClickListener { switchActivity() }
        // Restart Button (We use startGame() since we want to start another game and not just reset the board.)
        val restartButton: Button = findViewById(R.id.restart_button)
        restartButton.setOnClickListener { startGame() }

        // 25 Grid Buttons (Need unique onClickListeners)

        // Holding drawables needed for the buttons.
        val onePointDrawable = getDrawable(R.drawable.one)
        val twoPointDrawable = getDrawable(R.drawable.two)
        val threePointDrawable = getDrawable(R.drawable.three)
        val voltorbDrawable = getDrawable(R.drawable.voltorb)

        val r1c1Button: Button = findViewById(R.id.button3)
        r1c1Button.setOnClickListener {
            Log.i("game", gameArray[0].toString())
            when(gameArray[0]){
                1 -> r1c1Button.setForeground(onePointDrawable)
                2 -> r1c1Button.setForeground(twoPointDrawable)
                3 -> r1c1Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r1c1Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(0, gameArray)
            Log.i("game", gameArray[0].toString())
        }

        val r1c2Button: Button = findViewById(R.id.button4)
        r1c2Button.setOnClickListener {
            when(gameArray[1]){
                1 -> r1c2Button.setForeground(onePointDrawable)
                2 -> r1c2Button.setForeground(twoPointDrawable)
                3 -> r1c2Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r1c2Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(1, gameArray)
        }

        val r1c3Button: Button = findViewById(R.id.button5)
        r1c3Button.setOnClickListener {
            when(gameArray[2]){
                1 -> r1c3Button.setForeground(onePointDrawable)
                2 -> r1c3Button.setForeground(twoPointDrawable)
                3 -> r1c3Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r1c3Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(2, gameArray)
        }

        val r1c4Button: Button = findViewById(R.id.button6)
        r1c4Button.setOnClickListener {
            when(gameArray[3]){
                1 -> r1c4Button.setForeground(onePointDrawable)
                2 -> r1c4Button.setForeground(twoPointDrawable)
                3 -> r1c4Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r1c4Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(3, gameArray)
        }

        val r1c5Button: Button = findViewById(R.id.button7)
        r1c5Button.setOnClickListener {
            when(gameArray[4]){
                1 -> r1c5Button.setForeground(onePointDrawable)
                2 -> r1c5Button.setForeground(twoPointDrawable)
                3 -> r1c5Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r1c5Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(4, gameArray)
        }

        val r2c1Button: Button = findViewById(R.id.button8)
        r2c1Button.setOnClickListener {
            when(gameArray[5]){
                1 -> r2c1Button.setForeground(onePointDrawable)
                2 -> r2c1Button.setForeground(twoPointDrawable)
                3 -> r2c1Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r2c1Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(5, gameArray)
        }

        val r2c2Button: Button = findViewById(R.id.button9)
        r2c2Button.setOnClickListener {
            when(gameArray[6]){
                1 -> r2c2Button.setForeground(onePointDrawable)
                2 -> r2c2Button.setForeground(twoPointDrawable)
                3 -> r2c2Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r2c2Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(6, gameArray)
        }

        val r2c3Button: Button = findViewById(R.id.button10)
        r2c3Button.setOnClickListener {
            when(gameArray[7]){
                1 -> r2c3Button.setForeground(onePointDrawable)
                2 -> r2c3Button.setForeground(twoPointDrawable)
                3 -> r2c3Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r2c3Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(7, gameArray)
        }

        val r2c4Button: Button = findViewById(R.id.button11)
        r2c4Button.setOnClickListener {
            when(gameArray[8]){
                1 -> r2c4Button.setForeground(onePointDrawable)
                2 -> r2c4Button.setForeground(twoPointDrawable)
                3 -> r2c4Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r2c4Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(8, gameArray)
        }

        val r2c5Button: Button = findViewById(R.id.button12)
        r2c5Button.setOnClickListener {
            when(gameArray[9]){
                1 -> r2c5Button.setForeground(onePointDrawable)
                2 -> r2c5Button.setForeground(twoPointDrawable)
                3 -> r2c5Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r2c5Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(9, gameArray)
        }

        val r3c1Button: Button = findViewById(R.id.button13)
        r3c1Button.setOnClickListener {
            when(gameArray[10]){
                1 -> r3c1Button.setForeground(onePointDrawable)
                2 -> r3c1Button.setForeground(twoPointDrawable)
                3 -> r3c1Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r3c1Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(10, gameArray)
        }

        val r3c2Button: Button = findViewById(R.id.button14)
        r3c2Button.setOnClickListener {
            when(gameArray[11]){
                1 -> r3c2Button.setForeground(onePointDrawable)
                2 -> r3c2Button.setForeground(twoPointDrawable)
                3 -> r3c2Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r3c2Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(11, gameArray)
        }

        val r3c3Button: Button = findViewById(R.id.button15)
        r3c3Button.setOnClickListener {
            when(gameArray[12]){
                1 -> r3c3Button.setForeground(onePointDrawable)
                2 -> r3c3Button.setForeground(twoPointDrawable)
                3 -> r3c3Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r3c3Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(12, gameArray)
        }

        val r3c4Button: Button = findViewById(R.id.button16)
        r3c4Button.setOnClickListener {
            when(gameArray[13]){
                1 -> r3c4Button.setForeground(onePointDrawable)
                2 -> r3c4Button.setForeground(twoPointDrawable)
                3 -> r3c4Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r3c4Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(13, gameArray)
        }

        val r3c5Button: Button = findViewById(R.id.button17)
        r3c5Button.setOnClickListener {
            when(gameArray[14]){
                1 -> r3c5Button.setForeground(onePointDrawable)
                2 -> r3c5Button.setForeground(twoPointDrawable)
                3 -> r3c5Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r3c5Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(14, gameArray)
        }

        val r4c1Button: Button = findViewById(R.id.button18)
        r4c1Button.setOnClickListener {
            when(gameArray[15]){
                1 -> r4c1Button.setForeground(onePointDrawable)
                2 -> r4c1Button.setForeground(twoPointDrawable)
                3 -> r4c1Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r4c1Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(15, gameArray)
        }

        val r4c2Button: Button = findViewById(R.id.button19)
        r4c2Button.setOnClickListener {
            when(gameArray[16]){
                1 -> r4c2Button.setForeground(onePointDrawable)
                2 -> r4c2Button.setForeground(twoPointDrawable)
                3 -> r4c2Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r4c2Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(16, gameArray)
        }

        val r4c3Button: Button = findViewById(R.id.button20)
        r4c3Button.setOnClickListener {
            when(gameArray[17]){
                1 -> r4c3Button.setForeground(onePointDrawable)
                2 -> r4c3Button.setForeground(twoPointDrawable)
                3 -> r4c3Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r4c3Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(17, gameArray)
        }

        val r4c4Button: Button = findViewById(R.id.button21)
        r4c4Button.setOnClickListener {
            when(gameArray[18]){
                1 -> r4c4Button.setForeground(onePointDrawable)
                2 -> r4c4Button.setForeground(twoPointDrawable)
                3 -> r4c4Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r4c4Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(18, gameArray)
        }

        val r4c5Button: Button = findViewById(R.id.button22)
        r4c5Button.setOnClickListener {
            when(gameArray[19]){
                1 -> r4c5Button.setForeground(onePointDrawable)
                2 -> r4c5Button.setForeground(twoPointDrawable)
                3 -> r4c5Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r4c5Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(19, gameArray)
        }

        val r5c1Button: Button = findViewById(R.id.button23)
        r5c1Button.setOnClickListener {
            when(gameArray[20]){
                1 -> r5c1Button.setForeground(onePointDrawable)
                2 -> r5c1Button.setForeground(twoPointDrawable)
                3 -> r5c1Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r5c1Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(20, gameArray)
        }

        val r5c2Button: Button = findViewById(R.id.button24)
        r5c2Button.setOnClickListener {
            when(gameArray[21]){
                1 -> r5c2Button.setForeground(onePointDrawable)
                2 -> r5c2Button.setForeground(twoPointDrawable)
                3 -> r5c2Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r5c2Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(21, gameArray)
        }

        val r5c3Button: Button = findViewById(R.id.button25)
        r5c3Button.setOnClickListener {
            when(gameArray[22]){
                1 -> r5c3Button.setForeground(onePointDrawable)
                2 -> r5c3Button.setForeground(twoPointDrawable)
                3 -> r5c3Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r5c3Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(22, gameArray)
        }

        val r5c4Button: Button = findViewById(R.id.button26)
        r5c4Button.setOnClickListener {
            when(gameArray[23]){
                1 -> r5c4Button.setForeground(onePointDrawable)
                2 -> r5c4Button.setForeground(twoPointDrawable)
                3 -> r5c4Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r5c4Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(23, gameArray)
        }

        val r5c5Button: Button = findViewById(R.id.button27)
        r5c5Button.setOnClickListener {
            when(gameArray[24]){
                1 -> r5c5Button.setForeground(onePointDrawable)
                2 -> r5c5Button.setForeground(twoPointDrawable)
                3 -> r5c5Button.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> r5c5Button.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(24, gameArray)
        }
    }


    // The startGame method to begin the game.
    private fun startGame(): Array<Int> {
        // Call restartGame method to ensure everything looks as it should.
        restartGame()

        // Create an array of 25 length to hold tile data.
        val voltorbTileArray: Array<Int> = arrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)

        // Ensure on restart each value is reset to 0
        for(element in voltorbTileArray){
            voltorbTileArray[element] = 0
        }

        // Also creating an array to hold information about the amount of voltorbs in every row and column.
        val voltorbTotalsArray: Array<Int> = arrayOf(0,0,0,0,0,0,0,0,0,0)

        // Also Ensure on restart each value is reset to 0
        for(element in voltorbTotalsArray){
            voltorbTotalsArray[element] = 0
        }

        var bombCount = 0
        // Randomly select 0 (Voltorb Bomb), 1 point, 2 points, or 3 points for each element.
        for(element in 0..24) {

            //limits number of voltorbs to 6
            var rng = Random().nextInt(4)
            if(rng == 0 && bombCount < 6) {
                bombCount++
            }
            else if (rng == 0 && bombCount > 6) {
                rng = 1
            }
            voltorbTileArray[element] = rng

            // Used Later for voltorb counts in the text views.
            // Row 1
            if(element in 0..4 && voltorbTileArray[element] == 0) {voltorbTotalsArray[0] += 1}
            // Row 2
            if(element in 5..9 && voltorbTileArray[element] == 0) {voltorbTotalsArray[1] += 1}
            // Row 3
            if(element in 10..14 && voltorbTileArray[element] == 0) {voltorbTotalsArray[2] += 1}
            // Row 4
            if(element in 15..19 && voltorbTileArray[element] == 0) {voltorbTotalsArray[3] += 1}
            // Row 5
            if(element in 20..24 && voltorbTileArray[element] == 0) {voltorbTotalsArray[4] += 1}

            // Column 1
            if((element % 5 == 0) && voltorbTileArray[element] == 0) {voltorbTotalsArray[5] += 1}
            // Column 2
            if((element % 5 == 1) && voltorbTileArray[element] == 0) {voltorbTotalsArray[6] += 1}
            // Column 3
            if((element % 5 == 2) && voltorbTileArray[element] == 0) {voltorbTotalsArray[7] += 1}
            // Column 4
            if((element % 5 == 3) && voltorbTileArray[element] == 0) {voltorbTotalsArray[8] += 1}
            // Column 5
            if((element % 5 == 4) && voltorbTileArray[element] == 0) {voltorbTotalsArray[9] += 1}
        }

        for(i in voltorbTotalsArray) {
            Log.i("game", voltorbTotalsArray[i].toString())
        }
        /*
            Note: I was originally going to try and reference Strings in string.xml, but after tons of testing I couldn't get it to work and it took an extreme amount of while loops.
         */

        // Row 1 Points
        val r1Points: TextView = findViewById(R.id.textView2)
        r1Points.setText("${voltorbTileArray[0] + voltorbTileArray[1] + voltorbTileArray[2] + voltorbTileArray[3] + voltorbTileArray[4]}")
        // Row 1 Voltorbs
        val r1Voltorbs: TextView = findViewById(R.id.textView11)
        r1Voltorbs.setText("${voltorbTotalsArray[0]}")

        // Row 2 Points
        val r2Points: TextView = findViewById(R.id.textView3)
        r2Points.setText("${voltorbTileArray[5] + voltorbTileArray[6] + voltorbTileArray[7] + voltorbTileArray[8] + voltorbTileArray[9]}")
        // Row 2 Voltorbs
        val r2Voltorbs: TextView = findViewById(R.id.textView12)
        r2Voltorbs.setText("${voltorbTotalsArray[1]}")

        // Row 3 Points
        val r3Points: TextView = findViewById(R.id.textView4)
        r3Points.setText("${voltorbTileArray[10] + voltorbTileArray[11] + voltorbTileArray[12] + voltorbTileArray[13] + voltorbTileArray[14]}")
        // Row 3 Voltorbs
        val r3Voltorbs: TextView = findViewById(R.id.textView14)
        r3Voltorbs.setText("${voltorbTotalsArray[2]}")

        // Row 4 Points
        val r4Points: TextView = findViewById(R.id.textView5)
        r4Points.setText("${voltorbTileArray[15] + voltorbTileArray[16] + voltorbTileArray[17] + voltorbTileArray[18] + voltorbTileArray[19]}")
        // Row 4 Voltorbs
        val r4Voltorbs: TextView = findViewById(R.id.textView15)
        r4Voltorbs.setText("${voltorbTotalsArray[3]}")

        // Row 5 Points
        val r5Points: TextView = findViewById(R.id.textView13)
        r5Points.setText("${voltorbTileArray[20] + voltorbTileArray[21] + voltorbTileArray[22] + voltorbTileArray[23] + voltorbTileArray[24]}")
        // Row 5 Voltorbs
        val r5Voltorbs: TextView = findViewById(R.id.textView16)
        r5Voltorbs.setText("${voltorbTotalsArray[4]}")

        // Column 1 Points
        val c1Points: TextView = findViewById(R.id.textView6)
        c1Points.setText("${voltorbTileArray[0] + voltorbTileArray[5] + voltorbTileArray[10] + voltorbTileArray[15] + voltorbTileArray[20]}")
        // Column 1 Voltorbs
        val c1Voltorbs: TextView = findViewById(R.id.textView17)
        c1Voltorbs.setText("${voltorbTotalsArray[5]}")

        // Column 2 Points
        val c2Points: TextView = findViewById(R.id.textView7)
        c2Points.setText("${voltorbTileArray[1] + voltorbTileArray[6] + voltorbTileArray[11] + voltorbTileArray[16] + voltorbTileArray[21]}")
        // Column 2 Voltorbs
        val c2Voltorbs: TextView = findViewById(R.id.textView18)
        c2Voltorbs.setText("${voltorbTotalsArray[6]}")

        // Column 3 Points
        val c3Points: TextView = findViewById(R.id.textView8)
        c3Points.setText("${voltorbTileArray[2] + voltorbTileArray[7] + voltorbTileArray[12] + voltorbTileArray[17] + voltorbTileArray[22]}")
        // Column 3 Voltorbs
        val c3Voltorbs: TextView = findViewById(R.id.textView19)
        c3Voltorbs.setText("${voltorbTotalsArray[7]}")

        // Column 4 Points
        val c4Points: TextView = findViewById(R.id.textView9)
        c4Points.setText("${voltorbTileArray[3] + voltorbTileArray[8] + voltorbTileArray[13] + voltorbTileArray[18] + voltorbTileArray[23]}")
        // Column 4 Voltorbs
        val c4Voltorbs: TextView = findViewById(R.id.textView20)
        c4Voltorbs.setText("${voltorbTotalsArray[8]}")

        // Column 5 Points
        val c5Points: TextView = findViewById(R.id.textView10)
        c5Points.setText("${voltorbTileArray[4] + voltorbTileArray[9] + voltorbTileArray[14] + voltorbTileArray[19] + voltorbTileArray[24]}")
        // Column 5 Voltorbs
        val c5Voltorbs: TextView = findViewById(R.id.textView21)
        c5Voltorbs.setText("${voltorbTotalsArray[9]}")

        // Return array for future use in flipTile.
        return voltorbTileArray
    }

    // The flipTile method for onClickListeners to simply the code.
    private fun flipTile(index: Int, tileList: Array<Int>): Array<Int> {
        // Button image flipping is done in the setOnCLickListener phase.

        when(tileList[index]){
            1 ->{
                if(score == 0) { score = 1 }
            }
            2 ->{
                if(score == 0) {score = 2}
                else {score *= 2}
            }
            3 ->{
                if(score == 0) {score = 3}
                else {score *= 3}
            }
            4 ->{
                // Nothing should go through for already flipped buttons
            }
            // Voltorb/Bomb
            else -> {
                //score = 0
                Toast.makeText(this, "Game Over!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, GameOverActivity::class.java)
                intent.putExtra("message_key", score.toString())
                startActivity(intent)
            }

        }
        // Ensuring tile cannot be flipped again during this game.
        tileList[index] = 4

        // Updating points on the score
        val scoreText: TextView = findViewById(R.id.textView22)
        scoreText.setText("$score")

        return tileList
    }

    // The restartGame method to cover what the start of a game should look like.
    private fun restartGame() {
        // TODO: Potentially store score before the reset here using an if statement to ignore scores of 0?

        // Set score back to 0
        score = 0
        val scoreText: TextView = findViewById(R.id.textView22)
        scoreText.setText("$score")

        // Turn back all tiles to the checkerboard side.
        // Buttons 3 - 27
        val blankDrawable = getDrawable(R.drawable.blank)

        val r1c1Button: Button = findViewById(R.id.button3)
        r1c1Button.setForeground(blankDrawable)

        val r1c2Button: Button = findViewById(R.id.button4)
        r1c2Button.setForeground(blankDrawable)

        val r1c3Button: Button = findViewById(R.id.button5)
        r1c3Button.setForeground(blankDrawable)

        val r1c4Button: Button = findViewById(R.id.button6)
        r1c4Button.setForeground(blankDrawable)

        val r1c5Button: Button = findViewById(R.id.button7)
        r1c5Button.setForeground(blankDrawable)

        val r2c1Button: Button = findViewById(R.id.button8)
        r2c1Button.setForeground(blankDrawable)

        val r2c2Button: Button = findViewById(R.id.button9)
        r2c2Button.setForeground(blankDrawable)

        val r2c3Button: Button = findViewById(R.id.button10)
        r2c3Button.setForeground(blankDrawable)

        val r2c4Button: Button = findViewById(R.id.button11)
        r2c4Button.setForeground(blankDrawable)

        val r2c5Button: Button = findViewById(R.id.button12)
        r2c5Button.setForeground(blankDrawable)

        val r3c1Button: Button = findViewById(R.id.button13)
        r3c1Button.setForeground(blankDrawable)

        val r3c2Button: Button = findViewById(R.id.button14)
        r3c2Button.setForeground(blankDrawable)

        val r3c3Button: Button = findViewById(R.id.button15)
        r3c3Button.setForeground(blankDrawable)

        val r3c4Button: Button = findViewById(R.id.button16)
        r3c4Button.setForeground(blankDrawable)

        val r3c5Button: Button = findViewById(R.id.button17)
        r3c5Button.setForeground(blankDrawable)

        val r4c1Button: Button = findViewById(R.id.button18)
        r4c1Button.setForeground(blankDrawable)

        val r4c2Button: Button = findViewById(R.id.button19)
        r4c2Button.setForeground(blankDrawable)

        val r4c3Button: Button = findViewById(R.id.button20)
        r4c3Button.setForeground(blankDrawable)

        val r4c4Button: Button = findViewById(R.id.button21)
        r4c4Button.setForeground(blankDrawable)

        val r4c5Button: Button = findViewById(R.id.button22)
        r4c5Button.setForeground(blankDrawable)

        val r5c1Button: Button = findViewById(R.id.button23)
        r5c1Button.setForeground(blankDrawable)

        val r5c2Button: Button = findViewById(R.id.button24)
        r5c2Button.setForeground(blankDrawable)

        val r5c3Button: Button = findViewById(R.id.button25)
        r5c3Button.setForeground(blankDrawable)

        val r5c4Button: Button = findViewById(R.id.button26)
        r5c4Button.setForeground(blankDrawable)

        val r5c5Button: Button = findViewById(R.id.button27)
        r5c5Button.setForeground(blankDrawable)

        // Set Points and Voltorbs back to 0.
        // Row 1
        val r1Points: TextView = findViewById(R.id.textView2)
        r1Points.setText("00")

        val r1Voltorbs: TextView = findViewById(R.id.textView11)
        r1Voltorbs.setText("0")
        // Row 2
        val r2Points: TextView = findViewById(R.id.textView3)
        r2Points.setText("00")

        val r2Voltorbs: TextView = findViewById(R.id.textView12)
        r2Voltorbs.setText("0")
        // Row 3
        val r3Points: TextView = findViewById(R.id.textView4)
        r3Points.setText("00")

        val r3Voltorbs: TextView = findViewById(R.id.textView14)
        r3Voltorbs.setText("0")
        // Row 4
        val r4Points: TextView = findViewById(R.id.textView5)
        r4Points.setText("00")

        val r4Voltorbs: TextView = findViewById(R.id.textView15)
        r4Voltorbs.setText("0")
        // Row 5
        val r5Points: TextView = findViewById(R.id.textView13)
        r5Points.setText("00")

        val r5Voltorbs: TextView = findViewById(R.id.textView16)
        r5Voltorbs.setText("0")

        // Column 1
        val c1Points: TextView = findViewById(R.id.textView6)
        c1Points.setText("00")

        val c1Voltorbs: TextView = findViewById(R.id.textView17)
        c1Voltorbs.setText("0")
        // Column 2
        val c2Points: TextView = findViewById(R.id.textView7)
        c2Points.setText("00")

        val c2Voltorbs: TextView = findViewById(R.id.textView18)
        c2Voltorbs.setText("0")
        // Column 3
        val c3Points: TextView = findViewById(R.id.textView8)
        c3Points.setText("00")

        val c3Voltorbs: TextView = findViewById(R.id.textView19)
        c3Voltorbs.setText("0")
        // Column 4
        val c4Points: TextView = findViewById(R.id.textView9)
        c4Points.setText("00")

        val c4Voltorbs: TextView = findViewById(R.id.textView20)
        c4Voltorbs.setText("0")
        // Column 5
        val c5Points: TextView = findViewById(R.id.textView10)
        c5Points.setText("00")

        val c5Voltorbs: TextView = findViewById(R.id.textView21)
        c5Voltorbs.setText("0")
    }

    // The switchActivity function switches from GameActivity to the Main Activity. For use in the onClick listener for Quit.
    private fun switchActivity(){
        // Stopping music since I am unsure if switching activities calls onPause and onStop.
        // music.stop()
        // music.release()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    // onPause, onStop, and onResume are used for stopping or resuming music.
    override fun onStop(){
        super.onStop()
        // music.release()
    }

    override fun onPause(){
        super.onPause()
        // music.stop()
    }

    override fun onResume(){
        super.onResume()
        // music.start()
    }
}