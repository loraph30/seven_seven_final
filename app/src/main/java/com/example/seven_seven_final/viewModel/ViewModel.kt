package com.example.seven_seven_final.viewModel

import androidx.lifecycle.ViewModel
import com.example.seven_seven_final.model.DataModel

class ViewModel: ViewModel() {

    private var dataModel = DataModel(
        userName = "sample",
        userPassword = "sample",
        currentUserPassword = "",
        currentUserName = ""
    )

    fun postUserName(currentUserName: String) {
        dataModel.currentUserName = currentUserName
    }

    fun postUserPassword(currentUserPassword: String)  {
        dataModel.currentUserPassword = currentUserPassword
    }

    fun getUserName(): String {
        return dataModel.userName
    }

    fun getPassword(): String {
        return dataModel.userPassword
    }

    fun getCurrentUserName(): String {
        return dataModel.currentUserName
    }

    fun getCurrentPassword(): String {
        return dataModel.currentUserPassword
    }
}