package app.odds365.sportbet.Model

import com.google.gson.annotations.SerializedName

data class WebModel(

    @SerializedName("switch")
    var switch: String?,

    @SerializedName("platform")
    var platform: String?,

    @SerializedName("weburl")
    var weburl: String?,

    @SerializedName("version")
    var version: String?
)
