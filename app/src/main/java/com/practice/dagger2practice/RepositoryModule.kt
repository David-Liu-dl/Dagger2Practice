package com.practice.dagger2practice

import com.practice.dagger2practice.domain.Repository
import com.practice.dagger2practice.domain.RepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindsRepository(repositoryImpl: RepositoryImpl): Repository
}