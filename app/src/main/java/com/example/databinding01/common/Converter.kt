@file:JvmName("Converter")

package com.example.databinding01


import android.widget.EditText
import android.widget.TextView

import androidx.databinding.InverseMethod
import com.google.android.material.textfield.TextInputLayout
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.ParseException


@InverseMethod("toDouble")
fun toString(
    view: EditText, inputLayout: TextInputLayout,
    value: Double
): String? {
    val numberFormat: NumberFormat = getNumberFormat()
    val index = view.selectionStart
    try {
        // Don't return a different value if the parsed value
        // doesn't change
        val inView = view.text.toString()
        val parsed: Double = numberFormat.parse(inView).toDouble()
        if (parsed == value) {
            return numberFormat.format(value)
        }
    } catch (e: ParseException) {
        // Old number was broken
    }
    view.setSelection(index)
    return numberFormat.format(value)
}

fun toDouble(
    view: EditText, inputLayout: TextInputLayout,
    value: String?
): Double {
    val index = view.selectionStart
    val numberFormat: NumberFormat = getNumberFormat()
    view.setSelection(index)
    return try {
        numberFormat.parse(value).toDouble()
    } catch (e: ParseException) {
        inputLayout.error = "Invalid format"
        0.0
    }
}

private fun getNumberFormat(): NumberFormat {
    return DecimalFormat("#,##0.00")
}