package work.kcs_labo.share_shopping_list.usecase

import work.kcs_labo.share_shopping_list.data.Circle

interface CircleControlUseCase {
  fun registerCircle(circle: Circle)
  fun getCircle(eventId: Int, circleId: Int): Circle
  fun getCircles(eventId: Int): List<Circle>
  fun updateCircle(circleId: Int)
  fun deleteCircle(circleId: Int)
  fun deleteAll()
}