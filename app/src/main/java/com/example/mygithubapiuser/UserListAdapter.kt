package com.example.mygithubapiuser

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserListAdapter(private val UserDesc: List<ItemsItem>, private val isclick : Boolean) : RecyclerView.Adapter<UserListAdapter.UserListHolder>() {
    class UserListHolder(item : View) : RecyclerView.ViewHolder(item) {
        val imagePhoto : ImageView = item.findViewById(R.id.img_item_photo)
        val username : TextView = item.findViewById(R.id.username_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserListHolder(view)
    }

    override fun getItemCount(): Int = UserDesc.size

    override fun onBindViewHolder(holder: UserListHolder, position: Int) {
        holder.username.text = UserDesc[position].login
        Glide.with(holder.itemView.context)
            .load(UserDesc[position].avatarUrl)
            .into(holder.imagePhoto)
        if (isclick) {
            holder.itemView.setOnClickListener { view ->
                val intent = Intent(view.context, DetailUserActivity::class.java)
                intent.putExtra(DetailUserActivity.USERNAME, UserDesc[position].login)
                view.context.startActivity(intent)
            }
        }
    }
}