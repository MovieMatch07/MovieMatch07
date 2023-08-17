package com.suraj.moviematch.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PowerManager
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.suraj.moviematch.R
import com.suraj.moviematch.databinding.ActivityPlayMoviesBinding

class PlayMoviesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayMoviesBinding

    private lateinit var playerView: StyledPlayerView
    private lateinit var player: ExoPlayer
    private var movieUrl = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )


        binding = ActivityPlayMoviesBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
        val wakeLock = powerManager.newWakeLock(
            PowerManager.SCREEN_DIM_WAKE_LOCK or PowerManager.ACQUIRE_CAUSES_WAKEUP,
            "MyApp::MyWakelockTag"
        )
        wakeLock.acquire()

        val intent = intent
        movieUrl = intent.getStringExtra("movieUrl").toString()

        setpVideoPlayer2()


    }


    private fun setpVideoPlayer2() {
         playerView = findViewById<StyledPlayerView>(R.id.player_view)
         player = ExoPlayer.Builder(this).build()
        playerView.player = player
        val mediaItem: MediaItem = MediaItem.fromUri(movieUrl)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.addListener(object : Player.Listener {
            override fun onIsLoadingChanged(isLoading: Boolean) {
                super<Player.Listener>.onIsLoadingChanged(isLoading)

            }

            override fun onIsPlayingChanged(isPlaying: Boolean) {
                super<Player.Listener>.onIsPlayingChanged(isPlaying)
                binding.progressMovie.visibility = View.GONE
            }
        })
        player.playWhenReady = true

    }

    override fun onBackPressed() {
      showExitConfirmationDialog()
    }

    private fun showExitConfirmationDialog() {
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Confirmation")
            .setMessage("Are you sure you want to stop watching the movie?")
            .setPositiveButton("Yes") { dialog, _ ->
                player.release()
                val intent = Intent(this@PlayMoviesActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss() // Dismiss the dialog
            }
            .create()

        alertDialog.show()
    }

}
