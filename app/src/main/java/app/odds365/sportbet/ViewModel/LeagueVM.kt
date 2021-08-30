package app.odds365.sportbet.ViewModel

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.odds365.sportbet.Connection.RetroServices
import app.odds365.sportbet.Connection.RetroServices.leagueurl
import app.odds365.sportbet.Model.Leagues
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Response
import retrofit2.Response.error
import java.lang.Exception
import java.util.ArrayList
import kotlin.coroutines.coroutineContext

class LeagueVM() : ViewModel() {

    var lgMD: MutableLiveData<List<Leagues>> = MutableLiveData()

    val exe = CoroutineExceptionHandler { _, _ ->
        lgMD.postValue(null)
    }

    fun leagueVMCall(): MutableLiveData<List<Leagues>>
    {
        viewModelScope.launch(exe + Dispatchers.IO){
            val retroValue = RetroServices.retrofits(leagueurl)!!.getLeagues()
            try{
                lgMD.postValue(retroValue.data.take(10))
            }catch (e : Exception) {
                lgMD.postValue(null)
            }
        }

        return lgMD
    }

}

