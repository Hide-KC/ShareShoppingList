package work.kcs_labo.share_shopping_list.data.source.local

import androidx.room.*
import work.kcs_labo.share_shopping_list.data.Circle
import work.kcs_labo.share_shopping_list.data.Event

@Dao
interface EventDao {
  @Query("SELECT * FROM events")
  fun findAll(): List<Event>

  @Query("SELECT * FROM events WHERE eventName LIKE :eventName")
  fun find(eventName: String): List<Event>

  @Query("SELECT * FROM events WHERE id = :id")
  fun find(id: Long): Event

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(event: Event)

  @Update
  fun update(event: Event): Int

  @Query("DELETE FROM events")
  fun deleteAll(): Int

  @Delete
  fun delete(event: Event): Int
}

@Dao
interface CircleDao {
  @Query("SELECT * FROM circles")
  fun findAll(): List<Circle>

  @Query("SELECT * FROM circles WHERE circleName LIKE :circleName")
  fun find(circleName: String): List<Circle>

  @Query("SELECT * FROM circles WHERE id = :id")
  fun find(id: Long): Circle

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(circle: Circle)

  @Update
  fun update(circle: Circle): Int

  @Query("DELETE FROM circles")
  fun deleteAll(): Int

  @Delete
  fun delete(circle: Circle): Int
}