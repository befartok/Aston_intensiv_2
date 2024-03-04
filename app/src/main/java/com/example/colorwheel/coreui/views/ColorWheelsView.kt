package com.example.colorwheel.coreui.views

//noinspection SuspiciousImport
import android.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat


class ColorWheelsView(
    context: Context,
    attr: AttributeSet
) : View(context, attr) {
    private val paint = Paint()
    private val startAngle = 0f
    private val orange = ContextCompat.getColor(context, R.color.holo_orange_dark)


    private val colors = listOf(
        Color.RED,
        orange,
        Color.YELLOW,
        Color.GREEN,
        Color.CYAN,
        Color.BLUE,
        Color.MAGENTA
    )
    private val sweepAngle = 360f / colors.size


    init {
        paint.style = Paint.Style.FILL
        paint.color = Color.RED
    }

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawCircleButton(canvas)
    }

    private fun drawCircleButton(canvas: Canvas) {
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = width.coerceAtMost(height) / 2f

        for (i in colors.indices) {
            paint.color = colors[i]
            canvas.drawArc(
                centerX - radius,
                centerY - radius,
                centerX + radius,
                centerY + radius,
                startAngle + i * sweepAngle,
                sweepAngle,
                true,
                paint
            )

        }

    }

}