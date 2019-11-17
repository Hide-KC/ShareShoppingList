package work.kcs_labo.share_shopping_list.usecase

import work.kcs_labo.share_shopping_list.data.Task

interface RegisterEventUseCase {
  fun registerEvent(task: Task)
  fun getEvents(): List<Task>
  fun getEvent(id: Long): Task
  fun deleteEvent(id: Long): Int
  fun deleteEventAll(): Int
}