package com.samir.androidapptesting.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samir.androidapptesting.data.models.User
import com.samir.androidapptesting.databinding.ItemUserBinding

class UserAdapter(val data: List<User?>?) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        val view = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: User? = data?.get(position)
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User?) {
            binding.user = user
        }
    }
}