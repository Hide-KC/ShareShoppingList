package work.kcs_labo.share_shopping_list.activity.main.fragment

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import work.kcs_labo.pinninglistview.PinningListDecoration
import work.kcs_labo.pinninglistview.PinningListHeaderExtractor
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.activity.main.MainAct
import work.kcs_labo.share_shopping_list.data.Fest
import work.kcs_labo.share_shopping_list.databinding.RegisterEventDialogBinding
import work.kcs_labo.share_shopping_list.list.event_list.FestDate
import work.kcs_labo.share_shopping_list.list.event_list.FestListAdapter
import kotlin.reflect.KProperty1

class RegisterEventDialogFragment : DialogFragment() {

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

    when (val activity = this.activity) {
      is MainAct -> {
        val viewModel = activity.obtainViewModel()
        val inflater = LayoutInflater.from(activity)
        val binding = DataBindingUtil.inflate<RegisterEventDialogBinding>(
          inflater,
          R.layout.register_event_dialog,
          null,
          false
        )
        setupWidget(binding)
        val builder = AlertDialog.Builder(activity)
          .also {
            it.setView(binding.root)
            it.setTitle(getString(R.string.register_event_dialog_title))
            it.setNegativeButton(activity.getString(android.R.string.cancel)) { _, _ -> }
          }
        return builder.create()
      }
      else -> return super.onCreateDialog(savedInstanceState)
    }
  }

  private fun setupWidget(binding: RegisterEventDialogBinding) {

    val list = listOf<Fest>()
    val adapter = FestListAdapter(
      list,
      R.layout.event_list_header
    ).also {
      it.setHeaderClickListener(object : FestListAdapter.OnContentsClickListener<FestDate> {
        override fun onContentsClick(festDTO: FestListAdapter.OnContentsClickListener.ContentDTO<FestDate>) {
          val eventDate = festDTO.data
          Log.d(javaClass.simpleName, eventDate.startDate)
        }
      })
      it.setItemClickListener(object : FestListAdapter.OnContentsClickListener<Fest> {
        override fun onContentsClick(festDTO: FestListAdapter.OnContentsClickListener.ContentDTO<Fest>) {
          val event = festDTO.data
          Log.d(javaClass.simpleName, event.id.toString())
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

    val decor = PinningListDecoration(adapter)
    binding.eventListView.let {
      it.adapter = adapter
      it.addItemDecoration(decor)
      it.layoutManager = LinearLayoutManager(activity)
    }
  }

  companion object {
    fun getInstance(bundle: Bundle?): RegisterEventDialogFragment {
      val fragment = RegisterEventDialogFragment()
      if (bundle != null) {
        fragment.arguments = bundle
      }
      return fragment
    }
  }
}