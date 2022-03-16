package com.ajgroup.belajarintent.activitydestination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajgroup.belajarintent.MainActivity
import com.ajgroup.belajarintent.databinding.ActivitySimplePutExtraDestinationBinding

class SimplePutExtraDestinationActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimplePutExtraDestinationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimplePutExtraDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Accept Data
        val message = intent.getStringExtra(MainActivity.MESSAGE)
        val age = intent.getIntExtra(MainActivity.AGE, 0)

        binding.tvMessage.text = message
        binding.tvAge.text = age.toString()
    }
}