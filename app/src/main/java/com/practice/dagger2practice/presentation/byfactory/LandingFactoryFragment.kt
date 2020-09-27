package com.practice.dagger2practice.presentation.byfactory

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.practice.dagger2practice.MyApplication
import com.practice.dagger2practice.R
import com.practice.dagger2practice.domain.Repository
import javax.inject.Inject

class LandingFactoryFragment : Fragment(R.layout.fragment_landing) {
    companion object {
        const val PASSED_IN_INFO = "passed_in_info"
        const val RETAINED_INFO = "retained_info"

        fun instance(tracking: String) = LandingFactoryFragment().apply {
            arguments = Bundle().apply {
                putString(PASSED_IN_INFO, tracking)
            }
        }
    }

    @Inject
    lateinit var repository: Repository

    private lateinit var viewModel: LandingFactoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MyApplication.component.inject(this)

        viewModel = ViewModelProvider(
            this,
            LandingViewModelFactory(repository, arguments?.getString(PASSED_IN_INFO) ?: "null")
        )[LandingFactoryViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.text_view_info).text = information()
        view.findViewById<TextView>(R.id.text_view_bundle).text = bundle()
        view.findViewById<EditText>(R.id.edit_text_bundle)
            .setOnEditorActionListener { v, actionId, event ->
                if (event?.keyCode == KeyEvent.KEYCODE_ENTER || actionId == EditorInfo.IME_ACTION_DONE) {
                    viewModel.saveBundle(v.text.toString())
                }

                false
            }
    }

    private fun information() =
        "${viewModel.loadContent()} \n Fragment-ID: ${System.identityHashCode(this)}"

    private fun bundle() = "Bundle: ${viewModel.loadBundle() ?: "null"}"
}
