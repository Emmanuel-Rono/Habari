package com.example.habari.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.habari.Article
import com.example.habari.R

class DataAdapter:RecyclerView.Adapter<DataAdapter.NewsAdapter>()
{


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
        //Get current item
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this ).load(article.urlToImage).into(findViewById(R.id.ImView))
            val newsTitle =findViewById<TextView>(R.id.tvTitle)
            newsTitle.text=article.title
        }

    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }
    inner class NewsAdapter(itemview:View):RecyclerView.ViewHolder(itemview)

    {
        //val imgView=itemview.findViewById<ImageView>(R.id.ImView)
        val tvtitle=itemview.findViewById<TextView>(R.id.tvTitle)

    }

}