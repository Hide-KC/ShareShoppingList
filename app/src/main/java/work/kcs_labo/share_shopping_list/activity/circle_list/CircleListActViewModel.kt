package work.kcs_labo.share_shopping_list.activity.circle_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import work.kcs_labo.share_shopping_list.data.Circle
import work.kcs_labo.share_shopping_list.data.Injection
import work.kcs_labo.share_shopping_list.usecase.CircleControlUseCase
import work.kcs_labo.share_shopping_list.usecase.interactor.CircleControlInteractor
import work.kcs_labo.share_shopping_list.util.EventWrapper

class CircleListActViewModel(val app: Application) : AndroidViewModel(app) {

  private val _onOpenCircleDetailLiveData = MutableLiveData<EventWrapper<Unit>>()
  val onOpenCircleDetailLiveData: LiveData<EventWrapper<Unit>>
  get() = _onOpenCircleDetailLiveData

  private val circleListLiveData = MutableLiveData<List<Circle>>()
  private val useCase: CircleControlUseCase =
    CircleControlInteractor(
      Injection.provideTasksRepository(
        app.applicationContext
      )
    )

  fun onOpenCircleDetail() {
    _onOpenCircleDetailLiveData.value = EventWrapper(Unit)
  }

  fun registerEvent(circle: Circle) {
    useCase.registerCircle(circle)
  }

  fun getCircles(eventId: Int): List<Circle> {
    return useCase.getCircles(eventId)
  }

  fun getCircle(circleId: Int): Circle {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  fun deleteCircle(circleId: Int): Boolean {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}