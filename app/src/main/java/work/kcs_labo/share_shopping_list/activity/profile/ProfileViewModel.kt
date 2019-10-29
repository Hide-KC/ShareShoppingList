package work.kcs_labo.share_shopping_list.activity.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import work.kcs_labo.share_shopping_list.data.source.TasksRepository

class ProfileViewModel(app: Application, private val repository: TasksRepository) : AndroidViewModel(app) {
}