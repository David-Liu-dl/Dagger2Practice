package com.practice.dagger2practice

import android.app.Application
import com.practice.dagger2practice.presentation.byfactory.LandingFactoryFragment
import com.practice.dagger2practice.presentation.byviewmodel.LandingVMViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceModule::class, RepositoryModule::class, ViewModelModule::class])
interface AppComponent {
    val landingVMViewModelFactory: LandingVMViewModel.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(fragment: LandingFactoryFragment)
    fun inject(fragment: LandingVMViewModel)
}