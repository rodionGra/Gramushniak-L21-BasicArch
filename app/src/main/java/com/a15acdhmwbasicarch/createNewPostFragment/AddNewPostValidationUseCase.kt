package com.a15acdhmwbasicarch.createNewPostFragment

import com.a15acdhmwbasicarch.datasource.PostsCacheDataSource

const val TITLE_MIN_LENGTH = 2
const val TITLE_MAX_LENGTH = 51
const val BODY_MIN_LENGTH = 4
const val BODY_MAX_LENGTH = 501
const val BENNED_WORD_LIST = listOf<String>("")

class AddNewPostValidationUseCase(
    private val postsCacheDataSource: PostsCacheDataSource
) {
    fun execute(title: String, body: String): List<NewPostErrorType> {
        val listOfError: MutableList<NewPostErrorType> = mutableListOf()

        if (title.length !in TITLE_MAX_LENGTH downTo TITLE_MIN_LENGTH) {
            listOfError.add(NewPostErrorType.TITLE_LENGTH_ERROR)
        }

        if (body.length !in BODY_MAX_LENGTH downTo BODY_MIN_LENGTH) {
            listOfError.add(NewPostErrorType.BODY_LENGTH_ERROR)
        }

        //TODO!!! BANNED WORD FROM RESOURCES
        if (title.contains("buy", true) || title.contains("buy", true) || title.contains("buy", true)) {
            listOfError.add(NewPostErrorType.FORBIDDEN_WORDS_ERROR)
        }

        return listOfError
    }

}

enum class NewPostErrorType {
    BODY_LENGTH_ERROR,
    TITLE_LENGTH_ERROR,
    FORBIDDEN_WORDS_ERROR
}