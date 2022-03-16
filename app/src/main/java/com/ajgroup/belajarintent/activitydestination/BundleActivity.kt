package com.ajgroup.belajarintent.activitydestination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajgroup.belajarintent.R
import com.ajgroup.belajarintent.databinding.ActivityBundleBinding

class BundleActivity : AppCompatActivity() {
    lateinit var binding: ActivityBundleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBundleBinding.inflate(layoutInflater)
    }
}