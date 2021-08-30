package app.odds365.sportbet.View

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.odds365.sportbet.R
import app.odds365.sportbet.ViewModel.WebVM
import app.odds365.sportbet.databinding.ActivitySplashBinding
import com.kaiguanjs.utils.YQCUtils

class Splash : AppCompatActivity() {
    var doubleBackToExitPressedOnce = false
    lateinit var binding : ActivitySplashBinding
    lateinit var webVM: WebVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        supportActionBar!!.hide()
        YQCUtils.splashAction(this) { version, downUrl ->
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this@Splash, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 4000)
        }
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