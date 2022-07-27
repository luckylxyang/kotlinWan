package com.lxy.kotlinwan.springTravel.risk

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RiskCityViewModel(val repo: RiskRepo) : ViewModel(){

    fun getRiskCity(){

        viewModelScope.launch{
            withContext(Dispatchers.IO){
                repo.getRiskRegion()
            }
        }

    }
}