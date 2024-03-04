package com.example.colorwheel

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.colorwheel.coreui.views.ColorWheelsView
import kotlin.random.Random
import coil.load

class MainActivity : AppCompatActivity() {

    private var textViewPad: TextView? = null
    private var imageViewPad: ImageView? = null
    private var colorWheelsView: ColorWheelsView? = null
    private var findColor: String = "GREEN"
    private var numColor: Int = 1
    private var imgLink: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewPad = findViewById(R.id.textViewPad)
        imageViewPad = findViewById(R.id.imageView)
        colorWheelsView = findViewById(R.id.colorWheelsView)

        click()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("textViewPadKey", textViewPad?.text.toString())
            putString("imgLinkKey", imgLink)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textViewPad?.text = savedInstanceState.getString("textViewPadKey")
        imgLink = savedInstanceState.getString("imgLinkKey")
        imageViewPad?.load(imgLink)

    }

    private fun rotor() {

        val rotateAngle = (numColor - 1) * 360 / 7 + 360 * 5

        ObjectAnimator.ofFloat(colorWheelsView, View.ROTATION, 0F, rotateAngle.toFloat())
            .setDuration(1000).start()
        outputToPad(findColor)
    }

    private fun outputToPad(textToOut: String) {
        when (textToOut) {

            "RED", "YELLOW", "CYAN", "MAGENTA" -> {
                textViewPad?.text = textToOut
                imageViewPad?.setImageDrawable(null)
                imgLink = ""
            }

            "ORANGE", "GREEN", "BLUE" -> showImg()
        }
    }

    private fun showImg() {
        imageViewPad?.load("https://placebeard.it/200")
        textViewPad?.text = null
        imgLink = "https://placebeard.it/200"

    }

    fun onClickList(v: View?) {

        if (v != null) {

            imageViewPad?.setImageDrawable(null)
            textViewPad?.text = null

        }

    }

    private fun click() {

        colorWheelsView?.setOnClickListener {
            getRandomColor()
            rotor()
        }
    }

    private fun getRandomColor() {
        when (Random.nextInt(from = 1, until = 8)) {
            4 -> {
                findColor = "RED"; numColor = 4
            }

            3 -> {
                findColor = "ORANGE"; numColor = 3
            }

            2 -> {
                findColor = "YELLOW"; numColor = 2
            }

            1 -> {
                findColor = "GREEN"; numColor = 1
            }

            7 -> {
                findColor = "CYAN"; numColor = 7
            }

            6 -> {
                findColor = "BLUE"; numColor = 6
            }

            5 -> {
                findColor = "MAGENTA"; numColor = 5
            }
        }
    }
}
