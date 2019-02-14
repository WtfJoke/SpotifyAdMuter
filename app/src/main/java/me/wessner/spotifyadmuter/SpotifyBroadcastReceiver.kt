package me.wessner.spotifyadmuter

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class SpotifyBroadcastReceiver : BroadcastReceiver() {

    internal object BroadcastTypes {
        val SPOTIFY_PACKAGE = "com.spotify.music"
        val PLAYBACK_STATE_CHANGED = "$SPOTIFY_PACKAGE.playbackstatechanged"
        val QUEUE_CHANGED = "$SPOTIFY_PACKAGE.queuechanged"
        val METADATA_CHANGED = "$SPOTIFY_PACKAGE.metadatachanged"
    }

    override fun onReceive(context: Context, intent: Intent) {
        val timeSentInMs = intent.getLongExtra("timeSent", 0L)
        val action = intent.getAction()

        if (action == BroadcastTypes.METADATA_CHANGED) {
            val trackId = intent.getStringExtra("id")
            val artistName = intent.getStringExtra("artist")
            val albumName = intent.getStringExtra("album")
            val trackName = intent.getStringExtra("track")
            Toast.makeText(context, "Current track: " + trackName, Toast.LENGTH_SHORT).show()
        }
    }
}