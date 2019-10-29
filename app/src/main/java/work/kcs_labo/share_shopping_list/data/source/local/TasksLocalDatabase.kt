package work.kcs_labo.share_shopping_list.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import work.kcs_labo.share_shopping_list.data.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TasksLocalDatabase : RoomDatabase() {
  abstract fun tasksDao(): TasksDao

  companion object {
    private var INSTANCE: TasksLocalDatabase? = null
    private val lock = Any()

    fun getInstance(context: Context): TasksLocalDatabase =
      INSTANCE ?: synchronized(lock) {
        INSTANCE ?: Room.databaseBuilder(
          context.applicationContext,
          TasksLocalDatabase::class.java, "Tasks.db"
        )
          .build()
          .also { INSTANCE = it }
      }

    fun destroyInstance() {
      INSTANCE = null
    }
  }
}