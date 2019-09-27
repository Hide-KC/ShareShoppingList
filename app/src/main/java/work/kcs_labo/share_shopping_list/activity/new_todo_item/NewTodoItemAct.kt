package work.kcs_labo.share_shopping_list.activity.new_todo_item

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.databinding.NewTodoItemActBinding

class NewTodoItemAct : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = DataBindingUtil
      .setContentView<NewTodoItemActBinding>(this, R.layout.new_todo_item_act)
      .also {
        it.viewModel = ViewModelProviders.of(this).get(NewTodoItemViewModel::class.java)
      }

  }
}
