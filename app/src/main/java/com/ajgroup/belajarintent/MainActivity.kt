package com.ajgroup.belajarintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajgroup.belajarintent.intent.activitydestination.BundleActivity
import com.ajgroup.belajarintent.intent.activitydestination.SecondActivity
import com.ajgroup.belajarintent.intent.activitydestination.SimplePutExtraDestinationActivity
import com.ajgroup.belajarintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val MESSAGE = "MESSAGE"
        const val AGE = "AGE"
        const val BUNDLE = "BUNGKUSAN"
    }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnSend.setOnClickListener {
            val sendIntent = Intent().apply{
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, binding.etMessage.text.toString())
                type = "text/plain"
            }
            if(sendIntent.resolveActivity(packageManager) != null ){
                startActivity(sendIntent)
            }
        }
        binding.btnSimpleIntent.setOnClickListener {
            val intentToSecondActivity = Intent (this, SecondActivity::class.java)
            startActivity(intentToSecondActivity)
        }
        binding.btnSimplePutExtra.setOnClickListener {
            val message = binding.etMessage.text.toString()
            val age = binding.etAge.text.toString().toInt()

            val simpleIntentExample = Intent (this, SimplePutExtraDestinationActivity::class.java).apply {
                putExtra(MESSAGE, message)
                putExtra(AGE, age)

            }
            startActivity(simpleIntentExample)
        }
        binding.btnPutExtraBundle.setOnClickListener {
            val message = binding.etMessage.text.toString()
            val age = binding.etAge.text.toString().toInt()

//            val bundleSaya = Bundle()
//            bundleSaya.putString(MESSAGE, message)
//            bundleSaya.putInt(AGE,age)

            val bundleSaya = Bundle().apply {
                putString(MESSAGE, message)
                putInt(AGE, age)
            }

            val intentBundle = Intent(this, BundleActivity::class.java).apply {
                putExtra(BUNDLE, bundleSaya)
            }
        startActivity(intentBundle)

        }
    }
}