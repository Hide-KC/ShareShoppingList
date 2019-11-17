package work.kcs_labo.share_shopping_list.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
  @PrimaryKey(autoGenerate = true)
  val id: Long,
  val date: String,
  val name: String,
  val isCompleted: String
)