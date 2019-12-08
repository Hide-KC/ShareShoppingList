package work.kcs_labo.share_shopping_list.usecase.interactor

import work.kcs_labo.share_shopping_list.data.Circle
import work.kcs_labo.share_shopping_list.data.source.AppRepository
import work.kcs_labo.share_shopping_list.usecase.CircleControlUseCase

class CircleControlInteractor(private val repository: AppRepository) : CircleControlUseCase {
  override suspend fun registerCircle(circle: Circle) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun getCircle(festId: Int, circleId: Int): Circle {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun getCircles(festId: Int): List<Circle> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun updateCircle(circleId: Int) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun deleteCircle(circleId: Int) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun deleteAll() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}