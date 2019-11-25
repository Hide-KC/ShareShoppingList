package work.kcs_labo.share_shopping_list.usecase

import work.kcs_labo.share_shopping_list.data.Event

interface RegisterEventUseCase {
  fun registerEvent(event: Event)
  fun getEvents(): List<Event>
  fun getEvent(id: Long): Event
  fun updateEvent(event: Event)
  fun deleteEvent(id: Long): Int
  fun deleteEventAll(): Int
}