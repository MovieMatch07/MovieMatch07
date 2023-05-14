package com.suraj.moviematch.dialogs

import android.app.Dialog
import android.content.Context
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.suraj.moviematch.R
import com.suraj.moviematch.dataClasses.MovieReview


class AddReviewDialog(context: Context, val movieName: String) : Dialog(context) {

    private lateinit var txtMovieName: TextView
    private lateinit var imgCloseDialog: ImageView
    private lateinit var edtUserReview: EditText
    private lateinit var ratingBar: RatingBar
    private lateinit var btnSave: Button

    init {
        setContentView(R.layout.add_reviews_dialog)

        initView()
        initData()
        setOnClick()

    }


    private fun initView() {
        txtMovieName = findViewById(R.id.txtDialogMovieName)
        imgCloseDialog = findViewById(R.id.closeDialog)
        edtUserReview = findViewById(R.id.edtUserReview)
        ratingBar = findViewById(R.id.ratingBar)
        btnSave = findViewById(R.id.btnSaveReview)

    }

    private fun initData() {
        txtMovieName.text = movieName
    }

    private fun setOnClick() {
        btnSave.setOnClickListener {
            Toast.makeText(context, "${ratingBar.rating} ", Toast.LENGTH_SHORT).show()

            val userData = MovieReview(edtUserReview.text.toString()
                ,ratingBar.rating
                ,FirebaseAuth.getInstance().currentUser?.email.toString())

            FirebaseDatabase.getInstance().reference.child("reviews").child(txtMovieName.text.toString()).push().setValue(userData)


            dismiss()
        }

        imgCloseDialog.setOnClickListener {

            dismiss()
        }


    }

}
