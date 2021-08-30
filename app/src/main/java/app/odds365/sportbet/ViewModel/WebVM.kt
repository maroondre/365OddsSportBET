package app.odds365.sportbet.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.odds365.sportbet.Model.WebModel
import app.odds365.sportbet.Connection.RetroServices
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.ArrayList

class WebVM() : ViewModel() {
    var list = ArrayList<WebModel>()
    var web : String = ""
    var webMD: MutableLiveData<List<WebModel>> = MutableLiveData()

    val exe = CoroutineExceptionHandler { _, _ ->
        webMD.postValue(null)
    }

    fun webVMCall(): MutableLiveData<List<WebModel>>
    {
        viewModelScope.launch(exe + Dispatchers.IO){
            list.clear()
            val retroValue = RetroServices.retrofits(RetroServices.weburl)!!.getWebsite()

            for(datas in retroValue)
                if(datas.switch == "true") {
                    web = datas.weburl.toString()
                    list.add(datas)
                    webMD.postValue(list)
                }
                else{
                    webMD.postValue(null)
                }
            }
        return webMD
    }

}