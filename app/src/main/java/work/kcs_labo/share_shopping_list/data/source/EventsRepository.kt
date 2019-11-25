package work.kcs_labo.share_shopping_list.data.source

import work.kcs_labo.share_shopping_list.data.Event
import work.kcs_labo.share_shopping_list.data.source.local.EventsLocalDataSource
import work.kcs_labo.share_shopping_list.data.source.remote.EventsRemoteDataSource

class EventsRepository(
  private val eventsRemoteDataSource: EventsRemoteDataSource,
  private val eventsLocalDataSource: EventsLocalDataSource
) : EventsDataSource {

  override fun findAll(): List<Event> {
    return eventsLocalDataSource.findAll()
  }

  override fun find(eventName: String): List<Event> {
    return eventsLocalDataSource.find(eventName)
  }

  override fun find(id: Long): Event {
    return eventsLocalDataSource.find(id)
  }

  override fun insert(event: Event) {
    eventsLocalDataSource.insert(event)
  }

  override fun update(event: Event): Int {
    return eventsLocalDataSource.update(event)
  }

  override fun delete(event: Event): Int {
    return eventsLocalDataSource.delete(event)
  }

  override fun deleteAll(): Int {
    return eventsLocalDataSource.deleteAll()
  }

  companion object {
    private var INSTANCE: EventsRepository? = null
    private val lock = Any()

    fun getInstance(
      remoteDataSource: EventsRemoteDataSource,
      localDataSource: EventsLocalDataSource
    ): EventsRepository =
      INSTANCE ?: synchronized(lock) {
        INSTANCE ?: EventsRepository(remoteDataSource, localDataSource)
          .also { INSTANCE = it }
      }
  }
}