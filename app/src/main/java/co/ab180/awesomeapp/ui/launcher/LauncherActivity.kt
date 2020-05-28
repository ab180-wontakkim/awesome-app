package co.ab180.awesomeapp.ui.launcher

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.ab180.awesomeapp.R
import co.ab180.awesomeapp.ui.main.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        GlobalScope.launch(Dispatchers.Main) {
            delay(1000)
            startActivity(Intent(baseContext, MainActivity::class.java))
            finish()
        }
    }
}