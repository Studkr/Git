package com.gitrepository.screen.home


import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gitrepository.R
import com.gitrepository.di.factory.ViewModelFactory
import com.gitrepository.screen.home.item.HomeItemFragment
import com.gitrepository.system.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*
import timber.log.Timber
import javax.inject.Inject

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    @Inject
    lateinit var factory:ViewModelFactory
    private val viewModel: HomeViewModel by viewModels { factory }

    val title = listOf("Repositories", "Saved")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        viewPager.adapter = object :FragmentStateAdapter(this){
            override fun getItemCount(): Int  = title.size
            override fun createFragment(position: Int): Fragment  = HomeItemFragment().apply {
                    this.arguments = bundleOf("type" to title[position])
            }
        }

        TabLayoutMediator(tabsName,viewPager){ tab,position ->
            tab.text = title[position]
            viewPager.setCurrentItem(tab.position,true)
        }.attach()

        viewPager.setCurrentItem(0,true)
    }

}