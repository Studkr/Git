package com.flipsidegroup.nmt.system

import android.view.View

fun View.wasMeasured() = width != 0 || height != 0
