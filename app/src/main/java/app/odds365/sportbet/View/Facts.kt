package app.odds365.sportbet.View

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import app.odds365.sportbet.Adapter.FactsAdapter
import app.odds365.sportbet.R
import app.odds365.sportbet.ViewModel.FactsVM
import app.odds365.sportbet.databinding.FragmentFactsBinding

class Facts : Fragment() {

    var factsVM : FactsVM = FactsVM()
    lateinit var bindings : FragmentFactsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindings = DataBindingUtil.inflate(inflater, R.layout.fragment_facts, container, false)

        val dialog = ProgressDialog.show(activity, "", "Please wait。 Loading...", true)
        dialog.show()
        Handler(Looper.getMainLooper()).postDelayed({
            dialog.dismiss()
        }, 3000)

        loadFacts()
        return bindings.root
    }

    fun loadFacts()
    {
        val id =  arguments?.getString("idLeague")

        factsVM = ViewModelProvider(this).get(factsVM::class.java)
        factsVM.factsVMCall(id!!.toInt()).observe(viewLifecycleOwner, Observer {
            if(it == null) {
                bindings.noEvent.visibility = View.VISIBLE
            }else{
                bindings.factsView.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(activity)
                    adapter = FactsAdapter(it)
                }
            }
        })
    }

}