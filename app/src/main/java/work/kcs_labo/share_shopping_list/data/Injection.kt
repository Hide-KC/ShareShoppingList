package work.kcs_labo.share_shopping_list.data

import android.content.Context
import work.kcs_labo.share_shopping_list.data.source.EventsRepository
import work.kcs_labo.share_shopping_list.data.source.local.EventsLocalDataSource
import work.kcs_labo.share_shopping_list.data.source.local.EventsLocalDatabase
import work.kcs_labo.share_shopping_list.data.source.remote.EventsRemoteDataSource

object Injection {
  fun provideTasksRepository(context: Context): EventsRepository {
    val localDatabase = EventsLocalDatabase.getInstance(context)
    val remoteDataSource = EventsRemoteDataSource.getInstance()
    return EventsRepository.getInstance(
      remoteDataSource,
      EventsLocalDataSource.getInstance(localDatabase.eventsDao())
    )
  }
}