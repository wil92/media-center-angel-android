package com.angelmc.activities

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

import com.angelmc.R

class MediaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        val videoView = this.findViewById<VideoView>(R.id.video)
        val videoUrl = "http://192.168.43.238:3000/api/media/0/?subdir=Psych/Psych.S01E01.480p.[Nightsdl.Com].mkv"

        val videoUri = Uri.parse(videoUrl)
        videoView.setVideoURI(videoUri)

        videoView.start()
    }
}
