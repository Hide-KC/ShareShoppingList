package work.kcs_labo.share_shopping_list.activity.todo_item_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.databinding.TodoItemListActBinding

class TodoItemListAct : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = DataBindingUtil
      .setContentView<TodoItemListActBinding>(this, R.layout.todo_item_list_act)
      .also {
        it.viewModel = ViewModelProviders.of(this).get(TodoItemListViewModel::class.java)
      }

  }
}
