package com.example.colorwheel.coreui.views

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat


class ColorWheelsView (
    context: Context,
    attr: AttributeSet
): View (context, attr){
    var listener: Listener? = null
    //var colorText = "gray"
    private val paint = Paint()
    private val paintC = Paint()
    private val startAngle = 0f
    private val ORANGE = ContextCompat.getColor(context, R.color.holo_orange_dark)



    private val colors = listOf(
        Color.RED,
        ORANGE,
        Color.YELLOW,
        Color.GREEN,
        Color.CYAN,
        Color.BLUE,
        Color.MAGENTA
    )
    private val sweepAngle = 360f / colors.size

    init {
        paint.style = Paint.Style.STROKE
        paint.color = Color.GRAY
        paint.strokeWidth = 5f
        paintC.style = Paint.Style.FILL
        paintC.color = Color.RED

        setOnClickListener {
            listener?.onClick()

            //Toast.makeText(context, "toast", Toast.LENGTH_SHORT).show()
        }

    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawCircleButton(canvas)
    }

    private fun drawCircleButton (canvas: Canvas)
    {
        val  centerX = width/2f
        val  centerY = height/2f
        val radius = width.coerceAtMost(height)/2f

        for(i in colors.indices){
            paintC.color = colors[i]
            canvas.drawArc(
                centerX - radius,
                centerY - radius,
                centerX + radius,
                centerY + radius,
                startAngle + i * sweepAngle,
                sweepAngle,
                true,
                paintC
            )

        }

    }

    interface Listener{
        fun onClick (){

        }
    }

    companion object {
        var listener2 = "123"
    }


}