package com.rezkalla.mobileassignment.di

import com.rezkalla.mobileassignment.ui.CitiesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [RepositoryModule::class])
    internal abstract fun provideListFragment(): CitiesFragment

}