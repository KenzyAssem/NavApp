package com.example.navapp

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val igButton : Button = findViewById<Button>(R.id.instagram_label)
        val igPackName = "com.instagram.android."
        val igURI = "http://instagram.com"

        val fbButton : Button = findViewById<Button>(R.id.facebook_label)
        val fbPackName = "com.facebook.katana"
        val fbURI = "fb://feed"

        val twtButton : Button = findViewById<Button>(R.id.twitter_label)
        val twtPackName ="com.twitter.android"
        val twtURI = "https://twitter.com/intent"

        val gmailButton : Button = findViewById<Button>(R.id.gmail_label)
        val gmailPackName ="com.google.android.gm"
        val gmailURI = "mailto:"

        val linkedButton : Button = findViewById<Button>(R.id.linkedin_label)
        val linkedPackName ="com.linkedin.android"
        val linkedURI = "linkedin://you"


        igButton.setOnClickListener {
            redirect(igPackName, igURI)
        }

        fbButton.setOnClickListener {
            redirect(fbPackName, fbURI)
        }

        twtButton.setOnClickListener {
            redirect(twtPackName, twtURI)
        }

        gmailButton.setOnClickListener {
            redirect(gmailPackName, gmailURI)
        }

        linkedButton.setOnClickListener {
            redirect(linkedPackName, linkedURI)
        }

    }


   private fun redirect(packName: String, URI : String){

           try {
               startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(URI)))

           } catch (e: ActivityNotFoundException) {
               alternative(packName)
           }
       }


    private fun alternative(packName : String){
           Toast.makeText(this@MainActivity, "Please download the application", Toast.LENGTH_SHORT).show()
           startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packName")))

    }



}