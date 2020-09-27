package com.practice.dagger2practice.domain

import com.practice.dagger2practice.data.Service
import javax.inject.Inject

interface Repository {
    fun retrieve(): String
}

class RepositoryImpl @Inject constructor(private val service: Service) : Repository {
    override fun retrieve() = service.httpText()
}
