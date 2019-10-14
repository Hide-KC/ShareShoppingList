package work.kcs_labo.share_shopping_list.activity.todo_item_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import work.kcs_labo.share_shopping_list.data.source.TasksRepository

class TodoItemListViewModel(app: Application, private val repository: TasksRepository) : AndroidViewModel(app) {
}