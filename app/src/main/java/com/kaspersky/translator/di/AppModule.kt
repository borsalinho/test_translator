package com.kaspersky.translator.di


import android.content.Context
import com.kaspersky.domain.usecases.SendWordUseCase
import com.kaspersky.translator.view_model.MyViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {
    @Singleton
    @Provides
    fun providerContext() : Context{
        return context
    }

    @Singleton
    @Provides
    fun provideMyViewModel(sendWordUseCase : SendWordUseCase): MyViewModel {
        return MyViewModel(sendWordUseCase = sendWordUseCase)
    }



}