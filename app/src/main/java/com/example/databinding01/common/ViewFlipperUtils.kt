package com.example.databinding01.common

import android.widget.ViewFlipper
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["displayChildren"])
fun ViewFlipper.bindDisplayChildren(index: Int) {
    this.run {
        displayedChild = index
    }
}