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

class TeamVM() : ViewModel() {

    var tmMD: MutableLiveData<List<Teams>> = MutableLiveData()
    val exe = CoroutineExceptionHandler { _, _ ->
        tmMD.postValue(null)
    }

    fun teamVMCall(league : String): MutableLiveData<List<Teams>>
    {
        viewModelScope.launch(exe + Dispatchers.IO){
            val retroValue = RetroServices.retrofits(RetroServices.leagueurl)!!.getTeam(league)

            tmMD.postValue(retroValue.data)

        }
        return tmMD
    }

}