package com.example.colorwheel.coreui.views


import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.example.colorwheel.R
import com.example.colorwheel.coreui.Enrichable
import com.example.colorwheel.coreui.find
import com.example.colorwheel.coreui.hideProgressView
import com.example.colorwheel.coreui.makeGone
import com.example.colorwheel.coreui.makeVisible
import com.example.colorwheel.coreui.setDebounceClickListener
import com.example.colorwheel.coreui.showProgressView

class CustomButton @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet
) : FrameLayout(context, attr), Enrichable<CustomButtonModel> {

    init {
        inflate(context, R.layout.custom_button, this)
    }

    private val mainButton by find<Button>(R.id.main_button)
    //private val progressBar by find<ProgressBar>(R.id.progress)

    override fun enrich(model: CustomButtonModel) {
        setMainButtonText(model.buttonText)
    }

    fun clickWheel(){
        mainButton.text = "text"

    }
/*    fun setOnClickAction(action: () -> Unit) {
        mainButton.text = "text"
        //setDebounceClickListener(action)
        //Toast.makeText(context, "toast", Toast.LENGTH_SHORT).show()

    }*/

/*    fun hideProgress() {
        progressBar.hideProgressView(
            endAction = {
                makeGone()
            }
        )
    }

    fun showProgress() {
        progressBar.showProgressView(
            startAction = {
                makeVisible()
            }
        )
    }*/

    private fun setMainButtonText(text: String) {
        mainButton.text = text
    }
}