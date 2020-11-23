package com.rezkalla.mobileassignment.di


import com.rezkalla.mobileassignment.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity
}