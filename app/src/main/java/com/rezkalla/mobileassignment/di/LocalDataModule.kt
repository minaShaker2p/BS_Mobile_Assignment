package com.rezkalla.mobileassignment.di

import android.app.Application
import com.rezkalla.core.data.source.CitiesLocalDataSource
import com.rezkalla.mobileassignment.datasource.CitiesLocalDataSourceImpl

import dagger.Module
import dagger.Provides

@Module
class LocalDataModule {

    @Provides
    fun provideCitiesLocalDataSource(application: Application): CitiesLocalDataSource {
        return CitiesLocalDataSourceImpl(application)
    }
}