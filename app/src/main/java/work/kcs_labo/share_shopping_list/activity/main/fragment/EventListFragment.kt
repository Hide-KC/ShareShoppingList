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
import work.kcs_labo.pinninglistview.PinningListDecoration
import work.kcs_labo.pinninglistview.PinningListHeaderExtractor
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.activity.main.MainAct
import work.kcs_labo.share_shopping_list.activity.main.MainActViewModel
import work.kcs_labo.share_shopping_list.data.Fest
import work.kcs_labo.share_shopping_list.databinding.EventListFragBinding
import work.kcs_labo.share_shopping_list.list.event_list.FestDate
import work.kcs_labo.share_shopping_list.list.event_list.FestListAdapter
import kotlin.reflect.KProperty1

/**
 * Created by hide1 on 2019/10/26.
 * ProjectName ShareShoppingList
 */

class EventListFragment : Fragment() {

  private lateinit var viewModel: MainActViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    viewModel = (activity as MainAct).obtainViewModel()
    val binding =
      DataBindingUtil.inflate<EventListFragBinding>(
        inflater,
        R.layout.event_list_frag,
        container,
        false
      )
        .also {
          it.viewModel = viewModel
          it.lifecycleOwner = this
        }

    setupWidget(binding)

    return binding.root
  }

  private fun setupWidget(binding: EventListFragBinding) {

    viewModel.getFests()
    val list = listOf<Fest>()
    val adapter = FestListAdapter(
      list,
      R.layout.event_list_header
    ).also {
      it.setHeaderClickListener(object : FestListAdapter.OnContentsClickListener<FestDate> {
        override fun onContentsClick(contentDTO: FestListAdapter.OnContentsClickListener.ContentDTO<FestDate>) {
          val eventDate = contentDTO.data
          Log.d(this.javaClass.simpleName, eventDate.startDate)
        }
      })
      it.setItemClickListener(object : FestListAdapter.OnContentsClickListener<Fest> {
        override fun onContentsClick(contentDTO: FestListAdapter.OnContentsClickListener.ContentDTO<Fest>) {
          val event = contentDTO.data
          binding.viewModel?.onOpenCircleListAct(event.id)
        }
      })
      it.setExtractor(object : PinningListHeaderExtractor<Fest, String, FestDate> {
        override val referenceHeaderProperty: KProperty1<Fest, String>
          get() = Fest::startDate

        override fun createElement(sectionTopElement: Fest): FestDate {
          return FestDate(sectionTopElement.startDate)
        }
      })
      it.extractHeader()
    }

    binding.viewModel?.onOpenCircleListLiveData?.observe(this, Observer { eventWrapper ->
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