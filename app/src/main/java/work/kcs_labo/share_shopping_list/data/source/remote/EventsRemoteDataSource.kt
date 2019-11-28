package work.kcs_labo.share_shopping_list.data.source.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import work.kcs_labo.share_shopping_list.data.Event
import work.kcs_labo.share_shopping_list.data.source.EventsDataSource

class EventsRemoteDataSource : EventsDataSource {
  private val store = FirebaseFirestore.getInstance()
  private val storage = FirebaseStorage.getInstance()

  override fun findAll(): List<Event> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun find(eventName: String): List<Event> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun find(id: Long): Event {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun insert(event: Event) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun update(event: Event): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun delete(event: Event): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun deleteAll(): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  companion object {
    private var INSTANCE: EventsRemoteDataSource? = null
    private val lock = Any()

    fun getInstance(): EventsRemoteDataSource =
      INSTANCE ?: synchronized(lock) {
        INSTANCE ?: EventsRemoteDataSource()
          .also {
            INSTANCE = it
          }
      }
  }
}