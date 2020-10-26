package com.gitrepository.system

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.util.DisplayMetrics
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.gitrepository.R
import kotlin.math.roundToInt


fun Int.toDp(displayMetrics: DisplayMetrics): Float = this.toFloat() / displayMetrics.density
fun Int.toSp(displayMetrics: DisplayMetrics): Float = this.toFloat() / displayMetrics.scaledDensity
fun Number.spToPx(displayMetrics: DisplayMetrics): Int =
    (this.toFloat() * displayMetrics.scaledDensity).roundToInt()

fun Number.dpToPx(displayMetrics: DisplayMetrics): Int =
    (this.toFloat() * displayMetrics.density).roundToInt()

fun getVersion(requireActivity: Context): String? {
    return requireActivity.packageManager.getPackageInfo(
        requireActivity.packageName,
        PackageManager.GET_ACTIVITIES
    ).versionName
}

@SuppressLint("DefaultLocale")
fun String.capitalizeWords(): String =
    "(\\w+)".toRegex().replace(this) { matchResult ->
        matchResult.value.toLowerCase().split(" ").joinToString(" ") { it.capitalize() }
    }


val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

fun errorDialog(context: Context, errorMessage: String, onOkClicked: () -> Unit) {
    AlertDialog.Builder(context)
        .setTitle(context.getString(R.string.error))
        .setMessage(errorMessage)
        .setPositiveButton(context.getString(R.string.ok)) { _, _ ->
            onOkClicked()
        }
        .show()
}


fun sharedIntent(link: String): Intent {
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, link)
        type = "text/plain"
    }
    return Intent.createChooser(sendIntent, null)
}


fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun ImageView.loadImageUrl(url:String){
    Glide.with(this).load(url).into(this)
}