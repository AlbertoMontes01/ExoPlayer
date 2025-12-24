package com.example.miniexoplayer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class MainActivity : AppCompatActivity() {

    private lateinit var player: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1 Crear el player
        player = ExoPlayer.Builder(this).build()

        // 2 Conectar player con la UI
        val playerView = findViewById<PlayerView>(R.id.playerView)
        playerView.player = player

        // 3 Crear el MediaItem (el video)
        val mediaItem = MediaItem.fromUri(
            "https://storage.googleapis.com/exoplayer-test-media-0/play.mp3"
        )

        // 4 Enviar media al player
        player.setMediaItem(mediaItem)

        // 5 Preparar
        player.prepare()

        // 6 Reproducir
        player.play()
    }

    override fun onStop() {
        super.onStop()
        // 7 Liberar recursos
        player.release()
    }
}
