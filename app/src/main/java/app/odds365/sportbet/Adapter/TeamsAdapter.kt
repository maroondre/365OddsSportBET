package app.odds365.sportbet.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import app.odds365.sportbet.Model.Leagues
import app.odds365.sportbet.Model.Leaguez
import app.odds365.sportbet.Model.Teams
import app.odds365.sportbet.R
import app.odds365.sportbet.View.MainFragment
import app.odds365.sportbet.databinding.DfactsBinding
import app.odds365.sportbet.databinding.DleagueBinding
import app.odds365.sportbet.databinding.DteamBinding
import com.squareup.picasso.Picasso

class TeamsAdapter(val list: List<Teams>, val click: getDetails) : RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {

    class ViewHolder(binding: DteamBinding ) : RecyclerView.ViewHolder(binding.root)  {
        var bindings : DteamBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(DataBindingUtil.inflate(
        LayoutInflater.from(parent.context), R.layout.dteam, parent, false))

    override fun onBindViewHolder(holder: TeamsAdapter.ViewHolder, position: Int) {
        val data = list[position]

        holder.bindings.root.setOnClickListener {

            click.getDetails(data.strTeam.toString()
                ,data.strDescriptionEN.toString()
                ,data.strTeamLogo.toString()
                ,data.strTeamBanner.toString())
        }

        holder.bindings.ltitle.text = data.strTeam
        holder.bindings.ldesc.text = data.strDescriptionEN
        Picasso.get().load(data.strTeamLogo).into(holder.bindings.llogo)
        Picasso.get().load(data.strTeamBanner).into(holder.bindings.lbanner)

    }

    override fun getItemCount(): Int {
       return list.size
    }

    interface getDetails
    {
        fun getDetails(title : String, desc : String, logo :String,banner : String)
    }

}