package com.suraj.moviematch.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.suraj.moviematch.R

class AddShortsDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_shorts_data)

        val firestore = FirebaseFirestore.getInstance()
        val shortsCollection = firestore.collection("shorts")

        val shortsDataList = arrayListOf(
            hashMapOf(
                "title" to "Lone Wolf from The Gray Man",
                "movie" to "The Gray Man",
                "url" to "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Shorts%2FtheGrayManMkv3.mkv?alt=media&token=3f2a5ee1-454f-45e4-9955-e8d96d064e98"
            ),
            hashMapOf(
                "title" to "DEATH is just unstoppable",
                "movie" to "Puss in Boots 2",
                "url" to "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Shorts%2FPuessInBootsMKV.mkv?alt=media&token=0001d475-3fcd-45fb-9c95-37b6c9c27224"
            ),
            hashMapOf(
                "title" to "Wednesday Addams",
                "movie" to "Wednesday",
                "url" to "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Shorts%2Fwednesday.mkv?alt=media&token=fe4805c7-3b44-4883-875a-ae9c4ee74493"
            ),

        )

        for (shortData in shortsDataList) {
            // Add each HashMap to the "shorts" collection
            shortsCollection.add(shortData)
                .addOnSuccessListener { documentReference ->
                    Log.e("shortsLiveData","$documentReference")
                }
                .addOnFailureListener { exception ->
                   Log.e("shortsLiveData","$exception")
                }
        }


    }
}