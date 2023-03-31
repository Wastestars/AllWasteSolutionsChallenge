package com.example.allwaste

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val register = findViewById<TextView>(R.id.txtSignUp)
        register.setOnClickListener{
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }

        val postRecyclable = findViewById<TextView>(R.id.btnSignIn)
        postRecyclable.setOnClickListener{
            Toast.makeText(applicationContext, "Welcome", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, PostRecyclableActivity::class.java)
            startActivity(intent)
            finish()
        }

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.primary)
        }
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#008374")))
    }
}