package com.suraj.moviematch.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.suraj.moviematch.R
import com.suraj.moviematch.Utils.Utils
import com.suraj.moviematch.Utils.Utils.Companion.makeToast
import com.suraj.moviematch.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    lateinit var binding: ActivityCreateAccountBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

        setUpListener()

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            updateUI(currentUser)
        }
    }


    private fun initView() {

        auth = Firebase.auth

    }


    private fun setUpListener() {

       binding.btnCreateAccount.setOnClickListener {

            when {

                binding.editEmail .text.toString().isEmpty() -> makeToast(baseContext, "Enter Email")

                binding.editEmail .text.toString().isEmpty() -> makeToast(baseContext, "Enter Password")

                !Utils.isValidGmail(binding.editEmail.text.toString()) -> makeToast(baseContext, "Invalid email")

                else -> createAccount(binding.editEmail.text.toString(), binding.editPassword.text.toString())

            }

        }

        binding.txtHaveAccount.setOnClickListener {
            var intent = Intent(this@CreateAccountActivity, loginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    makeToast(baseContext, "Create Account successfully")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    makeToast(baseContext, "Authentication failed.")
                }
            }
    }


    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            val intent = Intent(this@CreateAccountActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}