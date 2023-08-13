package com.suraj.moviematch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.suraj.moviematch.R
import com.suraj.moviematch.dataClasses.Shorts

class VideoAdapter() :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {
     var videoActList = ArrayList<Shorts>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shorts_view, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bindVideo(videoActList[position])
    }

    override fun getItemCount(): Int {
        return videoActList.size
    }

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val videoView: VideoView = itemView.findViewById(R.id.videoView)
        private val videoTitle: TextView = itemView.findViewById(R.id.txtTitle)
        private val videoDesc: TextView = itemView.findViewById(R.id.txtMovieName)
        private val progressVideo: ProgressBar = itemView.findViewById(R.id.ProgreesVideo)

        fun bindVideo(shorts: Shorts) {
            videoTitle.text = shorts.title
            videoDesc.text = shorts.movie
            videoView.setVideoPath(shorts.url)
            videoView.setOnPreparedListener { mediaPlayer ->
                progressVideo.visibility = View.GONE
                mediaPlayer.start()
                val videoRatio = mediaPlayer.videoWidth / mediaPlayer.videoHeight.toFloat()
                val screenRatio = videoView.width / videoView.height.toFloat()
                val scale = videoRatio / screenRatio
                if (scale >= 1f) {
                    videoView.scaleX = scale
                } else {
                    videoView.scaleY = 1f / scale
                }
            }
            videoView.setOnCompletionListener { mediaPlayer -> mediaPlayer.start() }
        }
    }
    fun addAll(videoList: List<Shorts>){
        videoActList.clear()
        videoActList.addAll(videoList)
        notifyDataSetChanged()
    }
}
