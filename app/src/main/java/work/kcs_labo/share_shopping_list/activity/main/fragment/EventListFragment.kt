package work.kcs_labo.share_shopping_list.activity.main.fragment;

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.event_list_header.view.*
import kotlinx.android.synthetic.main.event_list_item.view.*
import work.kcs_labo.pinninglistview.PinningListDecoration
import work.kcs_labo.pinninglistview.PinningListHeaderExtractor
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.activity.main.MainAct
import work.kcs_labo.share_shopping_list.data.Event
import work.kcs_labo.share_shopping_list.databinding.EventListFragBinding
import work.kcs_labo.share_shopping_list.list.event_list.EventDate
import work.kcs_labo.share_shopping_list.list.event_list.EventListAdapter
import work.kcs_labo.share_shopping_list.util.EventWrapper
import kotlin.reflect.KProperty1

/**
 * Created by hide1 on 2019/10/26.
 * ProjectName ShareShoppingList
 */

class EventListFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val viewModel = (activity as MainAct).obtainViewModel()
    val binding =
      DataBindingUtil.inflate<EventListFragBinding>(
        inflater,
        R.layout.event_list_frag,
        container,
        false
      )
        .also {
          it.viewModel = viewModel
        }

    setupWidget(binding)

    return binding.root
  }

  private fun setupWidget(binding: EventListFragBinding) {

    val list = listOf<Event>(
      Event(0, "hoge", "fuga", "2020-01-01", "2020-01-02", "foo"),
      Event(0, "hoge", "fuga", "2020-01-01", "2020-01-02", "foo"),
      Event(0, "hoge", "fuga", "2020-01-02", "2020-01-02", "foo"),
      Event(0, "hoge", "fuga", "2020-01-02", "2020-01-02", "foo"),
      Event(0, "hoge", "fuga", "2020-01-03", "2020-01-02", "foo"),
      Event(0, "hoge", "fuga", "2020-01-03", "2020-01-02", "foo"),
      Event(0, "hoge", "fuga", "2020-01-04", "2020-01-02", "foo"),
      Event(0, "hoge", "fuga", "2020-01-04", "2020-01-02", "foo"),
      Event(0, "hoge", "fuga", "2020-01-05", "2020-01-02", "foo"),
      Event(0, "hoge", "fuga", "2020-01-05", "2020-01-02", "foo"),
      Event(0, "hoge", "fuga", "2020-01-06", "2020-01-02", "foo")
    )
    val adapter = EventListAdapter(
      list,
      R.layout.event_list_header
    ).also {
      it.setHeaderClickListener(object : EventListAdapter.OnContentsClickListener<EventDate> {
        override fun onContentsClick(eventDTO: EventListAdapter.OnContentsClickListener.EventDTO<EventDate>) {
          val eventDate = eventDTO.data
          Log.d(this.javaClass.simpleName, eventDate.eventStartDate)
        }
      })
      it.setItemClickListener(object : EventListAdapter.OnContentsClickListener<Event> {
        override fun onContentsClick(eventDTO: EventListAdapter.OnContentsClickListener.EventDTO<Event>) {
          val event = eventDTO.data
          binding.viewModel?.onOpenCircleListAct(event.id)
        }
      })
      it.setExtractor(object : PinningListHeaderExtractor<Event, String, EventDate> {
        override val referenceHeaderProperty: KProperty1<Event, String>
          get() = Event::eventStartDate

        override fun createElement(sectionTopElement: Event): EventDate {
          return EventDate(sectionTopElement.eventStartDate)
        }
      })
      it.extractHeader()
    }

    binding.viewModel?.onOpenCircleListLiveData?.observe(this, Observer {eventWrapper ->
      eventWrapper.getContentIfNotHandled()?.let {
        (activity as MainAct).startCircleListAct(eventWrapper.peekContent())
      }
    })

    val decor = PinningListDecoration(adapter)
    binding.eventListView.let {
      it.adapter = adapter
      it.addItemDecoration(decor)
      it.layoutManager = LinearLayoutManager(activity)
    }
  }

  companion object {
    fun getInstance(bundle: Bundle?): EventListFragment {
      val fragment = EventListFragment()
      if (bundle != null) {
        fragment.arguments = bundle
      }
      return fragment
    }
  }
}