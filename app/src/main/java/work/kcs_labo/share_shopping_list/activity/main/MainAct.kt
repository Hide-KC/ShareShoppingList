package work.kcs_labo.share_shopping_list.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.databinding.MainActBinding

class MainAct : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = DataBindingUtil
      .setContentView<MainActBinding>(this, R.layout.main_act)
      .also {
        it.viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
      }

  }
}
