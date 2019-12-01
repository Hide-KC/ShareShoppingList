package work.kcs_labo.share_shopping_list.usecase

import work.kcs_labo.share_shopping_list.data.Event

interface RegisterEventUseCase {
  fun registerEvent(event: Event)
  fun getEvents(): List<Event>
  fun getEvent(eventId: Long): Event
  fun updateEvent(event: Event)
  fun deleteEvent(event: Event)
  fun deleteEvent(eventId: Long)
  fun deleteEventAll()
}