package work.kcs_labo.share_shopping_list.list.event_list

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

class EventListAdapter(list: List<Task>, @LayoutRes override val headerLayout: Int?) :
  PinningListAdapter<Task, String, EventDate, RecyclerView.ViewHolder>(list) {

  companion object Constants {
    const val SECTION_ITEM = 201
  }

  private var headerClickListener: View.OnClickListener? = null
  private var itemClickListener: View.OnClickListener? = null

  fun setHeaderClickListener(listener: View.OnClickListener?) {
    this.headerClickListener = listener
  }

  fun setItemClickListener(listener: View.OnClickListener?) {
    this.itemClickListener = listener
  }

  override fun bindHeaderData(header: View, adapterPosition: Int) {
    val item = innerList[adapterPosition] as EventDate
    header.eventDate.text = item.eventDate
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, adapterPosition: Int) {
    when (holder) {
      is EventDateViewHolder -> {
        val item = innerList[adapterPosition] as EventDate
        holder.eventDate.text = item.eventDate
        holder.setHeaderClickListener(this.headerClickListener)

      }
      is EventItemViewHolder -> {
        val item = innerList[adapterPosition] as Task
        holder.eventName.text = item.name
        holder.setItemClickListener(this.itemClickListener)
      }
      else -> {
        throw IllegalArgumentException("<${innerList[adapterPosition].javaClass}> class is not declared in Adapter.")
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    return when {
      viewType == SECTION_HEADER && headerLayout != null -> {
        EventDateViewHolder(
          DataBindingUtil.inflate(inflater, headerLayout, parent, false)
        )
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
      else -> throw IllegalArgumentException(this.javaClass.simpleName)
    }
  }

  override fun getItemViewType(adapterPosition: Int): Int =
    when (innerList[adapterPosition]) {
      is Task -> SECTION_ITEM
      is EventDate -> SECTION_HEADER
      else -> {
        throw IllegalArgumentException("<${innerList[adapterPosition].javaClass}> class is not declared in Adapter.")
      }
    }

  class EventDateViewHolder(private val binding: EventListHeaderBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val eventDate: TextView = binding.root.eventDate

    fun setHeaderClickListener(listener: View.OnClickListener?) {
      this.binding.root.setOnClickListener(listener)
    }
  }

  class EventItemViewHolder(private val binding: EventListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val eventName: TextView = binding.root.eventName

    fun setItemClickListener(listener: View.OnClickListener?) {
      this.binding.root.setOnClickListener(listener)
    }
  }
}