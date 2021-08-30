package app.odds365.sportbet.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import app.odds365.sportbet.Model.Leagues
import app.odds365.sportbet.R
import app.odds365.sportbet.View.MainFragment
import app.odds365.sportbet.databinding.DleagueBinding

class LeagueAdapter(val list: List<Leagues>, val click: getPos) : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {
    lateinit var dBind: DleagueBinding
    lateinit var idLeague : String

    class ViewHolder(binding: DleagueBinding ) : RecyclerView.ViewHolder(binding.root)  {
        var bindings : DleagueBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(DataBindingUtil.inflate(
        LayoutInflater.from(parent.context), R.layout.dleague, parent, false))

    override fun onBindViewHolder(holder: LeagueAdapter.ViewHolder, position: Int) {
        val data = list[position]

        holder.bindings.root.setOnClickListener {

            idLeague = data.id.toString()
            click.getPosition(idLeague, data.strLeague.toString())
        }

        holder.bindings.title.text = data.strLeague
        holder.bindings.subtitle.text = data.strLeagueAlternate

    }

    override fun getItemCount(): Int {
       return list.size
    }

    interface getPos
    {
        fun getPosition(position: String, leaguename : String)
    }


}