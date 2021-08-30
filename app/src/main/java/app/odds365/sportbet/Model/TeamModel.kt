package app.odds365.sportbet.Model

import com.google.gson.annotations.SerializedName

data class TeamModel(
    @SerializedName("teams")
    val data: List<Teams>
)

data class Teams(
    @SerializedName("idTeam")
    val idTeam: Int,
    @SerializedName("strLeague")
    val strLeague: String?,
    @SerializedName("idLeague")
    val idLeague: String?,
    @SerializedName("strTeam")
    val strTeam: String?,
    @SerializedName("strStadiumThumb")
    val strStadiumThumb: String?,
    @SerializedName("strStadiumDescription")
    val strStadiumDescription: String?,
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String?,
    @SerializedName("strTeamBanner")
    val strTeamBanner: String?,
    @SerializedName("strTeamLogo")
    val strTeamLogo: String?
)
