package com.example.databinding01.model

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding01.IBindingViewHolder

abstract class BindingViewHolder<T>(open val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root), IBindingViewHolder<T>