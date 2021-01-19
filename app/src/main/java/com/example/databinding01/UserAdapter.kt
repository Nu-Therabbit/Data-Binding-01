package com.example.databinding01

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.ListAdapter
import com.example.databinding01.common.executeAfter
import com.example.databinding01.databinding.ViewUserBinding
import com.example.databinding01.model.BindingViewHolder
import com.example.databinding01.model.UiUser

class UserAdapter(private val lifecycleOwner: LifecycleOwner) :
    ListAdapter<UiUser, BindingViewHolder<UiUser>>(UiUser.UiUserDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<UiUser> {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            ViewUserBinding.inflate(inflater, parent, false)
        return UserViewHolder.create(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<UiUser>, position: Int) {
        holder.binding.executeAfter {
            lifecycleOwner = this@UserAdapter.lifecycleOwner
        }
        holder.bind(getItem(position))
    }
}