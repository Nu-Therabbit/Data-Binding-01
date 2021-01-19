package com.example.databinding01

import com.example.databinding01.databinding.ViewUserBinding
import com.example.databinding01.model.BindingViewHolder
import com.example.databinding01.model.UiUser

class UserViewHolder(override var binding: ViewUserBinding) :
    BindingViewHolder<UiUser>(binding) {

    companion object {
        fun create(
            binding: ViewUserBinding
        ): UserViewHolder {
            return UserViewHolder(binding)
        }
    }

    override fun bind(data: UiUser?) {
        binding.user = data
        binding.increaseButton.setOnClickListener {
            data?.apply { age++ }
        }
        binding.decreaseButton.setOnClickListener {
            data?.apply { age-- }
        }
        binding.executePendingBindings()
    }
}