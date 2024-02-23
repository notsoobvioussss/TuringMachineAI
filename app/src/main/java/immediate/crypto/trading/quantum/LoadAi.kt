package immediate.crypto.trading.quantum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class LoadAi : AppCompatActivity() {
    private lateinit var container: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_ai)

        container = findViewById(R.id.container)

        Handler().postDelayed({
            runOnUiThread {
                changeBackground()
            }
        }, 2000)

        Handler().postDelayed({
            redirectToMenuActivity()
        }, 5000)
    }


    private fun changeBackground() {
        container.setBackgroundResource(R.drawable.loading)
        val textv = findViewById<TextView>(R.id.textView11)
        textv.visibility = View.VISIBLE
    }

    private fun redirectToMenuActivity() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
        finish()
    }
}