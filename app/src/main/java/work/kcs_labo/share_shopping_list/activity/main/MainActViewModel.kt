package work.kcs_labo.share_shopping_list.activity.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import work.kcs_labo.share_shopping_list.data.Event
import work.kcs_labo.share_shopping_list.data.Injection
import work.kcs_labo.share_shopping_list.usecase.RegisterEventUseCase
import work.kcs_labo.share_shopping_list.usecase.interactor.RegisterEventInteractor

class MainActViewModel(val app: Application) : AndroidViewModel(app) {

  private val eventListLiveData = MutableLiveData<List<Event>>()
  private val useCase: RegisterEventUseCase =
    RegisterEventInteractor(
      Injection.provideTasksRepository(
        app.applicationContext
      )
    )

  fun registerEvent(event: Event) {
    useCase.registerEvent(event)
  }

  fun getEvents(): List<Event> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  fun getEvent(id: Int): Event {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  fun deleteEvent(id: Int): Boolean {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}