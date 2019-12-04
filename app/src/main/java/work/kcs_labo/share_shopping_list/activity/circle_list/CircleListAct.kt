package work.kcs_labo.share_shopping_list.activity.circle_list

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.activity.circle_list.fragment.CircleListFragment
import work.kcs_labo.share_shopping_list.util.obtainViewModel

class CircleListAct : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.circle_list_act)

    val eventId = this.intent.getIntExtra("eventId", -1)
    if (eventId >= 0) {
      val viewModel = obtainViewModel()
      val circleList = viewModel.getCircles(eventId)
      val toast = Toast.makeText(this, circleList.size, Toast.LENGTH_SHORT)
      toast.show()
    }

    setupWidget()
  }

  private fun setupWidget() {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.circleListFrame, CircleListFragment.getInstance(null))
    transaction.commit()
  }

  fun obtainViewModel() = obtainViewModel(CircleListActViewModel::class.java)
}
