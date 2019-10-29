package work.kcs_labo.share_shopping_list.activity.main

import android.app.Application
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingMethod
import androidx.lifecycle.AndroidViewModel
import kotlinx.android.synthetic.main.main_act.view.*
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.data.source.TasksRepository

class MainActViewModel(app: Application, private val repository: TasksRepository) : AndroidViewModel(app), Toolbar.OnMenuItemClickListener {
  override fun onMenuItemClick(menuItem: MenuItem): Boolean {
    // メニューがタップされた時の処理
    Log.d(this.javaClass.simpleName, menuItem.itemId.toString())
    return true
  }
}