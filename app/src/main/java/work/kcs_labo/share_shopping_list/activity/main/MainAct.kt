package work.kcs_labo.share_shopping_list.activity.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.main_act.*
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.databinding.MainActBinding
import work.kcs_labo.share_shopping_list.util.ViewModelFactory

class MainAct : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = DataBindingUtil
      .setContentView<MainActBinding>(this, R.layout.main_act)
      .also {
        it.viewModel = ViewModelProviders.of(this, ViewModelFactory.getInstance(application))
          .get(MainActViewModel::class.java)
      }

    if (savedInstanceState == null) {
      MobileAds.initialize(this, getString(R.string.ads_app_id))
    }

    adView.loadAd(AdRequest.Builder().build())
  }

  override fun onPause() {
    super.onPause()
    adView?.pause()
  }

  override fun onResume() {
    super.onResume()
    adView?.resume()
  }

  override fun onDestroy() {
    adView?.destroy()
    super.onDestroy()
  }
}
