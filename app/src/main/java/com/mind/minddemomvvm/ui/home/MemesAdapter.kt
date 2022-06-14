package com.mind.minddemomvvm.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.Gson
import com.mind.minddemomvvm.R
import com.mind.minddemomvvm.data.models.data.MemesItem
import com.mind.minddemomvvm.databinding.ItemMemesBinding
import com.mind.minddemomvvm.ui.detail.DetailViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemesAdapter @Inject constructor(val viewModel: DetailViewModel) :
    ListAdapter<MemesItem, MemesAdapter.MemesViewHolder>(DiffCallback()) {

    class DiffCallback : DiffUtil.ItemCallback<MemesItem>() {
        override fun areItemsTheSame(oldItem: MemesItem, newItem: MemesItem): Boolean {
            return oldItem.id == newItem.id
         }

        override fun areContentsTheSame(oldItem: MemesItem, newItem: MemesItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemesViewHolder {
        return MemesViewHolder(
            ItemMemesBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: MemesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class MemesViewHolder constructor(private val binding: ItemMemesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(memesItem: MemesItem) {
            binding.memesData = memesItem

            itemView.setOnClickListener(View.OnClickListener {
                val bundle = bundleOf("detail" to Gson().toJson(memesItem))
                Navigation.findNavController(it).navigate(R.id.detailFragment,bundle)

            })
            binding.executePendingBindings()
        }
    }

}