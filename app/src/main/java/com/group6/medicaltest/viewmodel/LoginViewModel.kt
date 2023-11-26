package com.group6.medicaltest.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.group6.medicaltest.entity.Nurse
import com.group6.medicaltest.repository.NurseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.properties.Delegates

class LoginViewModel(app: Application) : AndroidViewModel(app) {

    private val nurseRepository = NurseRepository(app)

    // MutableLiveData to hold the result of the login operation
    private val _loginResult = MutableLiveData<Boolean>()

    // Expose an immutable LiveData for the view to observe
    val loginResult: LiveData<Boolean>
        get() = _loginResult

    fun login(nurseId: Int, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {

                // Perform the login operation
                val nurse = nurseRepository.getNurseByIdAndPassword(Nurse(nurseId, "", "", "", password))
                Log.d("ABCCCCCC", nurse.toString())

                if(nurse != null) {
                }
                // Check if the login was successful (example condition, modify as needed)
//                val loginSuccessful = true//nurse?.isNotEmpty() == true
                val loginSuccessful = nurse != null


                // Update the MutableLiveData with the result
                withContext(Dispatchers.Main) {
                    _loginResult.value = loginSuccessful
                }

            } catch (e: Exception) {

                // Handle exceptions if needed
                // For example, you might want to log the error or show an error message
                withContext(Dispatchers.Main) {
                    _loginResult.value = false
                }
            }
        }
    }
}