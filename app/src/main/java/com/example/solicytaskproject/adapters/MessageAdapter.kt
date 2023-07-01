package com.example.solicytaskproject.adapters

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.solicytaskproject.R
import com.example.solicytaskproject.databinding.ItemInboxBinding
import com.example.solicytaskproject.models.MessageData

class MessageAdapter(
    val onClick: (MessageData) -> Unit,
    val onFavoriteClick: (MessageData) -> Unit,
    val onReadClick: (MessageData) -> Unit
) :
    ListAdapter<MessageData, MessageAdapter.MessageViewHolder>(MessageDiffUtil()) {
    inner class MessageViewHolder(val binding: ItemInboxBinding) :
        ViewHolder(binding.root) {
        fun bind(message: MessageData) {
            with(binding) {
                with(message) {
                    tvFromUser.text = this.senderName
                    tvDateOfMessage.text = this.date
                    tvMessage.text = this.message
                    tvSubjectMessage.text = this.subjectOfMessage
                    Glide.with(root).load(this.userImage).into(binding.userImage)
                    if (this.isFavorite) {
                        favoriteButton.setImageDrawable(
                            root.resources.getDrawable(
                                R.drawable.ic_star_filled,
                                null
                            )
                        )
                    } else {
                        favoriteButton.setImageDrawable(
                            root.resources.getDrawable(
                                R.drawable.ic_star,
                                null
                            )
                        )
                    }
                    if (this.isRead) {
                        tvFromUser.setTypeface(null, Typeface.BOLD)
                        tvSubjectMessage.setTypeface(null, Typeface.BOLD)
                        tvDateOfMessage.setTypeface(null, Typeface.BOLD)
                    } else {
                        tvFromUser.setTypeface(null, Typeface.NORMAL)
                        tvSubjectMessage.setTypeface(null, Typeface.NORMAL)
                        tvDateOfMessage.setTypeface(null, Typeface.NORMAL)
                    }
                }
            }
        }
    }

    class MessageDiffUtil : DiffUtil.ItemCallback<MessageData>() {
        override fun areItemsTheSame(oldItem: MessageData, newItem: MessageData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MessageData, newItem: MessageData): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            ItemInboxBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.binding.root.setOnClickListener {
            onClick(item)
            onReadClick(item)
        }
        holder.binding.favoriteButton.setOnClickListener {
            onFavoriteClick(item)
        }

    }
}