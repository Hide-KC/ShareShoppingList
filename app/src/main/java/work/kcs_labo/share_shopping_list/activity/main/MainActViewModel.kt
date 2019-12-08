package work.kcs_labo.share_shopping_list.activity.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import work.kcs_labo.share_shopping_list.data.Fest
import work.kcs_labo.share_shopping_list.data.Injection
import work.kcs_labo.share_shopping_list.data.RemoteDataSourceCallback
import work.kcs_labo.share_shopping_list.usecase.FestControlUseCase
import work.kcs_labo.share_shopping_list.usecase.interactor.FestControlInteractor
import work.kcs_labo.share_shopping_list.util.EventWrapper

class MainActViewModel(val app: Application) : AndroidViewModel(app) {

  private val _onOpenCircleListLiveData = MutableLiveData<EventWrapper<Fest>>()
  val onOpenCircleListLiveData: LiveData<EventWrapper<Fest>>
    get() = _onOpenCircleListLiveData

  private val _festListLiveData = MutableLiveData<List<Fest>>()
  val festListLiveData: LiveData<List<Fest>>
    get() = _festListLiveData

  private val useCase: FestControlUseCase =
    FestControlInteractor(
      Injection.provideTasksRepository(
        app.applicationContext
      )
    )

  fun onOpenCircleListAct(eventId: Long) {
    viewModelScope.launch(Dispatchers.IO) {
      val fest = useCase.getFest(eventId)
      fest?.let {
        _onOpenCircleListLiveData.postValue(EventWrapper(it))
      }
    }
  }

  fun registerFest(fest: Fest) {
    viewModelScope.launch(Dispatchers.IO) {
      useCase.registerFest(fest)
    }
  }

  fun getFests() {
    viewModelScope.launch(Dispatchers.IO) {
      launch {
        val fests = useCase.getFests(object : RemoteDataSourceCallback<Fest> {
          override fun onResult(contents: List<Fest>) {
            _festListLiveData.postValue(contents)
          }
        })
        _festListLiveData.postValue(fests)
      }
    }
  }

  fun getFest(id: Int) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  fun deleteFest(id: Int) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun onCleared() {
    super.onCleared()
  }
}