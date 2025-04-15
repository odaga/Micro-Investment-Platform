package com.miroinvest.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.miroinvest.data.impl.SeedingRepository
import com.miroinvest.data.room.AppDatabase
import com.miroinvest.data.util.LocalConstants
import com.miroinvest.data.util.LocalConstants.APP_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideLocalDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        APP_DATABASE_NAME
    ).fallbackToDestructiveMigration(false)
        .allowMainThreadQueries()
        .build()

    @Provides
    fun providesPlanDao(database: AppDatabase) = database.PlanDao()

    @Provides
    fun providesFuelSaveDao(database: AppDatabase) = database.transactionDao()
}