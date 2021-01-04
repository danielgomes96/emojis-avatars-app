package com.daniel.avatar_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.daniel.domain.entity.User
import extension.renderUrl

class AvatarListAdapter(
    private val itemClickListener: (User) -> Unit
) : RecyclerView.Adapter<AvatarListAdapter.MyViewHolder>() {

    var avatarList = arrayListOf<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.avatar_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = avatarList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position, itemClickListener)
    }

    inner class MyViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val imEmoji = itemView.findViewById<ImageView>(R.id.item_avatar_image)

        fun bind(position: Int, itemClickListener: (User) -> Unit) {
            val emoji = avatarList[position]
            imEmoji.renderUrl(emoji.imageUrl)
            itemView.setOnClickListener {
                avatarList.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, itemCount)
                itemClickListener(emoji)
            }
        }
    }
}
