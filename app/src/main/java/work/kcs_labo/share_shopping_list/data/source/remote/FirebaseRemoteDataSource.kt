package work.kcs_labo.share_shopping_list.data.source.remote

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.FirebaseException
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import work.kcs_labo.share_shopping_list.data.Circle
import work.kcs_labo.share_shopping_list.data.Fest
import work.kcs_labo.share_shopping_list.data.RemoteDataSourceCallback
import work.kcs_labo.share_shopping_list.data.source.AppDataSource

class FirebaseRemoteDataSource : AppDataSource {
  private val store = FirebaseFirestore.getInstance()
  private val storage = FirebaseStorage.getInstance()

  override suspend fun findAllFests(listener: RemoteDataSourceCallback<Fest>): List<Fest> {
    return try {
      val documents = store.collection("fests").get().await()
      val fests = documents.map { document -> document.toObject(Fest::class.java) }
      listener.onResult(fests)
      fests
    } catch (e: FirebaseException) {
      Log.w(TAG, "Error getting documents: ", e)
      listOf()
    }
  }

  override suspend fun findFest(eventName: String): List<Fest> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun findFest(id: Long): Fest? {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun insertFest(fest: Fest) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun insertFests(fests: List<Fest>) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun updateFest(fest: Fest) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun deleteFest(fest: Fest) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override suspend fun deleteAllFests() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
    private var INSTANCE: FirebaseRemoteDataSource? = null
    private val lock = Any()

    fun getInstance(): FirebaseRemoteDataSource =
      INSTANCE ?: synchronized(lock) {
        INSTANCE ?: FirebaseRemoteDataSource()
          .also {
            INSTANCE = it
          }
      }
  }
}