package work.kcs_labo.share_shopping_list.usecase.interactor

import work.kcs_labo.share_shopping_list.data.Task
import work.kcs_labo.share_shopping_list.data.source.TasksRepository
import work.kcs_labo.share_shopping_list.usecase.RegisterEventUseCase

class RegisterEventInteractor(private val repository: TasksRepository) :
  RegisterEventUseCase {
  override fun getEvents(): List<Task> {
    return repository.findAll()
  }

  override fun getEvent(id: Long): Task {
    return repository.find(id)
  }

  override fun deleteEvent(id: Long): Int {
    val task = repository.find(id)
    return repository.delete(task)
  }

  override fun deleteEventAll(): Int {
    return repository.deleteAll()
  }

  override fun registerEvent(task: Task) {
    repository.insert(task)
  }
}