package com.example.voltorbflip

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import com.example.voltorbflip.databinding.VoltorbFlipGameBinding
import java.util.Random

class GameActivity: Activity() {
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

        val binding: VoltorbFlipGameBinding = VoltorbFlipGameBinding.inflate(getLayoutInflater())
        // Start music
        // music.start()

        // call the startGame function.
        var gameArray: Array<Int> = startGame()

        // Setting up all 27 buttons.
        // Quit Button
        binding.quitButton.setOnClickListener { switchActivity() }
        // Restart Button (We use startGame() since we want to start another game and not just reset the board.)
        binding.restartButton.setOnClickListener { startGame() }

        // 25 Grid Buttons (Need unique onClickListeners)

        // Holding drawables needed for the buttons.
        val onePointDrawable = getDrawable(R.drawable.one)
        val twoPointDrawable = getDrawable(R.drawable.two)
        val threePointDrawable = getDrawable(R.drawable.three)
        val voltorbDrawable = getDrawable(R.drawable.voltorb)

        binding.button3.setOnClickListener {
            when(gameArray[0]){
                1 -> binding.button3.setForeground(onePointDrawable)
                2 -> binding.button3.setForeground(twoPointDrawable)
                3 -> binding.button3.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button3.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(0, gameArray)
        }

        binding.button4.setOnClickListener {
            when(gameArray[1]){
                1 -> binding.button4.setForeground(onePointDrawable)
                2 -> binding.button4.setForeground(twoPointDrawable)
                3 -> binding.button4.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button4.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(1, gameArray)
        }

        binding.button5.setOnClickListener {
            when(gameArray[2]){
                1 -> binding.button5.setForeground(onePointDrawable)
                2 -> binding.button5.setForeground(twoPointDrawable)
                3 -> binding.button5.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button5.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(2, gameArray)
        }

        binding.button6.setOnClickListener {
            when(gameArray[3]){
                1 -> binding.button6.setForeground(onePointDrawable)
                2 -> binding.button6.setForeground(twoPointDrawable)
                3 -> binding.button6.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button6.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(3, gameArray)
        }

        binding.button7.setOnClickListener {
            when(gameArray[4]){
                1 -> binding.button7.setForeground(onePointDrawable)
                2 -> binding.button7.setForeground(twoPointDrawable)
                3 -> binding.button7.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button7.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(4, gameArray)
        }

        binding.button8.setOnClickListener {
            when(gameArray[5]){
                1 -> binding.button8.setForeground(onePointDrawable)
                2 -> binding.button8.setForeground(twoPointDrawable)
                3 -> binding.button8.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button8.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(5, gameArray)
        }

        binding.button9.setOnClickListener {
            when(gameArray[6]){
                1 -> binding.button9.setForeground(onePointDrawable)
                2 -> binding.button9.setForeground(twoPointDrawable)
                3 -> binding.button9.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button9.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(6, gameArray)
        }

        binding.button10.setOnClickListener {
            when(gameArray[7]){
                1 -> binding.button10.setForeground(onePointDrawable)
                2 -> binding.button10.setForeground(twoPointDrawable)
                3 -> binding.button10.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button10.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(7, gameArray)
        }

        binding.button11.setOnClickListener {
            when(gameArray[8]){
                1 -> binding.button11.setForeground(onePointDrawable)
                2 -> binding.button11.setForeground(twoPointDrawable)
                3 -> binding.button11.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button11.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(8, gameArray)
        }

        binding.button12.setOnClickListener {
            when(gameArray[9]){
                1 -> binding.button12.setForeground(onePointDrawable)
                2 -> binding.button12.setForeground(twoPointDrawable)
                3 -> binding.button12.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button12.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(9, gameArray)
        }

        binding.button13.setOnClickListener {
            when(gameArray[10]){
                1 -> binding.button13.setForeground(onePointDrawable)
                2 -> binding.button13.setForeground(twoPointDrawable)
                3 -> binding.button13.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button13.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(10, gameArray)
        }

        binding.button14.setOnClickListener {
            when(gameArray[11]){
                1 -> binding.button14.setForeground(onePointDrawable)
                2 -> binding.button14.setForeground(twoPointDrawable)
                3 -> binding.button14.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button14.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(11, gameArray)
        }

        binding.button15.setOnClickListener {
            when(gameArray[12]){
                1 -> binding.button15.setForeground(onePointDrawable)
                2 -> binding.button15.setForeground(twoPointDrawable)
                3 -> binding.button15.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button15.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(12, gameArray)
        }

        binding.button16.setOnClickListener {
            when(gameArray[13]){
                1 -> binding.button16.setForeground(onePointDrawable)
                2 -> binding.button16.setForeground(twoPointDrawable)
                3 -> binding.button16.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button16.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(13, gameArray)
        }

        binding.button17.setOnClickListener {
            when(gameArray[14]){
                1 -> binding.button17.setForeground(onePointDrawable)
                2 -> binding.button17.setForeground(twoPointDrawable)
                3 -> binding.button17.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button17.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(14, gameArray)
        }

        binding.button18.setOnClickListener {
            when(gameArray[15]){
                1 -> binding.button18.setForeground(onePointDrawable)
                2 -> binding.button18.setForeground(twoPointDrawable)
                3 -> binding.button18.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button18.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(15, gameArray)
        }

        binding.button19.setOnClickListener {
            when(gameArray[16]){
                1 -> binding.button19.setForeground(onePointDrawable)
                2 -> binding.button19.setForeground(twoPointDrawable)
                3 -> binding.button19.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button19.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(16, gameArray)
        }

        binding.button20.setOnClickListener {
            when(gameArray[17]){
                1 -> binding.button20.setForeground(onePointDrawable)
                2 -> binding.button20.setForeground(twoPointDrawable)
                3 -> binding.button20.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button20.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(17, gameArray)
        }

        binding.button21.setOnClickListener {
            when(gameArray[18]){
                1 -> binding.button21.setForeground(onePointDrawable)
                2 -> binding.button21.setForeground(twoPointDrawable)
                3 -> binding.button21.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button21.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(18, gameArray)
        }

        binding.button22.setOnClickListener {
            when(gameArray[19]){
                1 -> binding.button22.setForeground(onePointDrawable)
                2 -> binding.button22.setForeground(twoPointDrawable)
                3 -> binding.button22.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button22.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(19, gameArray)
        }

        binding.button23.setOnClickListener {
            when(gameArray[20]){
                1 -> binding.button23.setForeground(onePointDrawable)
                2 -> binding.button23.setForeground(twoPointDrawable)
                3 -> binding.button23.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button23.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(20, gameArray)
        }

        binding.button24.setOnClickListener {
            when(gameArray[21]){
                1 -> binding.button24.setForeground(onePointDrawable)
                2 -> binding.button24.setForeground(twoPointDrawable)
                3 -> binding.button24.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button24.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(21, gameArray)
        }

        binding.button25.setOnClickListener {
            when(gameArray[22]){
                1 -> binding.button25.setForeground(onePointDrawable)
                2 -> binding.button25.setForeground(twoPointDrawable)
                3 -> binding.button25.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button25.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(22, gameArray)
        }

        binding.button26.setOnClickListener {
            when(gameArray[23]){
                1 -> binding.button26.setForeground(onePointDrawable)
                2 -> binding.button26.setForeground(twoPointDrawable)
                3 -> binding.button26.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button26.setForeground(voltorbDrawable)
            }
            gameArray = flipTile(23, gameArray)
        }

        binding.button27.setOnClickListener {
            when(gameArray[24]){
                1 -> binding.button27.setForeground(onePointDrawable)
                2 -> binding.button27.setForeground(twoPointDrawable)
                3 -> binding.button27.setForeground(threePointDrawable)
                4 -> {} // We want nothing to occur when we pass the solved tile.
                else -> binding.button27.setForeground(voltorbDrawable)
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
        val binding: VoltorbFlipGameBinding = VoltorbFlipGameBinding.inflate(getLayoutInflater())

        // Row 1 Points
        binding.textView2.setText("${voltorbTileArray[0] + voltorbTileArray[1] + voltorbTileArray[2] + voltorbTileArray[3] + voltorbTileArray[4]}")
        // Row 1 Voltorbs
        binding.textView11.setText("${voltorbTotalsArray[0]}")

        // Row 2 Points
        binding.textView3.setText("${voltorbTileArray[5] + voltorbTileArray[6] + voltorbTileArray[7] + voltorbTileArray[8] + voltorbTileArray[9]}")
        // Row 2 Voltorbs
        binding.textView12.setText("${voltorbTotalsArray[1]}")

        // Row 3 Points
        binding.textView4.setText("${voltorbTileArray[10] + voltorbTileArray[11] + voltorbTileArray[12] + voltorbTileArray[13] + voltorbTileArray[14]}")
        // Row 3 Voltorbs
        binding.textView14.setText("${voltorbTotalsArray[2]}")

        // Row 4 Points
        binding.textView5.setText("${voltorbTileArray[15] + voltorbTileArray[16] + voltorbTileArray[17] + voltorbTileArray[18] + voltorbTileArray[19]}")
        // Row 4 Voltorbs
        binding.textView15.setText("${voltorbTotalsArray[3]}")

        // Row 5 Points
        binding.textView13.setText("${voltorbTileArray[20] + voltorbTileArray[21] + voltorbTileArray[22] + voltorbTileArray[23] + voltorbTileArray[24]}")
        // Row 5 Voltorbs
        binding.textView16.setText("${voltorbTotalsArray[4]}")

        // Column 1 Points
        binding.textView6.setText("${voltorbTileArray[0] + voltorbTileArray[5] + voltorbTileArray[10] + voltorbTileArray[15] + voltorbTileArray[20]}")
        // Column 1 Voltorbs
        binding.textView17.setText("${voltorbTotalsArray[5]}")

        // Column 2 Points
        binding.textView7.setText("${voltorbTileArray[1] + voltorbTileArray[6] + voltorbTileArray[11] + voltorbTileArray[16] + voltorbTileArray[21]}")
        // Column 2 Voltorbs
        binding.textView18.setText("${voltorbTotalsArray[6]}")

        // Column 3 Points
        binding.textView8.setText("${voltorbTileArray[2] + voltorbTileArray[7] + voltorbTileArray[12] + voltorbTileArray[17] + voltorbTileArray[22]}")
        // Column 3 Voltorbs
        binding.textView19.setText("${voltorbTotalsArray[7]}")

        // Column 4 Points
        binding.textView9.setText("${voltorbTileArray[3] + voltorbTileArray[8] + voltorbTileArray[13] + voltorbTileArray[18] + voltorbTileArray[23]}")
        // Column 4 Voltorbs
        binding.textView20.setText("${voltorbTotalsArray[8]}")

        // Column 5 Points
        binding.textView10.setText("${voltorbTileArray[4] + voltorbTileArray[4] + voltorbTileArray[14] + voltorbTileArray[19] + voltorbTileArray[24]}")
        // Column 5 Voltorbs
        binding.textView21.setText("${voltorbTotalsArray[9]}")



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
                score = 0
            }

        }
        // Ensuring tile cannot be flipped again during this game.
        tileList[index] = 4

        // Updating points on the score
        val binding: VoltorbFlipGameBinding = VoltorbFlipGameBinding.inflate(getLayoutInflater())
        binding.textView22.setText("$score")

        return tileList
    }

    // The restartGame method to cover what the start of a game should look like.
    private fun restartGame() {
        val binding: VoltorbFlipGameBinding = VoltorbFlipGameBinding.inflate(getLayoutInflater())
        // TODO: Potentially store score before the reset here using an if statement to ignore scores of 0?

        // Set score back to 0
        score = 0
        binding.textView22.setText("$score")

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