package work.kcs_labo.share_shopping_list.util

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
  ViewModelProviders.of(this, ViewModelFactory.getInstance(application)).get(viewModelClass)