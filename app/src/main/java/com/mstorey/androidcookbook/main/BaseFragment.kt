package com.mstorey.androidcookbook.main

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mstorey.androidcookbook.R
import java.lang.Exception

/**
 * Generally base classes like this is for establishing shared behavior
 * In this example we have a [getTitle], [showError], and [getStyle] methods
 * Each child of this parent class can override them to define their unique
 */
open class BaseFragment: Fragment() {

    //open in kotlin lets child classes override the specific function
    open fun getTitle(): String? {
        return null
    }

    open fun showError(exception: Exception) {
        // isAdded is a good way to check for null activities since it checks for activity and attached state
        if (isAdded) {
            Toast.makeText(activity, exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Styles are mostly used on an activity level but there are circumstances
     * where styles need to be changed on a fragment level. An example in this app
     * is the fact that each example fragment is treated as a separate experience but all are
     * part of a single activity.
     */
    open fun getStyle(): Int {
        return R.style.BaseAppTheme
    }
}