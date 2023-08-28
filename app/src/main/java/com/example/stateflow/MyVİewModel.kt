package com.example.stateflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class MyViewModel:ViewModel() {

    val stateFlow:MutableStateFlow<String> = MutableStateFlow("")
    suspend fun updateState(){
        for (i in 1..5){
            stateFlow.value = i.toString()
            editValues()
            delay(1000)
        }
    }
    fun onButtonClicked(){
        viewModelScope.launch {
            updateState()
        }

    }

    fun editValues(){
        viewModelScope.launch{
            stateFlow.update {it->
                if (it=="3"){
                    "batu"
                }else{
                    it
                }
            }


        }
    }
}