package com.mv.coreapp.di

import com.mv.coreapp.data.remotedatasource.RemoteStudentDataSource
import com.mv.coreapp.data.remotedatasource.firebaseimpl.FirebaseRemoteStudentDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Singleton
    @Binds
    fun bindStudentDataSource(impl: FirebaseRemoteStudentDataSource): RemoteStudentDataSource
}
