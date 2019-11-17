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
import work.kcs_labo.share_shopping_list.data.Task
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

    val list = listOf(
      Task(0, "2019-1-1", "hoge0", false.toString()),
      Task(1, "2019-1-1", "hoge1", false.toString()),
      Task(2, "2019-1-1", "hoge3", false.toString()),
      Task(3, "2019-1-1", "hoge4", false.toString()),
      Task(4, "2019-1-2", "hoge5", false.toString()),
      Task(5, "2019-1-2", "hoge6", false.toString()),
      Task(6, "2019-1-2", "hoge7", false.toString()),
      Task(7, "2019-1-3", "hoge8", false.toString()),
      Task(8, "2019-1-3", "hoge9", false.toString()),
      Task(9, "2019-1-4", "hoge10", false.toString()),
      Task(10, "2019-1-4", "hoge11", false.toString()),
      Task(11, "2019-1-4", "hoge12", false.toString()),
      Task(12, "2019-1-5", "hoge13", false.toString()),
      Task(13, "2019-1-5", "hoge14", false.toString()),
      Task(14, "2019-1-6", "hoge15", false.toString()),
      Task(15, "2019-1-6", "hoge16", false.toString()),
      Task(16, "2019-1-7", "hoge17", false.toString()),
      Task(17, "2019-1-8", "hoge18", false.toString()),
      Task(18, "2019-1-8", "hoge19", false.toString()),
      Task(19, "2019-1-8", "hoge20", false.toString())
    )
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
      it.setExtractor(object : PinningListHeaderExtractor<Task, String, EventDate> {
        override val referenceHeaderProperty: KProperty1<Task, String>
          get() = Task::date

        override fun createElement(sectionTopElement: Task): EventDate {
          return EventDate(sectionTopElement.date)
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