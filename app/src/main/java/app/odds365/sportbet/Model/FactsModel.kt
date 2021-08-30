package app.odds365.sportbet.Model

import com.google.gson.annotations.SerializedName

data class FactsModel(
    @SerializedName("leagues")
    val data: List<Leaguez>
)

data class Leaguez(
    @SerializedName("idLeague")
    val id: Int,
    @SerializedName("strLeague")
    val strLeague: String?,
    @SerializedName("strCurrentSeason")
    val strCurrentSeason: String?,
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String?,
    @SerializedName("strBanner")
    val strBanner: String?,
    @SerializedName("strLogo")
    val strLogo: String?
)
