package com.mv.coreapp.di

import com.mv.coreapp.data.repository.StudentRepository
import com.mv.coreapp.data.repository.impl.StudentRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindStudentRepository(impl: StudentRepositoryImpl): StudentRepository
}
