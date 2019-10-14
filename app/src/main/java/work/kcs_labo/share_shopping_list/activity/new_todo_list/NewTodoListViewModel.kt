package work.kcs_labo.share_shopping_list.activity.new_todo_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import work.kcs_labo.share_shopping_list.data.source.TasksRepository

class NewTodoListViewModel(app: Application, private val repository: TasksRepository) : AndroidViewModel(app) {
}