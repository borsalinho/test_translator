package com.kaspersky.translator.di

import com.kaspersky.data.network.ApiSkyEnd
import com.kaspersky.data.repositoryimpl.WordQuerryRepositryImpl
import com.kaspersky.domain.repository.WordQuerryRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideWordQuerryRepositryImpl(apiSkyEng : ApiSkyEnd) : WordQuerryRepository {
        return WordQuerryRepositryImpl(apiSkyEng = apiSkyEng)
    }


    @Singleton
    @Provides
    fun provideRetrofit() : ApiSkyEnd {
        return Retrofit.Builder()
            .baseUrl("https://dictionary.skyeng.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiSkyEnd::class.java)
    }


}

