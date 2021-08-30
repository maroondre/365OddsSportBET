package app.odds365.sportbet.Connection

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetroServices {

    var weburl = "https://210512ac-0a65-435b-a7a6-fc86af66b7ff.mock.pstmn.io/android/api/"
    var mockurl = "http://mock-api.com/onwXMjKN.mock/android/api/"
    var leagueurl = "https://www.thesportsdb.com/api/v1/json/1/"

    fun retrofits(url: String): API? {

        val client = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(url).client(client)
            .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
            .build()
        return retrofit.create(API::class.java)
    }
}