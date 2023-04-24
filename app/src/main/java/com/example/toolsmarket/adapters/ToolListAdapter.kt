package com.example.toolsmarket.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.toolsmarket.R
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.databinding.DefaultCardBinding
import com.example.toolsmarket.databinding.CardWithoutImageBinding
import com.example.toolsmarket.databinding.RoundCardBinding
import com.example.toolsmarket.databinding.ErrorCardBinding
import com.squareup.picasso.Picasso

class ToolListAdapter : ListAdapter<Tool, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                val binding = DefaultCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                DefaultCardWithBackgroundHolder(binding)
            }
            R.layout.default_card -> {
                val binding = DefaultCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                DefaultCardHolder(binding)
            }
            R.layout.card_without_image -> {
                val binding = CardWithoutImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                CardWithoutImageHolder(binding)
            }
            R.layout.round_card -> {
                val binding = RoundCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                RoundCardHolder(binding)
            }
            R.layout.error_card -> {
                val binding = ErrorCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                ErrorCardHolder(binding)
            }
            else -> throw IllegalStateException("Unknown view type $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Tool.DefaultToolBackground -> 0
            is Tool.DefaultTool -> R.layout.default_card
            is Tool.ToolWithoutImage -> R.layout.card_without_image
            is Tool.RoundTool -> R.layout.round_card
            is Tool.ErrorTool -> R.layout.error_card
            else -> Int.MAX_VALUE
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> (holder as DefaultCardWithBackgroundHolder).bind(getItem(position) as Tool.DefaultToolBackground)
            R.layout.default_card -> (holder as DefaultCardHolder).bind(getItem(position) as Tool.DefaultTool)
            R.layout.card_without_image -> (holder as CardWithoutImageHolder).bind(getItem(position) as Tool.ToolWithoutImage)
            R.layout.round_card -> (holder as RoundCardHolder).bind(getItem(position) as Tool.RoundTool)
            R.layout.error_card -> (holder as ErrorCardHolder).bind(getItem(position) as Tool.ErrorTool)
            else -> throw IllegalStateException("Unknown item view type ${holder.itemViewType}")
        }
    }

    inner class DefaultCardHolder(private val binding: DefaultCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tool: Tool.DefaultTool) = with(binding) {
            try {
                Picasso.get().load(tool.img)
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.broken_image)
                    .into(cardImage)
            } catch (ex: Exception) {
                Log.e("Error", ex.message.toString())
                ex.printStackTrace()
            }
            cardHeader.text = tool.title
            cardInfo.text = tool.subtitle
        }
    }

    inner class DefaultCardWithBackgroundHolder(private val binding: DefaultCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tool: Tool.DefaultToolBackground) = with(binding) {
            try {
                Picasso.get().load(tool.img)
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.broken_image)
                    .into(cardImage)
            } catch (ex: Exception) {
                Log.e("Error", ex.message.toString())
                ex.printStackTrace()
            }
            cardHeader.text = tool.title
            cardInfo.text = tool.subtitle
            try {
                val color = Color.parseColor(tool.hasBag)
                textInfo.setBackgroundColor(color)
            } catch (ex: Exception) {
                Log.e("Error", ex.message.toString())
                ex.printStackTrace()
            }
        }
    }

    inner class CardWithoutImageHolder(private val binding: CardWithoutImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tool: Tool.ToolWithoutImage) = with(binding) {
            cardHeader.text = tool.title
            cardSubhead.text = tool.subtitle
        }
    }

    inner class ErrorCardHolder(private val binding: ErrorCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tool: Tool.ErrorTool) = with(binding) {
            cardHeader.text = tool.title
            cardSubhead.text = tool.subtitle
        }
    }
    inner class RoundCardHolder(private val binding: RoundCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tool: Tool.RoundTool) = with(binding) {
            cardHeader.text = tool.title
            cardSubhead.text = tool.subtitle
            if (tool.isCircle) {
                try {
                    Picasso.get().load(tool.img)
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.broken_image)
                        .into(roundImage)
                } catch (ex: Exception) {
                    Log.e("Error", ex.message.toString())
                    ex.printStackTrace()
                }
            }
        }
    }

    class MyDiffCallback : DiffUtil.ItemCallback<Tool>() {

        override fun areItemsTheSame(oldItem: Tool, newItem: Tool): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Tool, newItem: Tool): Boolean {
            return oldItem == newItem
        }
    }
}