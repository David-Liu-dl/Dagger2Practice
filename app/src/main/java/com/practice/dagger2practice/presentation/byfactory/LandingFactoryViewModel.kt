package com.practice.dagger2practice.presentation.byfactory

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.practice.dagger2practice.domain.Repository
import com.practice.dagger2practice.presentation.byfactory.LandingFactoryFragment.Companion.RETAINED_INFO


class LandingFactoryViewModel(
    private val handle: SavedStateHandle,
    private val repository: Repository,
    private val hostName: String
) : ViewModel() {

    fun loadContent(): String = """
        ${repository.retrieve()} in $hostName
        ViewModel-ID: ${System.identityHashCode(this)}
    """.trimIndent()

    fun loadBundle(): String? = handle[RETAINED_INFO]

    fun saveBundle(data: String) {
        handle[RETAINED_INFO] = data
    }
}