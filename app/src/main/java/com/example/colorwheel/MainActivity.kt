package com.example.colorwheel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.colorwheel.coreui.views.ColorWheelsView

class MainActivity : AppCompatActivity(), ColorWheelsView.Listener {
    //private lateinit var binding: ActivityMainBinding
    // var textViewz: TextView? = null
    private var ddd: String = "022"

    private var number: Int = 5

    private var text: String = "В магазине осталось $number яблок"
    var textViewz: TextView? = null

    private var tvText: TextView? = null
    private var colorWheelsView: ColorWheelsView? = null


    override fun onCreate(savedInstanceState: Bundle?) {

//        textViewz = findViewById(R.id.textView)!!

        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        //setContentView(R.layout.activity_main)
        //binding

        ddd = ColorWheelsView.listener2

        Toast.makeText(this, ddd, Toast.LENGTH_SHORT).show()

        tvText = findViewById(R.id.textView)
        colorWheelsView = findViewById(R.id.colorWheelsView)

        tvText?.text = ddd

        //textViewz?.text = ddd

        oClick()

        rotor()

    }

    fun oClick() {

        textViewz?.text = ddd


    }

   /* fun clickBtn() {

        colorWheelsView?.animate()?.apply {
            rotation(120f)
            duration = 15000
            //interpolator = AccelerateDecelerateInterpolator()

        }?.start()


    }*/
    fun rotor() {

        colorWheelsView?.animate()?.apply {
            rotation(5000f)
            duration = 5000
            interpolator = AccelerateDecelerateInterpolator()

        }?.start()


    }

    /*    fun clickWheels(view: View){
            Toast.makeText(this, "toast", Toast.LENGTH_SHORT).show()
            *//*
                image.makeGone()
        *//*



    }*/

}