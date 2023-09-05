package krypton.maulidsimtudduror.sabilutaubah.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import krypton.maulidsimtudduror.sabilutaubah.main.MainActivity

const val TAG = "Utils"

fun openUrl(context: Context, url: String) {
    try {
        context.startActivity(
            Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse(url))
        )
    } catch (e: Throwable) {
        e.message?.let { Log.d(TAG, it) }
    }
}

fun openActivity(context: Context, activity: Class<*>) {
    val i = Intent(context, activity)
    context.startActivity(i)
}