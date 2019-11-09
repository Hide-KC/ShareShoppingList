package work.kcs_labo.share_shopping_list.activity.main.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import work.kcs_labo.pinninglistview.PinningListDecoration
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.activity.main.MainAct
import work.kcs_labo.share_shopping_list.data.Task
import work.kcs_labo.share_shopping_list.databinding.RegisterEventDialogBinding
import work.kcs_labo.share_shopping_list.list.event_list.EventDate
import work.kcs_labo.share_shopping_list.list.event_list.EventListAdapter

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
    val adapter = EventListAdapter(
      list,
      R.layout.event_list_header
    )
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