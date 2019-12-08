package work.kcs_labo.share_shopping_list.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fests")
data class Fest(
  @PrimaryKey(autoGenerate = true)
  val id: Long = 0,
  val festName: String = "",
  val iconUri: String = "",
  val startDate: String = "",
  val endDate: String = "",
  val place: String = ""
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