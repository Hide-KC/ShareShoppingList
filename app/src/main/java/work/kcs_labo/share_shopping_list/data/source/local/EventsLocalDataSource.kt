package work.kcs_labo.share_shopping_list.data.source.local

import work.kcs_labo.share_shopping_list.data.Event
import work.kcs_labo.share_shopping_list.data.source.EventsDataSource

class EventsLocalDataSource(private val eventDao: EventDao) : EventsDataSource {
  override fun findAll(): List<Event> {
    return eventDao.findAll()
  }

  override fun find(eventName: String): List<Event> {
    return eventDao.find("%$eventName%")
  }

  override fun find(id: Long): Event {
    return eventDao.find(id)
  }

  override fun insert(event: Event) {
    eventDao.insert(event)
  }

  override fun update(event: Event): Int {
    return eventDao.update(event)
  }

  override fun delete(event: Event): Int {
    return eventDao.delete(event)
  }

  override fun deleteAll(): Int {
    return eventDao.deleteAll()
  }

  companion object {
    private var INSTANCE: EventsLocalDataSource? = null
    private val lock = Any()

    fun getInstance(eventDao: EventDao): EventsLocalDataSource =
      INSTANCE ?: synchronized(lock) {
        INSTANCE ?: EventsLocalDataSource(eventDao)
          .also {
            INSTANCE = it
          }
      }
  }
}