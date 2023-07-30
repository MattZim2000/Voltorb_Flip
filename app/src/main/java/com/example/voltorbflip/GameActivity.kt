package com.example.voltorbflip

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.voltorbflip.databinding.VoltorbFlipGameBinding
import java.util.Random

class GameActivity: ComponentActivity() {
    private val binding: VoltorbFlipGameBinding = VoltorbFlipGameBinding.inflate(getLayoutInflater())
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.voltorb_flip_game)

        // call the startGame function.
        val gameArray = startGame()

        // TODO: Setting up all 27 buttons.
        // Quit Button
        binding.quitButton.setOnClickListener { switchActivity() }
        // Restart Button (We use startGame() since we want to start another game and not just reset the board.)
        binding.restartButton.setOnClickListener { startGame() }
        // 25 Grid Buttons (Need unique onClickListeners)
        binding.button3.setOnClickListener {

        }

        binding.button4.setOnClickListener {

        }

        binding.button5.setOnClickListener {

        }

        binding.button6.setOnClickListener {

        }

        binding.button7.setOnClickListener {

        }

        binding.button8.setOnClickListener {

        }

        binding.button9.setOnClickListener {

        }

        binding.button10.setOnClickListener {

        }

        binding.button11.setOnClickListener {

        }

        binding.button12.setOnClickListener {

        }

        binding.button13.setOnClickListener {

        }

        binding.button14.setOnClickListener {

        }

        binding.button15.setOnClickListener {

        }

        binding.button16.setOnClickListener {

        }

        binding.button17.setOnClickListener {

        }

        binding.button18.setOnClickListener {

        }

        binding.button19.setOnClickListener {

        }

        binding.button20.setOnClickListener {

        }

        binding.button21.setOnClickListener {

        }

        binding.button22.setOnClickListener {

        }

        binding.button23.setOnClickListener {

        }

        binding.button24.setOnClickListener {

        }

        binding.button25.setOnClickListener {

        }

        binding.button26.setOnClickListener {

        }

        binding.button27.setOnClickListener {

        }
    }


    // The startGame method to begin the game.
    private fun startGame(): Array<Int> {
        // Call restartGame method to ensure everything looks as it should.
        restartGame()

        // Create an array of 25 length to hold tile data.
        val voltorbTileArray: Array<Int> = arrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)

        // Also creating an array to hold information about the amount of voltorbs in every row and column.
        val voltorbTotalsArray: Array<Int> = arrayOf(0,0,0,0,0,0,0,0,0,0)

        // Randomly select 0 (Voltorb Bomb), 1 point, 2 points, or 3 points for each element.
        for(element in voltorbTileArray) {
            voltorbTileArray[element] = Random().nextInt(4)

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
            if((element == 0 || element == 5 || element == 10 || element == 15 || element == 20) && voltorbTileArray[element] == 0) {voltorbTotalsArray[5] += 1}
            // Column 2
            if((element == 1 || element == 6 || element == 11 || element == 16 || element == 21) && voltorbTileArray[element] == 0) {voltorbTotalsArray[6] += 1}
            // Column 3
            if((element == 2 || element == 7 || element == 12 || element == 17 || element == 22) && voltorbTileArray[element] == 0) {voltorbTotalsArray[7] += 1}
            // Column 4
            if((element == 3 || element == 8 || element == 13 || element == 18 || element == 23) && voltorbTileArray[element] == 0) {voltorbTotalsArray[8] += 1}
            // Column 5
            if((element == 4 || element == 9 || element == 14 || element == 19 || element == 24) && voltorbTileArray[element] == 0) {voltorbTotalsArray[9] += 1}
        }

        /*
            Note: I was originally going to try and reference Strings in string.xml, but after tons of testing I couldn't get it to work and it took an extreme amount of while loops.
         */
        // Row 1 Points
        binding.textView2.setText(voltorbTileArray[0] + voltorbTileArray[1] + voltorbTileArray[2] + voltorbTileArray[3] + voltorbTileArray[4])
        // Row 1 Voltorbs
        binding.textView11.setText(voltorbTotalsArray[0])

        // Row 2 Points
        binding.textView3.setText(voltorbTileArray[5] + voltorbTileArray[6] + voltorbTileArray[7] + voltorbTileArray[8] + voltorbTileArray[9])
        // Row 2 Voltorbs
        binding.textView12.setText(voltorbTotalsArray[1])

        // Row 3 Points
        binding.textView4.setText(voltorbTileArray[10] + voltorbTileArray[11] + voltorbTileArray[12] + voltorbTileArray[13] + voltorbTileArray[14])
        // Row 3 Voltorbs
        binding.textView14.setText(voltorbTotalsArray[2])

        // Row 4 Points
        binding.textView5.setText(voltorbTileArray[15] + voltorbTileArray[16] + voltorbTileArray[17] + voltorbTileArray[18] + voltorbTileArray[19])
        // Row 4 Voltorbs
        binding.textView15.setText(voltorbTotalsArray[3])

        // Row 5 Points
        binding.textView13.setText(voltorbTileArray[20] + voltorbTileArray[21] + voltorbTileArray[22] + voltorbTileArray[23] + voltorbTileArray[24])
        // Row 5 Voltorbs
        binding.textView16.setText(voltorbTotalsArray[4])

        // Column 1 Points
        binding.textView6.setText(voltorbTileArray[0] + voltorbTileArray[5] + voltorbTileArray[10] + voltorbTileArray[15] + voltorbTileArray[20])
        // Column 1 Voltorbs
        binding.textView17.setText(voltorbTotalsArray[5])

        // Column 2 Points
        binding.textView7.setText(voltorbTileArray[1] + voltorbTileArray[6] + voltorbTileArray[11] + voltorbTileArray[16] + voltorbTileArray[21])
        // Column 2 Voltorbs
        binding.textView18.setText(voltorbTotalsArray[6])

        // Column 3 Points
        binding.textView8.setText(voltorbTileArray[2] + voltorbTileArray[7] + voltorbTileArray[12] + voltorbTileArray[17] + voltorbTileArray[22])
        // Column 3 Voltorbs
        binding.textView19.setText(voltorbTotalsArray[7])

        // Column 4 Points
        binding.textView9.setText(voltorbTileArray[3] + voltorbTileArray[8] + voltorbTileArray[13] + voltorbTileArray[18] + voltorbTileArray[23])
        // Column 4 Voltorbs
        binding.textView20.setText(voltorbTotalsArray[8])

        // Column 5 Points
        binding.textView10.setText(voltorbTileArray[4] + voltorbTileArray[4] + voltorbTileArray[14] + voltorbTileArray[19] + voltorbTileArray[24])
        // Column 5 Voltorbs
        binding.textView21.setText(voltorbTotalsArray[9])



        // Return array for future use in flipTile.
        return voltorbTileArray
    }

    // TODO: Create the flipTile method for onClickListeners to simply the code.
    private fun flipTile(index: Int, tileList: Array<Int>): Array<Int> {
        // Button image flipping is done in the setOnCLickListener phase.

        when(tileList[index]){
            1 ->{
                if(score == 0) {score = 1}
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
                score = 0
            }

        }
        // Ensuring tile cannot be flipped again during this game.
        tileList[index] = 4

        // Updating points on the score
        binding.textView22.setText(score)

        return tileList
    }

    // The restartGame method to cover what the start of a game should look like.
    private fun restartGame() {

        // TODO: Potentially store score before the reset here using an if statement to ignore scores of 0?

        // Set score back to 0
        score = 0
        binding.textView22.setText(score)

        // Turn back all tiles to the checkerboard side.
        // Buttons 3 - 27
        val blankDrawable = getDrawable(R.drawable.blank)
        binding.button3.setForeground(blankDrawable)
        binding.button4.setForeground(blankDrawable)
        binding.button5.setForeground(blankDrawable)
        binding.button6.setForeground(blankDrawable)
        binding.button7.setForeground(blankDrawable)
        binding.button8.setForeground(blankDrawable)
        binding.button9.setForeground(blankDrawable)
        binding.button10.setForeground(blankDrawable)
        binding.button11.setForeground(blankDrawable)
        binding.button12.setForeground(blankDrawable)
        binding.button13.setForeground(blankDrawable)
        binding.button14.setForeground(blankDrawable)
        binding.button15.setForeground(blankDrawable)
        binding.button16.setForeground(blankDrawable)
        binding.button17.setForeground(blankDrawable)
        binding.button18.setForeground(blankDrawable)
        binding.button19.setForeground(blankDrawable)
        binding.button20.setForeground(blankDrawable)
        binding.button21.setForeground(blankDrawable)
        binding.button22.setForeground(blankDrawable)
        binding.button23.setForeground(blankDrawable)
        binding.button24.setForeground(blankDrawable)
        binding.button25.setForeground(blankDrawable)
        binding.button26.setForeground(blankDrawable)
        binding.button27.setForeground(blankDrawable)

        // Set Points and Voltorbs back to 0.
        // Row 1
        binding.textView2.setText("00")
        binding.textView11.setText("0")
        // Row 2
        binding.textView3.setText("00")
        binding.textView12.setText("0")
        // Row 3
        binding.textView4.setText("00")
        binding.textView14.setText("0")
        // Row 4
        binding.textView5.setText("00")
        binding.textView15.setText("0")
        // Row 5
        binding.textView13.setText("00")
        binding.textView16.setText("0")

        // Column 1
        binding.textView6.setText("00")
        binding.textView17.setText("0")
        // Column 2
        binding.textView7.setText("00")
        binding.textView18.setText("0")
        // Column 3
        binding.textView8.setText("00")
        binding.textView19.setText("0")
        // Column 4
        binding.textView9.setText("00")
        binding.textView20.setText("0")
        // Column 5
        binding.textView10.setText("00")
        binding.textView21.setText("0")
    }

    // The switchActivity function switches from GameActivity to the Main Activity. For use in the onClick listener for Quit.
    private fun switchActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}