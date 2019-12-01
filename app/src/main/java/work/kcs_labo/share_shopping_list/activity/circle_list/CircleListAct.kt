package work.kcs_labo.share_shopping_list.activity.circle_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.activity.main.MainActViewModel
import work.kcs_labo.share_shopping_list.databinding.CircleListActBinding
import work.kcs_labo.share_shopping_list.util.obtainViewModel

class CircleListAct : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.circle_list_act)

    val eventId = this.intent.getIntExtra("eventId", -1)
    if (eventId >= 0) {
      val viewModel = obtainViewModel()
      viewModel.getCircles(eventId)
    }
  }

  fun obtainViewModel() = obtainViewModel(CircleListActViewModel::class.java)
}
