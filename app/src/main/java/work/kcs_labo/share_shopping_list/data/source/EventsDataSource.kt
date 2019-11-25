package work.kcs_labo.share_shopping_list.data.source

import work.kcs_labo.share_shopping_list.data.Event

interface EventsDataSource {
  fun insert(event: Event)
  fun findAll(): List<Event>
  fun find(id: Long): Event
  fun find(eventName: String): List<Event>
  fun update(event: Event): Int
  fun delete(event: Event): Int
  fun deleteAll(): Int
}