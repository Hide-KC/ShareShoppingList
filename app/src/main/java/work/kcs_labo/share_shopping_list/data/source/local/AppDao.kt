package work.kcs_labo.share_shopping_list.data.source.local

import androidx.room.*
import work.kcs_labo.share_shopping_list.data.Circle
import work.kcs_labo.share_shopping_list.data.Fest

@Dao
interface AppDao {
  @Query("SELECT * FROM fests")
  fun findAllFests(): List<Fest>

  @Query("SELECT * FROM fests WHERE festName LIKE :festName")
  fun findFests(festName: String): List<Fest>

  @Query("SELECT * FROM fests WHERE id = :id")
  fun findFests(id: Long): Fest

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertFest(fest: Fest)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  @JvmSuppressWildcards
  fun insertFests(fests: List<Fest>)

  @Update
  fun updateFest(fest: Fest): Int

  @Query("DELETE FROM fests")
  fun deleteAllFests(): Int

  @Delete
  fun deleteFest(fest: Fest): Int

//  @Transaction
//  fun deleteAndInsertList(newFests: List<Fest>, oldFests: List<Fest>)

  @Query("SELECT * FROM circles")
  fun findAllCircles(): List<Circle>

  @Query("SELECT * FROM circles WHERE circleName LIKE :circleName")
  fun findCircles(circleName: String): List<Circle>

  @Query("SELECT * FROM circles WHERE id = :id")
  fun findCircle(id: Long): Circle

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertCircle(circle: Circle)

  @Update
  fun updateCircle(circle: Circle)

  @Query("DELETE FROM circles")
  fun deleteAllCircles()

  @Delete
  fun deleteCircle(circle: Circle): Int
}