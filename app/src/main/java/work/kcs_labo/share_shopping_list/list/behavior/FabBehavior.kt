package work.kcs_labo.share_shopping_list.list.behavior

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FabBehavior(context: Context, attrs: AttributeSet) :
  FloatingActionButton.Behavior(context, attrs) {

  override fun onStartNestedScroll(
    coordinatorLayout: CoordinatorLayout,
    child: FloatingActionButton,
    directTargetChild: View,
    target: View,
    axes: Int,
    type: Int
  ): Boolean {
    return axes == ViewCompat.SCROLL_AXIS_VERTICAL
  }

  override fun onNestedScroll(
    coordinatorLayout: CoordinatorLayout,
    child: FloatingActionButton,
    target: View,
    dxConsumed: Int,
    dyConsumed: Int,
    dxUnconsumed: Int,
    dyUnconsumed: Int,
    type: Int,
    consumed: IntArray
  ) {
    super.onNestedScroll(
      coordinatorLayout,
      child,
      target,
      dxConsumed,
      dyConsumed,
      dxUnconsumed,
      dyUnconsumed,
      type,
      consumed
    )
    if (dyConsumed > 0 && child.visibility == View.VISIBLE) {
      // User scrolled down and the FAB is currently visible -> hide the FAB
      child.hide(object : FloatingActionButton.OnVisibilityChangedListener() {
        override fun onHidden(fab: FloatingActionButton?) {
          super.onHidden(fab)
          fab?.visibility = View.INVISIBLE
        }
      })
    } else if (dyConsumed < 0 && child.visibility != View.VISIBLE) {
      // User scrolled up and the FAB is currently not visible -> show the FAB
      child.show()
    }
  }
}