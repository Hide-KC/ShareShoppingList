package work.kcs_labo.share_shopping_list.util

import androidx.annotation.MenuRes
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isEmpty
import androidx.databinding.BindingAdapter

@BindingAdapter("bind:inflateMenuResId")
fun Toolbar.setInflateMenu(@MenuRes menuResId: Int) {
  if (menu.isEmpty() && menuResId != 0) {
    inflateMenu(menuResId)
  }
}