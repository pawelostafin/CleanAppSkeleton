package com.example.framework.database.di

import android.content.Context
import androidx.room.Room
import com.example.framework.datasource.RoomNoteDataSource
import com.example.common.di.scope.ApplicationScope
import com.example.framework.database.AppDatabase
import com.example.framework.database.dao.NoteEntityDAO
import com.example.data.LocalNoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DatabaseModule {

    @Binds
    abstract fun bindRoomDataSource(roomNoteDataSource: RoomNoteDataSource): LocalNoteDataSource

    @Module
    companion object {

        @JvmStatic
        @ApplicationScope
        @Provides
        fun provideDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "CleanAppSkeletonDatabase").build()
        }

        @JvmStatic
        @ApplicationScope
        @Provides
        fun provideNoteDao(database: AppDatabase): NoteEntityDAO {
            return database.noteEntityDAO()
        }
    }
}