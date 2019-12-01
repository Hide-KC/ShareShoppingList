package work.kcs_labo.share_shopping_list.activity.circle_list.fragment;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import work.kcs_labo.share_shopping_list.R
import work.kcs_labo.share_shopping_list.activity.circle_list.CircleListAct
import work.kcs_labo.share_shopping_list.databinding.CircleListFragBinding

/**
 * Created by hide1 on 2019/12/01.
 * ProjectName ShareShoppingList
 */

class CircleListFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val binding = DataBindingUtil
      .inflate<CircleListFragBinding>(inflater, R.layout.circle_list_frag, null, false)
      .also {
        it.viewmodel = (activity as CircleListAct).obtainViewModel()
        it.lifecycleOwner = this
      }


    return binding.root
  }

  companion object {
    fun getInstance(bundle: Bundle?): CircleListFragment {
      val fragment = CircleListFragment()
      if (bundle != null) {
        fragment.arguments = bundle
      }
      return fragment
    }
  }
}