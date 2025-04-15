package com.miroinvest.testproject.core.utils

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.toDrawable
import com.miroinvest.testproject.databinding.ProgressbarLayoutBinding

class ProgressUtils(private val context: Context) {
    private var dialog: AlertDialog

    init {
        val builder = AlertDialog.Builder(context)
        builder.setView(ProgressbarLayoutBinding.inflate(LayoutInflater.from(context)).root)
        builder.setCancelable(false)
        dialog = builder.create()
        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
    }

    fun showDialog() {
        if (!dialog.isShowing) dialog.show()
    }

    fun hideDialog() {
        if (dialog.isShowing) dialog.dismiss()
    }

    fun destroyDialog() = dialog.cancel()
}