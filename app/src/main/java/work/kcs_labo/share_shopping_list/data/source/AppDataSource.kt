package work.kcs_labo.share_shopping_list.data.source

import work.kcs_labo.share_shopping_list.data.Circle
import work.kcs_labo.share_shopping_list.data.Fest
import work.kcs_labo.share_shopping_list.data.RemoteDataSourceCallback

interface AppDataSource {
  suspend fun insertFest(fest: Fest)
  suspend fun insertFests(fests: List<Fest>)
  suspend fun findAllFests(listener: RemoteDataSourceCallback<Fest>): List<Fest>
  suspend fun findFest(id: Long): Fest?
  suspend fun findFest(festName: String): List<Fest>
  suspend fun updateFest(fest: Fest)
  suspend fun deleteFest(fest: Fest)
  suspend fun deleteAllFests()
  suspend fun deleteAndInsertFests(newFests: List<Fest>, oldFests: List<Fest>)

  suspend fun insertCircle(circle: Circle)
  suspend fun insertCircles(circles: List<Circle>)
  suspend fun findAllCircles(): List<Circle>
  suspend fun findCircle(id: Long): Circle?
  suspend fun findCircle(festName: String): List<Circle>
  suspend fun updateCircle(circle: Circle)
  suspend fun deleteCircle(circle: Circle)
  suspend fun deleteAllCircles()
  suspend fun deleteAndInsertCircles(newCircles: List<Circle>, oldCircles: List<Circle>)
}