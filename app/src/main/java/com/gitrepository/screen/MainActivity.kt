package com.gitrepository.screen

import android.os.Bundle
import com.gitrepository.R
import com.gitrepository.system.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}