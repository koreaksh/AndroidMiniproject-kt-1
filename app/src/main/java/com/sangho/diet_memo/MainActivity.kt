package com.sangho.diet_memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sangho.diet_memo.customDialog.CustomDialog
import com.sangho.diet_memo.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val TAG = "LifeCycle"
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        runBlocking {
            delay(100)
        }
        setContentView(binding.root)
        anonymous()

        binding.writeBtn.setOnClickListener {
            val customDialog = CustomDialog()
            customDialog.show(supportFragmentManager, "customDialog")
        }
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"LifeCycle-MainActivity-onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"LifeCycle-MainActivity-onStop")
    }

    private fun anonymous() {  //익명로그인시키기.
        auth = Firebase.auth

        try {
            Log.d(TAG,auth.currentUser!!.uid)
        } catch (e : Exception) {
            Log.d(TAG,"회원가입 정보없어서 가입시킴!")
            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInAnonymously:success")
                    } else {
                        Log.w(TAG, "signInAnonymously:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    } //anonymous()
}