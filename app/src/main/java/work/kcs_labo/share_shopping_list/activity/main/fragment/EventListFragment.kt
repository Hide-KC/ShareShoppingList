package work.kcs_labo.share_shopping_list.activity.main.fragment;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import work.kcs_labo.pinninglistview.PinningListDecoration
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.activity.main.MainAct
import work.kcs_labo.share_shopping_list.data.Task
import work.kcs_labo.share_shopping_list.databinding.EventListFragBinding
import work.kcs_labo.share_shopping_list.list.EventDate
import work.kcs_labo.share_shopping_list.list.EventListAdapter

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

    val list = listOf(
      EventDate("2018-12-1"),
      Task(0, "hoge0", false.toString()),
      Task(1, "hoge1", false.toString()),
      EventDate("2018-12-2"),
      Task(2, "hoge3", false.toString()),
      Task(3, "hoge4", false.toString()),
      EventDate("2018-12-3"),
      Task(4, "hoge5", false.toString()),
      Task(5, "hoge6", false.toString()),
      EventDate("2018-12-4"),
      Task(6, "hoge7", false.toString()),
      Task(7, "hoge8", false.toString()),
      EventDate("2018-12-5"),
      Task(8, "hoge9", false.toString()),
      Task(9, "hoge10", false.toString()),
      EventDate("2018-12-6"),
      Task(10, "hoge11", false.toString()),
      Task(11, "hoge12", false.toString()),
      EventDate("2018-12-7"),
      Task(12, "hoge13", false.toString()),
      Task(13, "hoge14", false.toString()),
      EventDate("2018-12-8"),
      Task(14, "hoge15", false.toString()),
      Task(15, "hoge16", false.toString()),
      EventDate("2018-12-9"),
      Task(16, "hoge17", false.toString()),
      Task(17, "hoge18", false.toString()),
      EventDate("2018-12-10"),
      Task(18, "hoge19", false.toString()),
      Task(19, "hoge20", false.toString())
    )
    val adapter = EventListAdapter(list, R.layout.event_list_header)
    val decor = PinningListDecoration(adapter)
    binding.eventListView.let {
      it.adapter = adapter
      it.addItemDecoration(decor)
      it.layoutManager = LinearLayoutManager(activity)
    }
    return binding.root
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