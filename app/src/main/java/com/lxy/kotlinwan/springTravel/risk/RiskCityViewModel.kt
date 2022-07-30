package com.lxy.kotlinwan.springTravel.risk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lxy.kotlinwan.springTravel.risk.model.RiskRegion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RiskCityViewModel(val repo: RiskRepo) : ViewModel(){

    private val cities : MutableLiveData<RiskRegion> by lazy {
        MutableLiveData<RiskRegion>().also { getRiskCity() }
    }

    fun getCities() : LiveData<RiskRegion> = cities

    private fun getRiskCity(){
        viewModelScope.launch{
            val result = withContext(Dispatchers.IO){
                repo.getRiskRegion()
            }
            cities.postValue(result.result)
        }
    }
}