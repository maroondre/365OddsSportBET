package app.odds365.sportbet.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import app.odds365.sportbet.R
import app.odds365.sportbet.databinding.MainFragmentBinding

class MainFragment : AppCompatActivity() {
    lateinit var selectedFrag : Fragment
    lateinit var bindings : MainFragmentBinding
    private  var idfacts : String = ""
    val bundle = Bundle()
    val bundles = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = DataBindingUtil.setContentView(this, R.layout.main_fragment)
        supportActionBar!!.hide()

        init()
        selectFrag()

    }

    fun init()
    {
        idfacts = intent.getStringExtra("idleague").toString()
        val nameLeague = intent.getStringExtra("nameLeague").toString()
        bundles.putString("nameLeague",nameLeague)
        bundle.putString("idLeague", idfacts)
        val fragobj = Facts()
        fragobj.arguments = bundle
        bindings.bottomNavigation.selectedItemId = R.id.one
        supportFragmentManager.beginTransaction().add(R.id.fLayout,fragobj).commit()
    }

    fun selectFrag()
    {
        bindings.bottomNavigation.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.one -> {
                    val facts = Facts()
                    facts.arguments = bundle
                    selectedFrag = facts
                }
                R.id.two -> {
                    val team = Team()
                    team.arguments = bundles
                    selectedFrag = team
                }
                R.id.three -> {
                    val rank = Rank()
                    rank.arguments = bundle
                    selectedFrag = rank
                }
            }
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_up,R.anim.slide_down)
                .replace(R.id.fLayout, selectedFrag)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
            true
        }
    }

}