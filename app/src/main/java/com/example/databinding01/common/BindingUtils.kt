@file:JvmName("BindingUtils")

package com.example.databinding01.common

import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.*
import com.example.databinding01.R
import com.example.databinding01.model.Gender
import java.math.BigDecimal
import java.text.DecimalFormat

@InverseMethod("radioIdToGender")
fun genderToRadioId(gender: Gender?): Int {
    return when (gender) {
        Gender.MALE -> R.id.maleRadio
        Gender.FEMALE -> R.id.feMaleRadio
        else -> 0
    }
}

fun radioIdToGender(id: Int?): Gender? {
    return when (id) {
        R.id.maleRadio -> Gender.MALE
        R.id.feMaleRadio -> Gender.FEMALE
        else -> null
    }
}

@InverseMethod("stringToInt")
fun intToString(value: Double): String {
    val TWO_DECIMAL_PLACES_FORMAT = DecimalFormat("#,##0.00")

    return TWO_DECIMAL_PLACES_FORMAT.format(BigDecimal(value))
}

fun stringToInt(value: String): Double {
    val TWO_DECIMAL_PLACES_FORMAT = DecimalFormat("#,##0.00")
    return TWO_DECIMAL_PLACES_FORMAT.parse(value).toDouble()
}

@BindingAdapter(value = ["formatDoubleToString"])
fun EditText.doubleToString(value: Double) {
    if (intToString(value) != text.toString()) {
        setText(intToString(value))
    }
}

@InverseBindingAdapter(attribute = "formatDoubleToString")
fun EditText.stringToDouble(): Double {
    return stringToInt(text.toString())
}

@BindingAdapter("formatDoubleToStringAttrChanged")
fun EditText.setFormatDoubleToStringListener(listener: InverseBindingListener) {
    doAfterTextChanged {
        listener.onChange()
    }
}

inline fun <T : ViewDataBinding> T.executeAfter(block: T.() -> Unit) {
    block()
    executePendingBindings()
}

