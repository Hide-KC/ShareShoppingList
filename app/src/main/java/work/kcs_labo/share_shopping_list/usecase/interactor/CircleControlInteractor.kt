package work.kcs_labo.share_shopping_list.usecase.interactor

import work.kcs_labo.share_shopping_list.data.Circle
import work.kcs_labo.share_shopping_list.data.source.EventsRepository
import work.kcs_labo.share_shopping_list.usecase.CircleControlUseCase

class CircleControlInteractor(private val repository: EventsRepository) : CircleControlUseCase {
  override fun registerCircle(circle: Circle) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getCircle(eventId: Int, circleId: Int): Circle {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getCircles(eventId: Int): List<Circle> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun updateCircle(circleId: Int) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun deleteCircle(circleId: Int) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun deleteAll() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}