package work.kcs_labo.share_shopping_list.activity.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.databinding.AuthActBinding

class AuthAct : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = DataBindingUtil
      .setContentView<AuthActBinding>(this, R.layout.auth_act)
      .also {
        it.viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
      }

      
  }
}
