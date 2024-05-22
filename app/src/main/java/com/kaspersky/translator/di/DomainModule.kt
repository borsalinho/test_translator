package com.kaspersky.translator.di

import com.kaspersky.domain.repository.WordQuerryRepository
import com.kaspersky.domain.usecases.SendWordUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Singleton
    @Provides
    fun provideSendWordUseCase(wordQuerryRepository: WordQuerryRepository) : SendWordUseCase {
        return SendWordUseCase(wordQuerryRepository = wordQuerryRepository)
    }
}

