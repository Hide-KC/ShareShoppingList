package work.kcs_labo.share_shopping_list.list

import work.kcs_labo.share_shopping_list.data.Task
import work.kcs_labo.share_shopping_list.util.MainNavigator

class TaskModel(val task: Task) {
  private var navigator: MainNavigator? = null

  fun checkBoxClick(task: Task) {
    TODO("not implemented")
  }

  fun taskClick(task: Task) {
    TODO("not implemented")
  }

  fun deleteClick(task: Task) {
    TODO("not implemented")
  }

  fun setNavigator(navigator: MainNavigator?) {
    this.navigator = navigator
  }
}