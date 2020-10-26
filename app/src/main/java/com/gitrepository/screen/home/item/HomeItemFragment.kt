package com.gitrepository.screen.home.item

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import androidx.fragment.app.viewModels
import com.gitrepository.R
import com.gitrepository.cardList
import com.gitrepository.data.model.Item
import com.gitrepository.di.factory.ViewModelFactory
import com.gitrepository.saved
import com.gitrepository.system.BaseFragment
import com.gitrepository.system.errorDialog
import com.gitrepository.system.loadImageUrl
import com.gitrepository.system.observe
import com.idapgroup.argumentdelegate.argumentDelegate
import kotlinx.android.synthetic.main.fragment_home_item.*
import javax.inject.Inject

class HomeItemFragment : BaseFragment(R.layout.fragment_home_item) {

    @Inject
    lateinit var factory: ViewModelFactory

    val type: String by argumentDelegate()
    private val viewModel: HomeItemViewModel by viewModels { factory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.setData(type)

        searchText.doOnTextChanged { text, _, _, _ ->
            viewModel.findRepo(text)
            progressBar.isVisible = text != null

        }

        observe(viewModel.error) {
            errorDialog(requireContext(), it, {

            })
        }

        if (type == "Saved") {
            search.isVisible = false
        }
        observe(viewModel.currentData) {
            if (it.isNotEmpty()) {
                setDataToView(it)
                progressBar.isVisible = it.isEmpty()
            }
        }

        observe(viewModel.t) {
            progressBar.isVisible = it.isEmpty()
            savedList(it)
        }
    }

    private fun savedList(list: List<Item>) {
        epoxyView.withModels {
            list.mapIndexed { index, item ->
                saved {
                    id(index)
                    viewModel(viewModel)
                    repoItem(item)
                }
            }
        }
    }


    private fun setDataToView(list: List<WithSavedData>) {
        epoxyView.withModels {
            list.mapIndexed { index, item ->
                cardList {
                    viewModel(viewModel)
                    id(index)
                    repoItem(item)
                }
            }

        }
    }

}

@BindingAdapter("app:loadImage")
fun bindDisplayName(image: ImageView, url: String?) {
    url?.let { image.loadImageUrl(it) }
}

@BindingAdapter("app:changeImage")
fun changeImage(image: ImageView, type: Boolean) {
    when (type) {
        true -> image.setImageResource(R.drawable.ic_baseline_favorite_24)
        false -> image.setImageResource(R.drawable.ic_baseline_favorite_border_24)
    }
}