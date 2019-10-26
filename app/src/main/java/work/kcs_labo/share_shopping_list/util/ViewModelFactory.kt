package work.kcs_labo.share_shopping_list.util

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import work.kcs_labo.share_shopping_list.activity.auth.AuthViewModel
import work.kcs_labo.share_shopping_list.activity.main.MainActViewModel
import work.kcs_labo.share_shopping_list.activity.profile.ProfileViewModel
import work.kcs_labo.share_shopping_list.data.Injection
import work.kcs_labo.share_shopping_list.data.source.TasksRepository

class ViewModelFactory private constructor(
  private val app: Application,
  private val tasksRepository: TasksRepository
) : ViewModelProvider.NewInstanceFactory() {

  override fun <T : ViewModel> create(modelClass: Class<T>) =
    with(modelClass) {
      when {
        isAssignableFrom(MainActViewModel::class.java) ->
          MainActViewModel(app, tasksRepository)
        isAssignableFrom(ProfileViewModel::class.java) ->
          ProfileViewModel(app, tasksRepository)
        isAssignableFrom(AuthViewModel::class.java) ->
          AuthViewModel(app)
        else ->
          throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
      }
    } as T

  companion object {
    private var INSTANCE: ViewModelFactory? = null

    fun getInstance(app: Application): ViewModelFactory =
      INSTANCE ?: synchronized(ViewModelFactory::class.java) {
        INSTANCE ?: ViewModelFactory(app, Injection.provideTasksRepository(app.applicationContext))
          .also { INSTANCE = it }
      }

    fun destroyInstance() {
      INSTANCE = null
    }
  }
}