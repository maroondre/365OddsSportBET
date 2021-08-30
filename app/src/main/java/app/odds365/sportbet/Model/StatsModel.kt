package app.odds365.sportbet.Model

import com.google.gson.annotations.SerializedName

data class StatsModel(
    @SerializedName("table")
    val data: List<Table>
)

data class Table(
    @SerializedName("idStanding")
    val idStanding: Int,
    @SerializedName("strTeam")
    val strTeam: String?,
    @SerializedName("strTeamBadge")
    val strTeamBadge: String?,
    @SerializedName("intPlayed")
    val intPlayed: Int,
    @SerializedName("intWin")
    val intWin: Int,
    @SerializedName("intLoss")
    val intLoss: Int,
    @SerializedName("intDraw")
    val intDraw: Int,
    @SerializedName("intPoints")
    val intPoints: Int
)
