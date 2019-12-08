package work.kcs_labo.share_shopping_list.usecase

import work.kcs_labo.share_shopping_list.data.Fest
import work.kcs_labo.share_shopping_list.data.RemoteDataSourceCallback

interface FestControlUseCase {
  suspend fun registerFest(fest: Fest)
  suspend fun getFests(listener: RemoteDataSourceCallback<Fest>): List<Fest>
  suspend fun getFest(festId: Long): Fest?
  suspend fun updateFest(fest: Fest)
  suspend fun deleteFest(fest: Fest)
  suspend fun deleteFest(eventId: Long)
  suspend fun deleteFestAll()
  fun jobCancel()
}