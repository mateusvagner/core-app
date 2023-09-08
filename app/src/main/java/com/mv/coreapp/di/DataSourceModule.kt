package com.mv.coreapp.di

import com.mv.coreapp.data.datasource.StudentDataSource
import com.mv.coreapp.data.datasource.remote.StudentRemoteDataSource
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
    fun bindStudentRemoteDataSource(impl: StudentRemoteDataSource): StudentDataSource
}
