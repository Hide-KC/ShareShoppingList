package work.kcs_labo.share_shopping_list.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.event_list_header.view.*
import kotlinx.android.synthetic.main.event_list_item.view.*
import work.kcs_labo.pinninglistview.PinningListAdapter
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.data.Task
import work.kcs_labo.share_shopping_list.databinding.EventListHeaderBinding
import work.kcs_labo.share_shopping_list.databinding.EventListItemBinding

class EventListAdapter(private val list: List<Any>, @LayoutRes override val headerLayout: Int?) :
  PinningListAdapter<Any, RecyclerView.ViewHolder>(list) {

  companion object Constants {
    const val SECTION_ITEM = 201
  }

  override fun bindHeaderData(header: View, adapterPosition: Int) {
    val item = list[adapterPosition] as EventDate
    header.eventDate.text = item.eventDate
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, adapterPosition: Int) {
    when (holder) {
      is EventDateViewHolder -> {
        val item = list[adapterPosition] as EventDate
        holder.eventDate.text = item.eventDate
      }
      is EventItemViewHolder -> {
        val item = list[adapterPosition] as Task
        holder.eventName.text = item.name
      }
      else -> {
        throw IllegalArgumentException("<${list[adapterPosition].javaClass}> class is not declared in Adapter.")
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    return when {
      viewType == SECTION_HEADER && headerLayout != null -> {
        EventDateViewHolder(DataBindingUtil.inflate(inflater, headerLayout, parent, false))
      }
      viewType == SECTION_ITEM -> {
        EventItemViewHolder(
          DataBindingUtil.inflate(
            inflater,
            R.layout.event_list_item,
            parent,
            false
          )
        )
      }
      else -> throw IllegalArgumentException("hoge")
    }
  }

  override fun getItemViewType(position: Int): Int =
    when (list[position]) {
      is Task -> {
        SECTION_ITEM
      }
      is EventDate -> {
        SECTION_HEADER
      }
      else -> {
        throw IllegalArgumentException("<${list[position].javaClass}> class is not declared in Adapter.")
      }
    }

  class EventDateViewHolder(binding: EventListHeaderBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val eventDate: TextView = binding.root.eventDate
  }

  class EventItemViewHolder(binding: EventListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    val eventName: TextView = binding.root.eventName
  }
}