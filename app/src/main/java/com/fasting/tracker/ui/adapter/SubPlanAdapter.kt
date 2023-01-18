package com.fasting.tracker.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

import com.fasting.tracker.data.models.SubPlanModel
import com.fasting.tracker.databinding.ItemSubPlanBinding

class SubPlanAdapter  : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val differCallback = object : DiffUtil.ItemCallback<SubPlanModel>() {
        override fun areItemsTheSame(oldItem: SubPlanModel, newItem: SubPlanModel): Boolean {
            return oldItem.title == newItem.title
        }
        override fun areContentsTheSame(oldItem: SubPlanModel, newItem:SubPlanModel): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val binding = ItemSubPlanBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainViewHolder(binding)
    }
    inner class MainViewHolder(private val binding: ItemSubPlanBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(sizesModel: SubPlanModel) {
            binding.tvDate.text=sizesModel.title
            binding.ivIcon1.setImageResource(sizesModel.icon)
            binding.ivIcon2.setImageResource(sizesModel.iconEat)
            binding.ivDiamond.setImageResource(sizesModel.iconDiamond)
            binding.tvHungry.text=sizesModel.subtitle
            binding.tvEat.text=sizesModel.subtitle2
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is MainViewHolder){
            val foodItem = differ.currentList[position]
            holder.bind(foodItem)
        }

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}
