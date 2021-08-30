package app.odds365.sportbet.Model

import com.google.gson.annotations.SerializedName

data class LeagueModel(
    @SerializedName("leagues")
    val data: List<Leagues>
)

data class Leagues(
    @SerializedName("idLeague")
    val id: Int,
    @SerializedName("strLeague")
    val strLeague: String?,
    @SerializedName("strSport")
    val strSport: String?,
    @SerializedName("strLeagueAlternate")
    val strLeagueAlternate: String?
)
