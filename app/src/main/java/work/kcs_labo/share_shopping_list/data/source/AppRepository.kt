package work.kcs_labo.share_shopping_list.data.source

import kotlinx.coroutines.*
import work.kcs_labo.share_shopping_list.data.Circle
import work.kcs_labo.share_shopping_list.data.Fest
import work.kcs_labo.share_shopping_list.data.RemoteDataSourceCallback
import work.kcs_labo.share_shopping_list.data.source.local.AppLocalDataSource
import work.kcs_labo.share_shopping_list.data.source.local.AppLocalDatabase
import work.kcs_labo.share_shopping_list.data.source.remote.FirebaseRemoteDataSource
import kotlin.coroutines.CoroutineContext

class AppRepository(
  private val firebaseRemoteDataSource: FirebaseRemoteDataSource,
  private val appLocalDataSource: AppLocalDataSource
) : AppDataSource, CoroutineScope {

  override val coroutineContext: CoroutineContext
    get() = Dispatchers.IO + Job()

  override suspend fun findAllFests(listener: RemoteDataSourceCallback<Fest>): List<Fest> {
    launch {
      val remoteFests = firebaseRemoteDataSource.findAllFests(listener)
      if (!remoteFests.isNullOrEmpty()) {
        appLocalDataSource.deleteAllFests()
        appLocalDataSource.insertFests(remoteFests)
        listener.onResult(remoteFests)
      }
    }

    return appLocalDataSource.findAllFests(listener)
  }

  override suspend fun findFest(eventName: String): List<Fest> {
    return appLocalDataSource.findFest(eventName)
  }

  override suspend fun findFest(id: Long): Fest {
    return appLocalDataSource.findFest(id)
  }

  override suspend fun insertFest(fest: Fest) {
    appLocalDataSource.insertFest(fest)
  }

  override suspend fun insertFests(fests: List<Fest>) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun updateFest(fest: Fest) {
    appLocalDataSource.updateFest(fest)
  }

  override suspend fun deleteFest(fest: Fest) {
    appLocalDataSource.deleteFest(fest)
  }

  override suspend fun deleteAllFests() {
    appLocalDataSource.deleteAllFests()
  }

  override suspend fun deleteAndInsertFests(newFests: List<Fest>, oldFests: List<Fest>) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun insertCircle(circle: Circle) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun insertCircles(circles: List<Circle>) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun findAllCircles(): List<Circle> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun findCircle(id: Long): Circle? {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun findCircle(festName: String): List<Circle> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun updateCircle(circle: Circle) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun deleteCircle(circle: Circle) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun deleteAllCircles() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun deleteAndInsertCircles(newCircles: List<Circle>, oldCircles: List<Circle>) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  fun onDestroy() {
    coroutineContext.cancel()
  }

  companion object {
    private var INSTANCE: AppRepository? = null
    private val lock = Any()

    fun getInstance(
      remoteDataSource: FirebaseRemoteDataSource,
      localDataSource: AppLocalDataSource
    ): AppRepository =
      INSTANCE ?: synchronized(lock) {
        INSTANCE ?: AppRepository(remoteDataSource, localDataSource)
          .also { INSTANCE = it }
      }

    fun destroyInstance() {
      AppLocalDatabase.destroyInstance()
      INSTANCE = null
    }
  }
}