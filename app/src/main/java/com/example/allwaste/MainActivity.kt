package com.example.allwaste

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var handler: Handler
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()
        handler = Handler()
        handler.postDelayed({
            if(firebaseAuth.currentUser != null){
                val intent = Intent(this, PostRecyclableActivity::class.java)
                startActivity(intent)
                finish()
//                Toast.makeText(this, "There is a logged in user", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, RegistrationActivity::class.java)
                startActivity(intent)
                finish()
//                Toast.makeText(this, "There is a logged in user", Toast.LENGTH_SHORT).show()
            }
        }, 3000)

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.primary)
        }
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#008374")))
    }
}