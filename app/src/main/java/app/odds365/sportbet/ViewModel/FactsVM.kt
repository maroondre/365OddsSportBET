package app.odds365.sportbet.ViewModel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.odds365.sportbet.Connection.RetroServices
import app.odds365.sportbet.Connection.RetroServices.leagueurl
import app.odds365.sportbet.Model.Leaguez
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FactsVM() : ViewModel() {

    var factsMD: MutableLiveData<List<Leaguez>> = MutableLiveData()
    val exe = CoroutineExceptionHandler { _, _ ->
        factsMD.postValue(null)
    }

    fun factsVMCall(id: Int): MutableLiveData<List<Leaguez>>
    {
        viewModelScope.launch(exe + Dispatchers.Main){
            val retroValue = RetroServices.retrofits(leagueurl)!!.getFacts(id)
            factsMD.postValue(retroValue.data)

        }
        return factsMD
    }

}