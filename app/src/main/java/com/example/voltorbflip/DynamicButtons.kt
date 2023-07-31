package com.example.voltorbflip

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView

class DynamicButtons : Activity(){
    lateinit var firstButton: Button
    lateinit var secondButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dynamic_buttons)

        val btnMake = findViewById<Button>(R.id.btnMake)
        val llVert = findViewById<LinearLayout>(R.id.llVert)
        var rows = 5
        var columns = 5

        //dynamically build buttons and linear layouts to fill 5 rows and columns
        btnMake.setOnClickListener {
            for(i in 1..rows) {
                val ll_row = LinearLayout(this)
                ll_row.orientation = LinearLayout.HORIZONTAL
                llVert.addView(ll_row)

                for(j in 1..columns) {
                    val newBtn = Button(this)
                    newBtn.text = " "
                    newBtn.tag = "$i _ $j"
                    ll_row.addView(newBtn)
                    newBtn.setOnClickListener(newBtnListener)
                }
            }
        }
    }

    //on click listener for generated buttons
    var newBtnListener = View.OnClickListener {
        Toast.makeText(applicationContext, "${it.tag}", Toast.LENGTH_LONG).show()
    }
}