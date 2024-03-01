package com.finalyearproject.soundsoul.auth

import android.content.Intent
import android.util.Log

import com.adamratzman.spotify.SpotifyImplicitGrantApi
import com.adamratzman.spotify.SpotifyScope
import com.adamratzman.spotify.auth.implicit.AbstractSpotifyAppImplicitLoginActivity
import com.finalyearproject.soundsoul.BuildConfig

import com.finalyearproject.soundsoul.SpotifyPlaygroundApplication
import com.finalyearproject.soundsoul.activities.ActionHomeActivity
import com.finalyearproject.soundsoul.utils.toast

class SpotifyImplicitLoginActivityImpl : AbstractSpotifyAppImplicitLoginActivity() {
    override val state: Int = 1337
    override val clientId: String = BuildConfig.SPOTIFY_CLIENT_ID
    override val redirectUri: String = BuildConfig.SPOTIFY_REDIRECT_URI_AUTH
    override val useDefaultRedirectHandler: Boolean = false
    override fun getRequestingScopes(): List<SpotifyScope> = SpotifyScope.values().toList()

    override fun onSuccess(spotifyApi: SpotifyImplicitGrantApi) {
        val model = (application as SpotifyPlaygroundApplication).model
        model.credentialStore.setSpotifyApi(spotifyApi)
        toast("Authentication via spotify-auth has completed. Launching TrackViewActivity..")
        startActivity(Intent(this, ActionHomeActivity::class.java))
    }

    override fun onFailure(errorMessage: String) {
        toast("Auth failed: $errorMessage")
        Log.e("LoginError", errorMessage)
    }
}