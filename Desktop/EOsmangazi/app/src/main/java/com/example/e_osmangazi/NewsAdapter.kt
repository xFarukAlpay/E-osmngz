package com.example.e_osmangazi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_osmangazi.databinding.NewsItemBinding

class NewsAdapter(private val newsItems: List<NewsFetcher.NewsItem>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(private val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(newsItem: NewsFetcher.NewsItem) {
            binding.newsTitleTextView.text = newsItem.title
            Glide.with(binding.newsImageView.context)
                .load(newsItem.imageUrl)
                .into(binding.newsImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsItems[position])
    }

    override fun getItemCount() = newsItems.size
}
