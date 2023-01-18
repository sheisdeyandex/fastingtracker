package com.fasting.tracker.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.fasting.tracker.data.models.PlansModel
import com.fasting.tracker.databinding.ItemOwnPlanBinding
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
        if (viewType == 1) {
            val binding =
                ItemPlanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MainViewHolder(binding)
        }
       else {
            val binding =
                ItemOwnPlanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return OwnPlanViewHolder(binding)
        }

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
    inner class OwnPlanViewHolder(private val binding: ItemOwnPlanBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(sizesModel: PlansModel) {
            binding.tvForBeginners.text = sizesModel.title
            binding.tvSubtitle.text = sizesModel.subtitle
            binding.cvPlan.background = sizesModel.color
            binding.ivPlan.setImageResource(sizesModel.icon)
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is MainViewHolder){
            val foodItem = differ.currentList[position]
            holder.bind(foodItem)
        }
        if (holder is OwnPlanViewHolder){
            holder.bind(differ.currentList[position])
        }

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        if (position==3){
            return 2
        }
        else{
            return 1
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}
