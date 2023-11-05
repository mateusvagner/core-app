package com.mv.coreapp.di

import com.mv.coreapp.data.remotedatasource.StudentRemoteDataSource
import com.mv.coreapp.data.remotedatasource.firebaseimpl.FirebaseStudentRemoteDataSource
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
    fun bindStudentDataSource(impl: FirebaseStudentRemoteDataSource): StudentRemoteDataSource
}
