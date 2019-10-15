package com.standbymik.standbymik2

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.standbymik.standbymik2.model.Topic
import kotlinx.android.synthetic.main.list_topic.view.*

class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindValue(topic: Topic?) {
        itemView.topicTitle.text = topic?.title
        itemView.topicTag.text = topic?.tags?.joinToString(" "){it.name}
        itemView.topicDatetime.text = topic?.createdTime
        itemView.topicComment.text = topic?.viewsCount.toString()
        itemView.topicName.text = topic?.author?.name
        itemView.topicVote.text = topic?.viewsCount.toString()

        if(topic?.thumbnailUrl != null){
            Glide.with(itemView.topicImageView)
                .load(topic.thumbnailUrl)
                .into(itemView.topicImageView)
            itemView.topicImageView.visibility = View.VISIBLE
        }else{
            itemView.topicImageView.visibility = View.GONE
        }
    }

}
