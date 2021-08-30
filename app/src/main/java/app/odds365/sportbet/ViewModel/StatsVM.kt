package app.odds365.sportbet.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.odds365.sportbet.Model.*
import app.odds365.sportbet.Connection.RetroServices
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StatsVM() : ViewModel() {

    var statsMD: MutableLiveData<List<Table>> = MutableLiveData()
    val exe = CoroutineExceptionHandler { _, _ ->
        statsMD.postValue(null)
    }

    fun stsVMCall(id: Int, season : String): MutableLiveData<List<Table>>
    {
        viewModelScope.launch(exe + Dispatchers.IO){
            val retroValue = RetroServices.retrofits(RetroServices.leagueurl)!!.getStats(id, season)

            statsMD.postValue(retroValue.data)

        }
        return statsMD
    }
}