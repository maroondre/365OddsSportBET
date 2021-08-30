package app.odds365.sportbet.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import app.odds365.sportbet.Model.Leagues
import app.odds365.sportbet.Model.Leaguez
import app.odds365.sportbet.R
import app.odds365.sportbet.View.MainFragment
import app.odds365.sportbet.databinding.DfactsBinding
import app.odds365.sportbet.databinding.DleagueBinding
import com.squareup.picasso.Picasso

class FactsAdapter(val list: List<Leaguez>) : RecyclerView.Adapter<FactsAdapter.ViewHolder>() {

    class ViewHolder(binding: DfactsBinding ) : RecyclerView.ViewHolder(binding.root)  {
        var bindings : DfactsBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(DataBindingUtil.inflate(
        LayoutInflater.from(parent.context), R.layout.dfacts, parent, false))

    override fun onBindViewHolder(holder: FactsAdapter.ViewHolder, position: Int) {
        val data = list[position]

        holder.bindings.ltitle.text = data.strLeague
        holder.bindings.ldesc.text = data.strDescriptionEN
        Picasso.get().load(data.strLogo).into(holder.bindings.llogo)
        Picasso.get().load(data.strBanner).into(holder.bindings.lbanner)

    }

    override fun getItemCount(): Int {
       return list.size
    }

}