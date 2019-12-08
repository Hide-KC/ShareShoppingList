package work.kcs_labo.share_shopping_list.data

interface RemoteDataSourceCallback<E> {
  fun onResult(contents: List<E>)
}