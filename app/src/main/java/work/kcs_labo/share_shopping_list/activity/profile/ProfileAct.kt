package work.kcs_labo.share_shopping_list.activity.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.databinding.ProfileActBinding

class ProfileAct : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = DataBindingUtil
      .setContentView<ProfileActBinding>(this, R.layout.profile_act)
      .also {
        it.viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
      }

  }
}
