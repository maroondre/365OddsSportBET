package app.odds365.sportbet.View

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import app.odds365.sportbet.R
import app.odds365.sportbet.databinding.ActivityTeammoreBinding
import com.squareup.picasso.Picasso

class Teammore : AppCompatActivity() {
    lateinit var bindings : ActivityTeammoreBinding

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = DataBindingUtil.setContentView(this, R.layout.activity_teammore)
        supportActionBar!!.hide()



        val title = intent.getStringExtra("teamtitle").toString()
        val desc = intent.getStringExtra("teamdesc").toString()
        val logo = intent.getStringExtra("teamlogo").toString()
        val banner = intent.getStringExtra("teambanner").toString()

        bindings.ltitle.text = title
        bindings.ldesc.text = desc
        Picasso.get().load(logo).into(bindings.llogo)
        Picasso.get().load(banner).into(bindings.lbanner)
    }
}