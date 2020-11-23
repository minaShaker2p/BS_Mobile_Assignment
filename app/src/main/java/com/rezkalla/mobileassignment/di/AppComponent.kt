package com.rezkalla.mobileassignment.di

import android.app.Application
import com.rezkalla.BSMobileAssignmentApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        AppModule::class,
        LocalDataModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    fun inject(app: BSMobileAssignmentApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}