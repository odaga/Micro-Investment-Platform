package com.miroinvest.testproject.core

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import com.miroinvest.testproject.R
import com.miroinvest.testproject.core.utils.ProgressUtils


open class BaseActivity : AppCompatActivity() {
    private lateinit var progressUtils: ProgressUtils
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        progressUtils = ProgressUtils(this)
    }

    override fun onStart() {
        super.onStart()
        progressUtils = ProgressUtils(this)
        setAppTheme()
    }

    fun showProgressDialog() {
        progressUtils.showDialog()
    }

    fun hideProgressDialog() {
        progressUtils.hideDialog()
    }


    /* show error alert dialog */
    fun showErrorDialog(errorMessage: String) {
        val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)
            .create()
        val view = layoutInflater.inflate(R.layout.error_alert_dialog, null)
        val button = view.findViewById<Button>(R.id.dialogDismiss_button)
        val message = view.findViewById<TextView>(R.id.dialogErrorMessage)
        val buttonClose = view.findViewById<ImageView>(R.id.dialog_close)

        buttonClose.setOnClickListener {
            builder.dismiss()
        }

        message.text = errorMessage
        builder.setView(view)
        button.setOnClickListener {
            builder.dismiss()
        }
        builder.setCanceledOnTouchOutside(false)
        builder.show()
    }

    private fun setAppTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}