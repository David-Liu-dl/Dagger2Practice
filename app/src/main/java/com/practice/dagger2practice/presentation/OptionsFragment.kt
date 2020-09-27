package com.practice.dagger2practice.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.practice.dagger2practice.R
import com.practice.dagger2practice.presentation.byfactory.LandingFactoryFragment
import com.practice.dagger2practice.presentation.byviewmodel.LandingVMFragment

class OptionsFragment : Fragment(R.layout.fragment_options) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_viewmodels).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, LandingVMFragment.instance("Dagger2Practice-by-viewModels"))
                .addToBackStack(null)
                .commit()
        }

        view.findViewById<Button>(R.id.btn_viewmodelfactory).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, LandingFactoryFragment.instance("Dagger2Practice-by-ViewModelFactory"))
                .addToBackStack(null)
                .commit()
        }
    }
}