package work.kcs_labo.share_shopping_list.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import work.kcs_labo.share_shopping_list.data.Circle
import work.kcs_labo.share_shopping_list.data.Event

@Database(entities = [Event::class, Circle::class], version = 1, exportSchema = false)
abstract class EventsLocalDatabase : RoomDatabase() {
  abstract fun eventsDao(): EventDao
  abstract fun circleDao(): CircleDao

  companion object {
    private var INSTANCE: EventsLocalDatabase? = null
    private val lock = Any()

    fun getInstance(context: Context): EventsLocalDatabase =
      INSTANCE ?: synchronized(lock) {
        INSTANCE ?: Room.databaseBuilder(
          context.applicationContext,
          EventsLocalDatabase::class.java, "Events.db"
        )
          .build()
          .also { INSTANCE = it }
      }

    fun destroyInstance() {
      INSTANCE = null
    }
  }
}