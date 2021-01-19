package com.example.databinding01.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}

@BindingAdapter(value = ["setItems"])
fun RecyclerView.bindRecyclerData(data: List<Any>?) {
    this.run {
        (this.adapter as? ListAdapter<Any, *>)?.submitList(data)
    }
}