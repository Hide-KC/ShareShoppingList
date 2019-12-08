package work.kcs_labo.share_shopping_list.usecase

import work.kcs_labo.share_shopping_list.data.Circle

interface CircleControlUseCase {
  suspend fun registerCircle(circle: Circle)
  suspend fun getCircle(festId: Int, circleId: Int): Circle
  suspend fun getCircles(festId: Int): List<Circle>
  suspend fun updateCircle(circleId: Int)
  suspend fun deleteCircle(circleId: Int)
  suspend fun deleteAll()
}