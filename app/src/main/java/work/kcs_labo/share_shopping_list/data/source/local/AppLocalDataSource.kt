package work.kcs_labo.share_shopping_list.data.source.local

import work.kcs_labo.share_shopping_list.data.Circle
import work.kcs_labo.share_shopping_list.data.Fest
import work.kcs_labo.share_shopping_list.data.RemoteDataSourceCallback
import work.kcs_labo.share_shopping_list.data.source.AppDataSource

class AppLocalDataSource(private val appDao: AppDao) : AppDataSource {
  override suspend fun findAllFests(listener: RemoteDataSourceCallback<Fest>): List<Fest> {
    return appDao.findAllFests()
  }

  override suspend fun findFest(festName: String): List<Fest> {
    return appDao.findFests("%$festName%")
  }

  override suspend fun findFest(id: Long): Fest {
    return appDao.findFests(id)
  }

  override suspend fun insertFest(fest: Fest) {
    appDao.insertFest(fest)
  }

  override suspend fun insertFests(fests: List<Fest>) {
    appDao.insertFests(fests)
  }

  override suspend fun updateFest(fest: Fest) {
    appDao.updateFest(fest)
  }

  override suspend fun deleteFest(fest: Fest) {
    appDao.deleteFest(fest)
  }

  override suspend fun deleteAllFests() {
    appDao.deleteAllFests()
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

  companion object {
    private var INSTANCE: AppLocalDataSource? = null
    private val lock = Any()

    fun getInstance(appDao: AppDao): AppLocalDataSource =
      INSTANCE ?: synchronized(lock) {
        INSTANCE ?: AppLocalDataSource(appDao)
          .also {
            INSTANCE = it
          }
      }
  }
}