package work.kcs_labo.share_shopping_list.util

import androidx.annotation.MenuRes
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isEmpty
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import work.kcs_labo.share_shopping_list.data.Fest
import work.kcs_labo.share_shopping_list.list.event_list.FestListAdapter

@BindingAdapter("bind:inflateMenuResId")
fun Toolbar.setInflateMenu(@MenuRes menuResId: Int) {
  if (menu.isEmpty() && menuResId != 0) {
    inflateMenu(menuResId)
  }
}

@BindingAdapter("bind:contents")
fun <E> RecyclerView.setContents(contents: List<E>?) {
  contents?.let {
    when (val adapter = this.adapter) {
      is FestListAdapter -> {
        val mapContents = contents.map { content -> content as Fest }
        adapter.updateList(mapContents)
      }
    }
  }
}