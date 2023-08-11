package com.suraj.moviematch.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PowerManager
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.ui.PlayerView
import com.suraj.moviematch.R

class PlayMoviesActivity : AppCompatActivity() {

    private lateinit var playerView: PlayerView
    private lateinit var player: SimpleExoPlayer

    private val mediaEventListener = object : Player.EventListener {
        override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
            when (playbackState) {
                Player.STATE_READY -> {
                    // Media is ready to play
                    // Implement buffering or loading indicators if needed
                }
                Player.STATE_BUFFERING -> {
                    Toast.makeText(this@PlayMoviesActivity, "loading...", Toast.LENGTH_SHORT).show()
                }
                Player.STATE_ENDED -> {
                   finish()
                }
                Player.STATE_IDLE -> {
                    // Media player is idle
                    // Handle idle state if needed
                }
            }
        }

        override fun onPlayerError(error: PlaybackException) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_play_movies)

        val powerManager = getSystemService(Context.POWER_SERVICE) as PowerManager
        val wakeLock = powerManager.newWakeLock(
            PowerManager.SCREEN_DIM_WAKE_LOCK or PowerManager.ACQUIRE_CAUSES_WAKEUP,
            "MyApp::MyWakelockTag"
        )
        wakeLock.acquire()

        val intent = intent
        val movieUrl = intent.getStringExtra("movieUrl")

        playerView = findViewById<PlayerView>(R.id.playerView)
        player = SimpleExoPlayer.Builder(this).build()
        playerView.player = player

        val videoUrl = movieUrl
        val mediaItem = videoUrl?.let { MediaItem.fromUri(Uri.parse(it)) }
        mediaItem?.let {
            player.setMediaItem(it)
        }

        // Attach the event listener to the player
        player.addListener(mediaEventListener)

        // Prepare the player
        player.prepare()
        player.play()
    }

    override fun onStop() {
        super.onStop()
        // Release the player when the activity is stopped
        player.release()
    }

    override fun onBackPressed() {
        val intent = Intent(this@PlayMoviesActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
