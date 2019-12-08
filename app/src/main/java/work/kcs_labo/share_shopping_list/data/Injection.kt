package work.kcs_labo.share_shopping_list.data

import android.content.Context
import work.kcs_labo.share_shopping_list.data.source.AppRepository
import work.kcs_labo.share_shopping_list.data.source.local.AppLocalDataSource
import work.kcs_labo.share_shopping_list.data.source.local.AppLocalDatabase
import work.kcs_labo.share_shopping_list.data.source.remote.FirebaseRemoteDataSource

object Injection {
  fun provideTasksRepository(context: Context): AppRepository {
    val localDatabase = AppLocalDatabase.getInstance(context)
    val remoteDataSource = FirebaseRemoteDataSource.getInstance()
    return AppRepository.getInstance(
      remoteDataSource,
      AppLocalDataSource.getInstance(localDatabase.appDao())
    )
  }
}