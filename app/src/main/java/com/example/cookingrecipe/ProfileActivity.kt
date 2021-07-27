package com.example.cookingrecipe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity(){

    lateinit var mGoogleSignInClient: GoogleSignInClient

    private val auth by lazy {
        FirebaseAuth.getInstance()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setupNavigation()

        val user = Firebase.auth.currentUser
        user?.let{
            val email = user.email
            val google_email_textview:TextView=findViewById(R.id.google_email_textview)
            google_email_textview.text = email

            val googleId = user.displayName
            val google_id_textview:TextView=findViewById(R.id.google_id_textview)
            google_id_textview.text = googleId


        }



        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient= GoogleSignIn.getClient(this,gso)

        val logout : CardView = findViewById(R.id.logout)
        logout.setOnClickListener {
            mGoogleSignInClient.signOut().addOnCompleteListener {
                val intent= Intent(this, LoginActivity::class.java)
                Toast.makeText(this,"Logging Out", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }
        }



    }




    private fun setupNavigation(){
        val nalView: BottomNavigationView = findViewById(R.id.nav_view)
        nalView.setOnNavigationItemReselectedListener { item ->
            when(item.itemId){
                R.id.home ->{

                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()

                }
                R.id.profile ->{
                    Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show()
                    true

                }

            }

        }
    }
}