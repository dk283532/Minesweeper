package com.example.minesweeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    var level = ""
    var custum: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener {
            if(custum==true)
            {
                NoOfRow.isVisible = false
                NoOfMines.isVisible = false
                Numberofcol.isVisible = false
                custum= false
            }
            else{
                NoOfRow.isVisible = true
                NoOfMines.isVisible = true
                Numberofcol.isVisible = true
                custum = true
            }

        }
        easy.setOnClickListener {
            level = "easy"
        }
        medium.setOnClickListener {
            level = "medium"
        }
        hard.setOnClickListener {
            level = "hard"
        }
        play.setOnClickListener {

            if (level == "") {
                Toast.makeText(this, "Choose Valid Level Option", Toast.LENGTH_LONG).show()
            } else if (custum == true) {
                var row =NoOfRow.editText?.text.toString()
                var columns =Numberofcol.editText?.text.toString()
                val mine = NoOfMines.editText?.text.toString()
                if (row .equals("") || columns.equals("") || mine.equals("")) {
                    Toast.makeText(this,"Fill Proper Details",Toast.LENGTH_LONG).show()
                }
                else {

                    val intent = Intent(this@MainActivity, GamePlay::class.java).apply {
                        putExtra("RowNumber", row.toInt())
                        putExtra("ColumnNumber", columns.toInt())
                        putExtra("NumebrOfMine", mine.toInt())
                    }
                    startActivity(intent)
                }

            } else {

                val intent = Intent(this, GamePlay::class.java).apply {
                    putExtra("selectedLevel", level)
                    putExtra("flag", 1)
                }
                startActivity(intent)
            }
        }
        rules.setOnClickListener {
            showInstruction()
        }
    }

    private fun showInstruction() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("INSTRUCTIONS")
        builder.setMessage(
            "The purpose of the game is to open all the cells of the board which do not contain a bomb. You lose if you set off a bomb cell.\n" +
                    "\n" +
                    "Every non-bomb cell you open will tell you the total number of bombs in the eight neighboring cells." +
                    " Once you are sure that a cell contains a bomb, you can right-click to put a flag it on it as a reminder. " +
                    "Once you have flagged all the bombs around an open cell, you can quickly open the remaining non-bomb cells by shift-clicking on the cell.\n" +
                    "\n" +
                    "To start a new game (abandoning the current one), just click on the yellow face button.\n" +
                    "\n" +
                    "Happy mine hunting!"
        )
        builder.setCancelable(false)
        builder.setPositiveButton("OK") { dialog, which ->
        }
        val alertDialog = builder.create()
        alertDialog.show()
    }
}