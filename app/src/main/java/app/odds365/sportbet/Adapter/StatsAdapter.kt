package app.odds365.sportbet.Adapter

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import app.odds365.sportbet.Model.Table
import app.odds365.sportbet.R
import app.odds365.sportbet.databinding.DstatsBinding
import com.squareup.picasso.Picasso

class StatsAdapter(val list: List<Table>) : RecyclerView.Adapter<StatsAdapter.ViewHolder>() {

    class ViewHolder(binding: DstatsBinding) : RecyclerView.ViewHolder(binding.root)  {
        var bindings : DstatsBinding = binding
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(DataBindingUtil.inflate(
        LayoutInflater.from(parent.context), R.layout.dstats, parent, false))

    override fun onBindViewHolder(holder: StatsAdapter.ViewHolder, position: Int ) {
        val data = list[position]


        Picasso.get().load(data.strTeamBadge).into(holder.bindings.idlogo)
        holder.bindings.teamName.text = data.strTeam
        holder.bindings.plays.text = data.intPlayed.toString()
        holder.bindings.win.text = data.intWin.toString()
        holder.bindings.loss.text = data.intLoss.toString()
        holder.bindings.draw.text = data.intDraw.toString()
        holder.bindings.points.text = data.intPoints.toString()

    }

    override fun getItemCount(): Int {
       return list.size
    }



}