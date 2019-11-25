package work.kcs_labo.share_shopping_list.activity.main.fragment;

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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

    val list = listOf<Event>()
    val adapter = EventListAdapter(
      list,
      R.layout.event_list_header
    ).also {
      it.setHeaderClickListener(View.OnClickListener { view ->
        Log.d(javaClass.simpleName, view.eventDate.text.toString())
      })
      it.setItemClickListener(View.OnClickListener { view ->
        Log.d(javaClass.simpleName, view.eventName.text.toString())
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