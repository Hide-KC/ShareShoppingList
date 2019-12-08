package work.kcs_labo.share_shopping_list.util

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import work.kcs_labo.share_shopping_list.activity.auth.AuthViewModel
import work.kcs_labo.share_shopping_list.activity.circle_list.CircleListActViewModel
import work.kcs_labo.share_shopping_list.activity.main.MainActViewModel
import work.kcs_labo.share_shopping_list.activity.profile.ProfileViewModel

class ViewModelFactory private constructor(
  private val app: Application
) : ViewModelProvider.NewInstanceFactory() {

  override fun <T : ViewModel> create(modelClass: Class<T>) =
    with(modelClass) {
      when {
        isAssignableFrom(MainActViewModel::class.java) ->
          MainActViewModel(app)
        isAssignableFrom(ProfileViewModel::class.java) ->
          ProfileViewModel(app)
        isAssignableFrom(AuthViewModel::class.java) ->
          AuthViewModel(app)
        isAssignableFrom(CircleListActViewModel::class.java) ->
          CircleListActViewModel(app)
        else ->
          throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
      }
    } as T

  companion object {
    private var INSTANCE: ViewModelFactory? = null

    fun getInstance(app: Application): ViewModelFactory =
      INSTANCE ?: synchronized(ViewModelFactory::class.java) {
        INSTANCE ?: ViewModelFactory(app)
          .also { INSTANCE = it }
      }

    fun destroyInstance() {
      INSTANCE = null
    }
  }
}