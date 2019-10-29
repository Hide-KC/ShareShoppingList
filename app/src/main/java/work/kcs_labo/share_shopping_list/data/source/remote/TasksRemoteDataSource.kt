package work.kcs_labo.share_shopping_list.data.source.remote

import com.google.firebase.firestore.FirebaseFirestore
import work.kcs_labo.share_shopping_list.data.Task
import work.kcs_labo.share_shopping_list.data.source.TasksDataSource

class TasksRemoteDataSource : TasksDataSource {
  private val db = FirebaseFirestore.getInstance()

  override fun findAll(): List<Task> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun find(taskName: String): List<Task> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun find(id: Long): Task {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun findCompleted(): List<Task> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun findActive(): List<Task> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun insert(task: Task) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun update(task: Task): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun delete(task: Task): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun deleteCompleted(): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun deleteAll(): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  companion object {
    private var INSTANCE: TasksRemoteDataSource? = null
    private val lock = Any()

    fun getInstance(): TasksRemoteDataSource =
      INSTANCE ?: synchronized(lock) {
        INSTANCE ?: TasksRemoteDataSource()
          .also {
            INSTANCE = it
          }
      }
  }
}