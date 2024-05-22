package com.kaspersky.data.repositoryimpl

import com.kaspersky.data.mappers.toQuerry
import com.kaspersky.data.network.ApiSkyEnd

import com.kaspersky.domain.model.WordQuerry
import com.kaspersky.domain.model.WordsResponce
import com.kaspersky.domain.repository.WordQuerryRepository

class WordQuerryRepositryImpl(var apiSkyEng : ApiSkyEnd) : WordQuerryRepository {
    override suspend fun SaveWordQuerryToDataBase() {
        TODO("Not yet implemented")
    }

    override suspend fun SendWordQuerryToApiAndGetResponse(wordQuerry : WordQuerry) : WordsResponce {

        val result = apiSkyEng.getTranslate(wordQuerry.word_querry)
        var translations = ""

        if (result.isNotEmpty()) {
            translations = result.flatMap { it.meanings }
                .take(3)
                .map { it.translation.text }
                .joinToString(", ")
        } else {
            translations = "нет ответа"
        }

        return WordsResponce(translations)
    }
}