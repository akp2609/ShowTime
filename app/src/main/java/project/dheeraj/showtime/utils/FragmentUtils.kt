package project.dheeraj.showtime.utils

import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/** ShowTime by Aman Kumar Pandey */

fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), message, duration).show()
}

/**
 * Returns Color from resource.
 * @param id Color Resource ID
 */
fun Fragment.getColorRes(@ColorRes id: Int) = ContextCompat.getColor(requireContext(), id)
