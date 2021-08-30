package app.odds365.sportbet.View

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import app.odds365.sportbet.Adapter.LeagueAdapter
import app.odds365.sportbet.R
import app.odds365.sportbet.ViewModel.LeagueVM
import app.odds365.sportbet.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(), LeagueAdapter.getPos {
    var doubleBackToExitPressedOnce = false
    lateinit var bindings: ActivityMainBinding
    var viewModel : LeagueVM = LeagueVM()
    lateinit var idLeague : String
    lateinit var nameLeague : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar!!.hide()
        loadLeagues()

        val pics = arrayListOf(R.drawable.banner1,R.drawable.banner2,R.drawable.banner3)
        bindings.carousel.setImageListener { position:Int, imageView: ImageView ->
            Picasso.get().load(pics[position]).into(imageView)
        }
        bindings.carousel.pageCount = pics.size

    }

    private fun loadLeagues()
    {
        viewModel = ViewModelProvider(this).get(viewModel::class.java)
        viewModel.leagueVMCall().observe(this, Observer {
            if(it == null) {
                bindings.noEvent.visibility = View.VISIBLE
            }else{
                bindings.leagueView.apply {
                    setHasFixedSize(true)
                    layoutManager = GridLayoutManager(this@MainActivity,2)
                    adapter = LeagueAdapter(it,this@MainActivity)
                }
            }
        })
    }

    override fun getPosition(position: String, leaguename: String) {
        idLeague = position
        nameLeague = leaguename
        startActivity(Intent(this, MainFragment::class.java).apply {
            putExtra("idleague", idLeague)
            putExtra("nameLeague", nameLeague)
        })


    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click back twice to exit..", Toast.LENGTH_SHORT).show()
        Handler(Looper.getMainLooper()).postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
}