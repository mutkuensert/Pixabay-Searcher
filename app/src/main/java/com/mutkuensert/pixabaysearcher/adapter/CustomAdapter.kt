package com.mutkuensert.pixabaysearcher.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mutkuensert.pixabaysearcher.databinding.SingleItemBinding
import com.mutkuensert.pixabaysearcher.model.HitsModel
import com.mutkuensert.pixabaysearcher.model.MainModel

class CustomAdapter(private var hitsModelList: MutableList<HitsModel>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private lateinit var binding: SingleItemBinding

    class ViewHolder(private val binding: SingleItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(hitsModel: HitsModel){
            binding.item = hitsModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        hitsModelList.get(position).also {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return hitsModelList.size
    }

    fun submitList(newHitsModelList: MutableList<HitsModel>){
        hitsModelList = newHitsModelList
        notifyDataSetChanged()
    }
}