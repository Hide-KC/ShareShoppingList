package work.kcs_labo.share_shopping_list.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class Event(
  @PrimaryKey(autoGenerate = true)
  val id: Long,
  val eventName: String,
  val iconUri: String,
  val eventStartDate: String,
  val eventEndDate: String,
  val place: String
)

@Entity(tableName = "circles")
data class Circle(
  @PrimaryKey(autoGenerate = true)
  val id: Long,
  val circleName: String,
  val iconUri: String,
  val masterName: String,
  val bookmark: Boolean
)