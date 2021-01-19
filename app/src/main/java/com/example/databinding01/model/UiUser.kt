package com.example.databinding01.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.recyclerview.widget.DiffUtil
import com.example.databinding01.BR

data class UiUser(
    val id: Long
) : BaseObservable() {
    @get:Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.user)
            notifyPropertyChanged(BR.viewModel)
        }
    var age: Double = 0.0
        set(value) {
            field = value
            notifyChange()
        }

    @get:Bindable
    var gender: Gender? = null
        set(value) {
            field = value
            notifyChange()
        }

    class UiUserDiffCallback : DiffUtil.ItemCallback<UiUser>() {
        override fun areItemsTheSame(oldItem: UiUser, newItem: UiUser): Boolean {
            newItem.age.inc()
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: UiUser, newItem: UiUser): Boolean {
            return oldItem == newItem
        }
    }

    override fun toString(): String {
        return "ID: $id\n" +
                "Name: $name\n" +
                "Age: $age\n" +
                "Gender: $gender"
    }
}