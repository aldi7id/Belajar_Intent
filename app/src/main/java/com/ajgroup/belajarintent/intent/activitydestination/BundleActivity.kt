package com.ajgroup.belajarintent.intent.activitydestination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajgroup.belajarintent.MainActivity
import com.ajgroup.belajarintent.databinding.ActivityBundleBinding

class BundleActivity : AppCompatActivity() {
    lateinit var binding: ActivityBundleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBundleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myBundle = intent.getBundleExtra(MainActivity.BUNDLE)

        val message = myBundle?.getString(MainActivity.MESSAGE)
        val age = myBundle?.getInt(MainActivity.AGE,0)

        binding.tvMessage.text = message
        binding.tvAge.text = age.toString()
    }
}