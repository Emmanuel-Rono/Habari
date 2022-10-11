package com.example.habari.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.habari.Article
import com.example.habari.R

class DataAdapter:RecyclerView.Adapter<DataAdapter.NewsAdapter>()
{
    inner class NewsAdapter(itemview:View):RecyclerView.ViewHolder(itemview)

    private val diftUtilCallBack=object:DiffUtil.ItemCallback<Article>()
    {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
           return oldItem.url==newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }


    }
    // can consume the values from a LiveData of List and present the data simply for an adapter. It computes
    // differences in list contents via DiffUtil on a background thread as new Lists are received.
    val differ=AsyncListDiffer(this,diftUtilCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter {
       return NewsAdapter(LayoutInflater.from(parent.context).inflate(R.layout.fragment_articles,parent,false))

    }

    override fun onBindViewHolder(holder: NewsAdapter, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}