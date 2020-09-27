package com.practice.dagger2practice

import com.practice.dagger2practice.data.Service
import com.practice.dagger2practice.data.ServiceFancyImpl
import com.practice.dagger2practice.data.ServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ServiceModule {
    @Provides
    fun provideDefaultService(): Service {
        return ServiceImpl()
    }

    @Provides
    @Named("ServiceFancyImpl")
    fun provideFancyService(): Service {
        return ServiceFancyImpl()
    }
}