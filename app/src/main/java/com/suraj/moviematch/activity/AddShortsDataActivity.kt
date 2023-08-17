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
//            hashMapOf(
//                "title" to "Lone Wolf from The Gray Man",
//                "movie" to "The Gray Man",
//                "url" to "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Shorts%2FtheGrayManMkv3.mkv?alt=media&token=3f2a5ee1-454f-45e4-9955-e8d96d064e98"
//            ),
//            hashMapOf(
//                "title" to "DEATH is just unstoppable",
//                "movie" to "Puss in Boots 2",
//                "url" to "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Shorts%2FPuessInBootsMKV.mkv?alt=media&token=0001d475-3fcd-45fb-9c95-37b6c9c27224"
//            ),
//            hashMapOf(
//                "title" to "Wednesday Addams",
//                "movie" to "Wednesday",
//                "url" to "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Shorts%2Fwednesday.mkv?alt=media&token=fe4805c7-3b44-4883-875a-ae9c4ee74493"
//            ),
//

            hashMapOf(
                "title" to "Ghost Of The Uchiha",
                "movie" to "Naruto",
                "url" to "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Shorts%2FGhostOfTheUchiha.mp4?alt=media&token=4c0d0e6e-ce80-4708-9831-cf6bed7186f5"
            ),

            hashMapOf(
                "title" to "Top 3 Horror Movies",
                "movie" to "IT, Lights Out, Orphan",
                "url" to "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Shorts%2FTop3HorrorMovies.mp4?alt=media&token=ef08d3ff-6f48-4292-a836-252acdbcd72a"
            ),
            hashMapOf(
                "title" to "Top 3 Movies Felt Real",
                "movie" to "Aliens, 2012, Zombie",
                "url" to "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Shorts%2FTop3Movies.mp4?alt=media&token=9e4da4f3-3487-4c73-b97d-ceac1682508d"
            ),
            hashMapOf(
                "title" to "Top 3 Thrillers",
                "movie" to "DEJAVU, The Sixth Sense, Shutter Island",
                "url" to "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Shorts%2FTop3Thiller.mp4?alt=media&token=a3d0ab62-575b-4354-a3b8-3ec833487237"
            ),


            hashMapOf(
                "title" to "Undoubtedly, its jaw-dropping scene",
                "movie" to "Fall",
                "url" to "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Shorts%2Ffall.mp4?alt=media&token=160c3db2-67ef-498c-a6bd-c8482b860309"
            ),
            hashMapOf(
                "title" to "Mind Blowing Storyline",
                "movie" to "From",
                "url" to "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Shorts%2Ffrom.mp4?alt=media&token=0300ef7b-0385-4e21-bb21-bc2e817d26c0"
            ),


            hashMapOf(
                "title" to "Kakashi vs Pain",
                "movie" to "Naruto",
                "url" to "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/Shorts%2Fkakashi.mp4?alt=media&token=6444e5f9-0985-4247-bbe7-b73a8cd2e8d4"
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