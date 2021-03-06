package work.kcs_labo.share_shopping_list.data

import android.content.Context
import work.kcs_labo.share_shopping_list.data.source.TasksRepository
import work.kcs_labo.share_shopping_list.data.source.local.TasksLocalDatabase
import work.kcs_labo.share_shopping_list.data.source.local.TasksLocalDataSource
import work.kcs_labo.share_shopping_list.data.source.remote.TasksRemoteDataSource

object Injection {
  fun provideTasksRepository(context: Context): TasksRepository {
    val localDatabase = TasksLocalDatabase.getInstance(context)
    val remoteDataSource = TasksRemoteDataSource.getInstance()
    return TasksRepository.getInstance(
      remoteDataSource,
      TasksLocalDataSource.getInstance(localDatabase.tasksDao())
    )
  }
}