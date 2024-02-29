package com.example.colorwheel.coreui

import android.os.SystemClock
import android.view.View
import androidx.annotation.IdRes
import androidx.core.view.isVisible

fun <T: View> View.find(@IdRes idRes: Int): Lazy<T> {
    return nonSafeLazy { findViewById(idRes) }
}

fun <T> nonSafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)

fun View.setDebounceClickListener(
    action: () -> Unit,
) {
    isClickable = true
    setOnClickListener(getDebounceClickListener(action))
}

private const val DELAY_TIME = 300L

private fun getDebounceClickListener(
    action: () -> Unit,
): View.OnClickListener {
    return object : View.OnClickListener {

        private var lastClickTime = 0L

        override fun onClick(v: View?) {
            val currentTime = SystemClock.uptimeMillis()
            if (lastClickTime == 0L || currentTime - lastClickTime >= DELAY_TIME) {
                lastClickTime = currentTime
                action()
            }
        }
    }
}

private const val PROGRESS_ANIMATE_DURATION = 300L

fun View.hideProgressView(
    endAction: View.() -> Unit
) {
    animate()
        .alpha(0f)
        .setDuration(PROGRESS_ANIMATE_DURATION)
        .withEndAction { endAction() }
}

fun View.showProgressView(
    startAction: View.() -> Unit
) {
    animate()
        .alpha(1f)
        .setDuration(PROGRESS_ANIMATE_DURATION)
        .withStartAction { startAction() }
}

fun View.makeGone() {
    visibility = View.GONE
}

fun View.makeVisible() {
    visibility = View.VISIBLE
}