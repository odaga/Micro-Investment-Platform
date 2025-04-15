package com.miroinvest.testproject.ui.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.miroinvest.testproject.core.BaseFragment
import com.miroinvest.testproject.databinding.FragmentProfileBinding
import com.miroinvest.testproject.ui.auth.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnSignOut.setOnClickListener {

                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Warning")
                builder.setMessage("Are sure you want sign out?")
                builder.setPositiveButton("Yes") { _, _ ->

                    CoroutineScope(Dispatchers.Main).launch {
                        Firebase.auth.signOut()
                        startActivity(Intent(getParentActivity(), LoginActivity::class.java))
                        getParentActivity().finish()

                    }
                }

                builder.setNegativeButton("No") { _, _ ->
                    builder.create().dismiss()
                }

                builder.show()
            }
        }
    }
}