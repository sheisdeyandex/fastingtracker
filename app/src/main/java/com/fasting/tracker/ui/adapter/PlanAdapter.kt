package com.fasting.tracker.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.fasting.tracker.data.models.PlansModel
import com.fasting.tracker.databinding.ItemPlanBinding

class PlanAdapter  : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val differCallback = object : DiffUtil.ItemCallback<PlansModel>() {
        override fun areItemsTheSame(oldItem: PlansModel, newItem: PlansModel): Boolean {
            return oldItem.title == newItem.title
        }
        override fun areContentsTheSame(oldItem: PlansModel, newItem: PlansModel): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val binding = ItemPlanBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainViewHolder(binding)
    }
    inner class MainViewHolder(private val binding: ItemPlanBinding) : RecyclerView.ViewHolder(binding.root) {
        val adapter=SubPlanAdapter()
        fun bind(sizesModel: PlansModel) {
            binding.tvForBeginners.text = sizesModel.title
            binding.tvSubtitle.text = sizesModel.subtitle
            binding.cvPlan.background = sizesModel.color
            binding.ivPlan.setImageResource(sizesModel.icon)
            binding.rvSubPlan.layoutManager= LinearLayoutManager(binding.rvSubPlan.context,LinearLayoutManager.HORIZONTAL,false)
            binding.rvSubPlan.adapter=adapter
            adapter.differ.submitList(sizesModel.subPlanModel)
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
