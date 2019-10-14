package work.kcs_labo.share_shopping_list.data.source

import work.kcs_labo.share_shopping_list.data.Task
import work.kcs_labo.share_shopping_list.data.source.local.TasksLocalDataSource
import work.kcs_labo.share_shopping_list.data.source.remote.TasksRemoteDataSource

class TasksRepository(
  private val tasksLocalDataSource: TasksLocalDataSource,
  private val tasksRemoteDataSource: TasksRemoteDataSource
) : TasksDataSource {
  override fun findAll(): List<Task> {
    return tasksLocalDataSource.findAll()
  }

  override fun find(taskName: String): List<Task> {
    return tasksLocalDataSource.find(taskName)
  }

  override fun find(id: Long): Task {
    return tasksLocalDataSource.find(id)
  }

  override fun findCompleted(): List<Task> {
    return tasksLocalDataSource.findCompleted()
  }

  override fun findActive(): List<Task> {
    return tasksLocalDataSource.findActive()
  }

  override fun insert(task: Task) {
    tasksLocalDataSource.insert(task)
  }

  override fun update(task: Task): Int {
    return tasksLocalDataSource.update(task)
  }

  override fun delete(task: Task): Int {
    return tasksLocalDataSource.delete(task)
  }

  override fun deleteCompleted(): Int {
    return tasksLocalDataSource.deleteCompleted()
  }

  override fun deleteAll(): Int {
    return tasksLocalDataSource.deleteAll()
  }

  companion object {
    private var INSTANCE: TasksRepository? = null
    private val lock = Any()

    fun getInstance(
      localDataSource: TasksLocalDataSource,
      remoteDataSource: TasksRemoteDataSource
    ): TasksRepository =
      INSTANCE ?: synchronized(lock) {
        INSTANCE ?: TasksRepository(localDataSource, remoteDataSource)
          .also { INSTANCE = it }
      }
  }
}