package app.odds365.sportbet.Connection

import app.odds365.sportbet.Model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET("v1")
    suspend fun getWebsite(): List<WebModel>

    @GET("lookuptable.php?")
    suspend fun getStats(@Query("l") league : Int , @Query("s") season : String): StatsModel

    @GET("all_leagues.php")
    suspend fun getLeagues(): LeagueModel

    @GET("lookupleague.php?")
    suspend fun getFacts(@Query("id") id : Int): FactsModel

    @GET("search_all_teams.php?")
    suspend fun getTeam(@Query("l") league : String): TeamModel

}