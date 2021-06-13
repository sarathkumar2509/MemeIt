package com.droid.memeit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.droid.memeit.databinding.MemeItemBinding
import com.droid.memeit.model.Meme

/**
 * Created by SARATH on 12-06-2021
 */
class TrendingMemeAdapter(private val context: Context) : RecyclerView.Adapter<TrendingMemeAdapter.TrendingMemeViewHolder>() {

    inner class TrendingMemeViewHolder(val binding: MemeItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object :DiffUtil.ItemCallback<Meme>(){
        override fun areItemsTheSame(
            oldItem: Meme,
            newItem: Meme
        ): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(
            oldItem: Meme,
            newItem: Meme
        ): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this,diffCallback)

    var trendingMemeResponse : MutableList<Meme>

    get() = differ.currentList
    set(value) {differ.submitList(value)}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingMemeAdapter.TrendingMemeViewHolder {
        return TrendingMemeViewHolder(MemeItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TrendingMemeAdapter.TrendingMemeViewHolder, position: Int) {
        val meme = trendingMemeResponse[position]
        holder.binding.apply {
            Glide.with(context).load(meme.preview[0]).centerCrop().into(ivMeme)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}