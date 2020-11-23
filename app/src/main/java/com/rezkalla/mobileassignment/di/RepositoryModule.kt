package com.rezkalla.mobileassignment.di


import com.rezkalla.core.data.repository.CitiesRepositoryImpl
import com.rezkalla.core.data.source.CitiesLocalDataSource
import com.rezkalla.core.domain.repository.CitiesRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideCitiesRepository(localDataSource: CitiesLocalDataSource): CitiesRepository {
        return CitiesRepositoryImpl(localDataSource)
    }
}