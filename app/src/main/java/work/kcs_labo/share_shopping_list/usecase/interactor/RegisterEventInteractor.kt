package work.kcs_labo.share_shopping_list.usecase.interactor

import work.kcs_labo.share_shopping_list.data.Event
import work.kcs_labo.share_shopping_list.data.source.EventsRepository
import work.kcs_labo.share_shopping_list.usecase.RegisterEventUseCase

class RegisterEventInteractor(private val repository: EventsRepository) :
  RegisterEventUseCase {
  override fun updateEvent(event: Event) {
    repository.update(event)
  }

  override fun getEvents(): List<Event> {
    return repository.findAll()
  }

  override fun getEvent(eventId: Long): Event {
    return repository.find(eventId)
  }

  override fun deleteEvent(event: Event) {
    repository.delete(event)
  }

  override fun deleteEvent(eventId: Long) {
    val task = repository.find(eventId)
    repository.delete(task)
  }

  override fun deleteEventAll() {
    repository.deleteAll()
  }

  override fun registerEvent(event: Event) {
    repository.insert(event)
  }
}