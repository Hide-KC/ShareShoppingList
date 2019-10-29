package work.kcs_labo.share_shopping_list.data.source.local

import work.kcs_labo.share_shopping_list.data.Task
import work.kcs_labo.share_shopping_list.data.source.TasksDataSource

class TasksLocalDataSource(private val tasksDao: TasksDao) : TasksDataSource {
  override fun findAll(): List<Task> {
    return tasksDao.findAll()
  }

  override fun find(taskName: String): List<Task> {
    return tasksDao.find("%$taskName%")
  }

  override fun find(id: Long): Task {
    return tasksDao.find(id)
  }

  override fun findCompleted(): List<Task> {
    return tasksDao.findCompleted()
  }

  override fun findActive(): List<Task> {
    return tasksDao.findActive()
  }

  override fun insert(task: Task) {
    tasksDao.insert(task)
  }

  override fun update(task: Task): Int {
    return tasksDao.update(task)
  }

  override fun delete(task: Task): Int {
    return tasksDao.delete(task)
  }

  override fun deleteCompleted(): Int {
    return tasksDao.deleteCompleted()
  }

  override fun deleteAll(): Int {
    return tasksDao.deleteAll()
  }

  companion object {
    private var INSTANCE: TasksLocalDataSource? = null
    private val lock = Any()

    fun getInstance(tasksDao: TasksDao): TasksLocalDataSource =
      INSTANCE ?: synchronized(lock) {
        INSTANCE ?: TasksLocalDataSource(tasksDao)
          .also {
            INSTANCE = it
          }
      }
  }
}