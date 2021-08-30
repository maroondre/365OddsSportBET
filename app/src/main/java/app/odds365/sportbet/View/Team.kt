package app.odds365.sportbet.View

import android.app.ActivityOptions
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import app.odds365.sportbet.Adapter.FactsAdapter
import app.odds365.sportbet.Adapter.TeamsAdapter
import app.odds365.sportbet.R
import app.odds365.sportbet.ViewModel.TeamVM
import app.odds365.sportbet.databinding.FragmentTeamBinding

class Team : Fragment(), TeamsAdapter.getDetails {

    var teamVm : TeamVM = TeamVM()
    lateinit var bindings : FragmentTeamBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindings = DataBindingUtil.inflate(inflater, R.layout.fragment_team, container, false)
        val dialog = ProgressDialog.show(activity, "", "Please wait。 Loading...", true)
        dialog.show()
        Handler(Looper.getMainLooper()).postDelayed({
            dialog.dismiss()
        }, 3000)

        loadTeam()
        return bindings.root
    }

    fun loadTeam()
    {
        val name =  arguments?.getString("nameLeague")

        teamVm = ViewModelProvider(this).get(teamVm::class.java)
        teamVm.teamVMCall(name.toString()).observe(viewLifecycleOwner, Observer {
            if(it == null) {
                bindings.noEvent.visibility = View.VISIBLE
            }else{
                bindings.teamView.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(activity)
                    adapter = TeamsAdapter(it,this@Team)
                }
            }
        })
    }

    override fun getDetails(title: String, desc: String, logo: String, banner: String) {
        startActivity(Intent(activity, Teammore::class.java).apply{
            putExtra("teamtitle", title)
            putExtra("teamdesc", desc)
            putExtra("teamlogo", logo)
            putExtra("teambanner", banner)})
    }

}