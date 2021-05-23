package com.example.minesweeper


import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import java.time.format.DecimalStyle



class MineCell:AppCompatButton {
    constructor(context: Context?):super(context!!)
    constructor(context: Context?,attrs:AttributeSet?):super(context!!,attrs)
    constructor(context: Context? ,attrs: AttributeSet?,defStyle: Int):super(
        context!!,attrs,defStyle
            )

    var value:Int =0
    var isRevealed:Boolean = false
    var isMarked:Boolean = false
    var isMine:Boolean = false
}