package work.kcs_labo.share_shopping_list.activity.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import work.kcs_labo.share_shopping_list.data.Event
import work.kcs_labo.share_shopping_list.data.Injection
import work.kcs_labo.share_shopping_list.usecase.RegisterEventUseCase
import work.kcs_labo.share_shopping_list.usecase.interactor.RegisterEventInteractor
import work.kcs_labo.share_shopping_list.util.EventWrapper

class MainActViewModel(val app: Application) : AndroidViewModel(app) {

  private val _onOpenCircleListLiveData = MutableLiveData<EventWrapper<Event>>()
  val onOpenCircleListLiveData: LiveData<EventWrapper<Event>>
  get() = _onOpenCircleListLiveData

  private val eventListLiveData = MutableLiveData<List<Event>>()
  private val useCase: RegisterEventUseCase =
    RegisterEventInteractor(
      Injection.provideTasksRepository(
        app.applicationContext
      )
    )

  fun onOpenCircleListAct(eventId: Long) {
    viewModelScope.launch(Dispatchers.IO) {
      val event = useCase.getEvent(eventId)
      _onOpenCircleListLiveData.postValue(EventWrapper(event))
    }
  }

  fun registerEvent(event: Event) {
    viewModelScope.launch(Dispatchers.IO) {
      useCase.registerEvent(event)
    }
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