package app.odds365.sportbet.View

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import app.odds365.sportbet.Adapter.StatsAdapter
import app.odds365.sportbet.R
import app.odds365.sportbet.ViewModel.StatsVM
import app.odds365.sportbet.databinding.FragmentRankBinding

class Rank : Fragment() {

    var rankVM : StatsVM = StatsVM()
    lateinit var binding : FragmentRankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rank, container, false)
        val dialog = ProgressDialog.show(activity, "", "Please wait。 Loading...", true)
        dialog.show()
        Handler(Looper.getMainLooper()).postDelayed({
            dialog.dismiss()
        }, 3000)

        loadStats()

        return binding.root
    }

    fun loadStats()
    {
        val id =  arguments?.getString("idLeague")

        rankVM = ViewModelProvider(this).get(rankVM::class.java)
        rankVM.stsVMCall(id!!.toInt(),"2020-2021").observe(viewLifecycleOwner, Observer {
            if(it == null) {
                binding.noEvent.visibility = View.VISIBLE
            }else{
                binding.rankView.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(activity)
                    adapter = StatsAdapter(it)
                }
            }
        })
    }
}