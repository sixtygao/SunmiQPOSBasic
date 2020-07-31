package com.gll.testmvvm.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.gll.testmvvm.bean.User

/**
 * User: highsixty
 * Date: 2020-04-13 10:59
 * email: gaolulin@sunmi.com
 */
class UserProfileViewModel(
        savedStateHandle: SavedStateHandle
) : ViewModel() {
    val userId : String = savedStateHandle["uid"] ?:
    throw IllegalArgumentException("missing user id")
    val user : User = TODO()
}
