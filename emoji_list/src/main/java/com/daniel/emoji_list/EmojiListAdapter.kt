package com.daniel.emoji_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.daniel.domain.entity.Emoji
import extension.renderUrl

class EmojiListAdapter(
    private val itemClickListener: (String) -> Unit
) : RecyclerView.Adapter<EmojiListAdapter.MyViewHolder>() {

    var emojiList = arrayListOf<Emoji>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.emoji_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = emojiList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position, itemClickListener)
    }

    inner class MyViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val imEmoji = itemView.findViewById<ImageView>(R.id.item_emoji_image)

        fun bind(position: Int, itemClickListener: (String) -> Unit) {
            val emoji = emojiList[position]
            imEmoji.renderUrl(emoji.imageUrl)
            itemView.setOnClickListener {
                emojiList.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, itemCount)
                itemClickListener(emoji.name)
            }
        }
    }
}
