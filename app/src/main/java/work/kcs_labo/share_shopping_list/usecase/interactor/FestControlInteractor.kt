package work.kcs_labo.share_shopping_list.usecase.interactor

import kotlinx.coroutines.cancel
import work.kcs_labo.share_shopping_list.data.Fest
import work.kcs_labo.share_shopping_list.data.RemoteDataSourceCallback
import work.kcs_labo.share_shopping_list.data.source.AppRepository
import work.kcs_labo.share_shopping_list.usecase.FestControlUseCase

class FestControlInteractor(private val repository: AppRepository) :
  FestControlUseCase {
  override suspend fun updateFest(fest: Fest) {
    repository.updateFest(fest)
  }

  override suspend fun getFests(listener: RemoteDataSourceCallback<Fest>): List<Fest> {
    return repository.findAllFests(listener)
  }

  override suspend fun getFest(festId: Long): Fest {
    return repository.findFest(festId)
  }

  override suspend fun deleteFest(fest: Fest) {
    repository.deleteFest(fest)
  }

  override suspend fun deleteFest(eventId: Long) {
    val task = repository.findFest(eventId)
    repository.deleteFest(task)
  }

  override suspend fun deleteFestAll() {
    repository.deleteAllFests()
  }

  override suspend fun registerFest(fest: Fest) {
    repository.insertFest(fest)
  }

  override fun jobCancel() {
    repository.cancel()
  }
}