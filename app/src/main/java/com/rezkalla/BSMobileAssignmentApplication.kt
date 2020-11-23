package com.rezkalla

import android.app.Application
import com.rezkalla.mobileassignment.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class BSMobileAssignmentApplication :Application() ,HasAndroidInjector  {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>


    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }


    private fun initDagger() {
        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this)
    }
}