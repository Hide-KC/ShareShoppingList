package work.kcs_labo.share_shopping_list.list.event_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.event_list_header.view.*
import work.kcs_labo.pinninglistview.PinningListAdapter
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.data.Fest
import work.kcs_labo.share_shopping_list.databinding.EventListHeaderBinding
import work.kcs_labo.share_shopping_list.databinding.EventListItemBinding

class FestListAdapter(list: List<Fest>, @LayoutRes override val headerLayout: Int?) :
  PinningListAdapter<Fest, String, FestDate, RecyclerView.ViewHolder>(list) {

  companion object Constants {
    const val SECTION_ITEM = 201
  }

  private var headerClickListener: OnContentsClickListener<FestDate>? = null
  private var itemClickListener: OnContentsClickListener<Fest>? = null

  fun setHeaderClickListener(listener: OnContentsClickListener<FestDate>?) {
    this.headerClickListener = listener
  }

  fun setItemClickListener(listener: OnContentsClickListener<Fest>?) {
    this.itemClickListener = listener
  }

  fun updateList(newList: List<Fest>) {
    fetch(newList)
    extractHeader()
    notifyDataSetChanged()
  }

  override fun bindHeaderData(header: View, adapterPosition: Int) {
    val item = getInnerListItem(adapterPosition) as FestDate
    header.eventDate.text = item.startDate
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, adapterPosition: Int) {
    when (holder) {
      is EventDateViewHolder -> {
        val item = getInnerListItem(adapterPosition) as FestDate
        holder.binding.model = item
        holder.setHeaderClickListener(this.headerClickListener)
        holder.binding.executePendingBindings()
      }
      is EventItemViewHolder -> {
        val item = getInnerListItem(adapterPosition) as Fest
        holder.binding.model = item
        holder.setItemClickListener(this.itemClickListener)
        holder.binding.executePendingBindings()
      }
      else -> {
        throw IllegalArgumentException("<${getInnerListItem(adapterPosition).javaClass}> class is not declared in Adapter.")
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
          DataBindingUtil.inflate(inflater, R.layout.event_list_item, parent, false)
        )
      }
      else -> throw IllegalArgumentException(this.javaClass.simpleName)
    }
  }

  override fun getItemViewType(adapterPosition: Int): Int =
    when (getInnerListItem(adapterPosition)) {
      is FestDate -> SECTION_HEADER
      is Fest -> SECTION_ITEM
      else -> {
        throw IllegalArgumentException("<${getInnerListItem(adapterPosition).javaClass}> class is not declared in Adapter.")
      }
    }

  class EventDateViewHolder(val binding: EventListHeaderBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun setHeaderClickListener(listener: OnContentsClickListener<FestDate>?) {
      this.binding.root.setOnClickListener {
        this.binding.root.setOnClickListener {
          val eventDate = binding.model
          if (eventDate != null) {
            listener?.onContentsClick(OnContentsClickListener.ContentDTO(eventDate))
          }
        }
      }
    }
  }

  class EventItemViewHolder(val binding: EventListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun setItemClickListener(listener: OnContentsClickListener<Fest>?) {
      this.binding.root.setOnClickListener {
        val event = binding.model
        if (event != null) {
          listener?.onContentsClick(OnContentsClickListener.ContentDTO(event))
        }
      }
    }
  }

  interface OnContentsClickListener<T> {
    fun onContentsClick(contentDTO: ContentDTO<T>)

    data class ContentDTO<T>(
      val data: T
    )
  }
}