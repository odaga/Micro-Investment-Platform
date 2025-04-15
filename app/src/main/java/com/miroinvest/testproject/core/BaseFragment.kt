package com.miroinvest.testproject.core

import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.miroinvest.testproject.R
import com.miroinvest.testproject.core.utils.ProgressUtils

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    private lateinit var progressUtils: ProgressUtils
    private lateinit var locationManager: LocationManager
    private lateinit var locationListener: LocationListener
//    val gsonParser = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressUtils = ProgressUtils(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return _binding?.root
    }

    fun getParentActivity(): FragmentActivity {
        return requireActivity()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //navigate to another fragment
    protected fun navigate(direction: NavDirections) = findNavController().navigate(direction)


    // navigate to another fragment with bundle(payload)
    protected fun navigateWithBundle(direction: Int, bundle: Bundle?) =
        findNavController().navigate(direction, bundle)

    protected fun clearNavigationBackStack(destination: Int, bundle: Bundle?) =
        findNavController().navigate(
            destination,
            bundle,
            NavOptions.Builder().setPopUpTo(
                destination,
                true
            ).build()
        )

    protected fun navigateUp() = findNavController().navigateUp()

    fun showProgressDialog() {
        progressUtils.showDialog()
    }

    fun hideProgressDialog() {
        progressUtils.hideDialog()
    }


    /* show error alert dialog */
    fun showErrorDialog(errorMessage: String) {
        val builder = AlertDialog.Builder(requireContext(), R.style.CustomAlertDialog)
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

}