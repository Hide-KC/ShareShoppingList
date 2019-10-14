package work.kcs_labo.share_shopping_list.data.source

import work.kcs_labo.share_shopping_list.data.Task

interface TasksDataSource {
  fun findAll(): List<Task>
  fun find(taskName: String): List<Task>
  fun find(id: Long): Task
  fun findCompleted(): List<Task>
  fun findActive(): List<Task>
  fun insert(task: Task)
  fun update(task: Task): Int
  fun delete(task: Task): Int
  fun deleteCompleted(): Int
  fun deleteAll(): Int
}