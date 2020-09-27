package com.practice.dagger2practice.presentation.byviewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.practice.dagger2practice.domain.Repository
import com.practice.dagger2practice.presentation.byviewmodel.LandingVMFragment.Companion.RETAINED_INFO
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject


class LandingVMViewModel @AssistedInject constructor(
    @Assisted private val handle: SavedStateHandle,
    @Assisted private val hostName: String,
    private val repository: Repository
) : ViewModel() {

    @AssistedInject.Factory
    interface Factory {
        fun create(handle: SavedStateHandle, hostName: String): LandingVMViewModel
    }

    fun loadContent(): String = """
        ${repository.retrieve()} in $hostName
        ViewModel-ID: ${System.identityHashCode(this)}
    """.trimIndent()

    fun loadBundle(): String? = handle[RETAINED_INFO]

    fun saveBundle(data: String) {
        handle[RETAINED_INFO] = data
    }
}