package work.kcs_labo.share_shopping_list.activity.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import work.kcs_labo.share_shopping_list.data.source.TasksRepository

class MainActViewModel(app: Application, private val repository: TasksRepository) : AndroidViewModel(app) {
}