package work.kcs_labo.share_shopping_list.activity.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.main_act.*
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.activity.main.fragment.EventListFragment
import work.kcs_labo.share_shopping_list.databinding.MainActBinding
import work.kcs_labo.share_shopping_list.util.obtainViewModel

class MainAct : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = DataBindingUtil
      .setContentView<MainActBinding>(this, R.layout.main_act)
      .also {
        it.viewModel = obtainViewModel()
        it.lifecycleOwner = this
      }

    setupWidget(binding)
    setupFragment(binding)

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

  private fun setupFragment(binding: MainActBinding) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.mainFrag, EventListFragment.getInstance(null))
    transaction.commit()
  }

  private fun setupWidget(binding: MainActBinding) {
    binding.toolbar.let {
      it.inflateMenu(R.menu.toolbar_menu)
      it.setNavigationIcon(R.drawable.ic_person)
      it.setTitle(R.string.app_name)
      it.setOnMenuItemClickListener { menuItem ->
        when (menuItem.itemId) {

        }
        return@setOnMenuItemClickListener true
      }
    }

    binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
      when (item.itemId) {
        R.id.list -> {
          Log.d("", item.itemId.toString())
          return@setOnNavigationItemSelectedListener true
        }
        R.id.calendar -> {
          Log.d("", item.itemId.toString())
          return@setOnNavigationItemSelectedListener true
        }
        R.id.friends -> {
          Log.d("", item.itemId.toString())
          return@setOnNavigationItemSelectedListener true
        }
        R.id.manage -> {
          Log.d("", item.itemId.toString())
          return@setOnNavigationItemSelectedListener true
        }
        else -> {
          throw IllegalArgumentException("Illegal itemId was selected")
        }
      }
    }
  }

  fun obtainViewModel(): MainActViewModel = obtainViewModel(MainActViewModel::class.java)
}
