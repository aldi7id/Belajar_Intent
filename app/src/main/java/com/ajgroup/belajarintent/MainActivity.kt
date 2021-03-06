package com.ajgroup.belajarintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ajgroup.belajarintent.databinding.ActivityMainBinding
import com.ajgroup.belajarintent.intent.activitydestination.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val MESSAGE = "MESSAGE"
        const val AGE = "AGE"
        const val BUNDLE = "BUNGKUSAN"
        const val OBJECT_SERIALIZABLE = "OBJEK SERIALIZABLE"
        const val OBJECT_PARCELABLE = "OBJECT PARCELABLE"
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnSend.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, binding.etMessage.text.toString())
                type = "text/plain"
            }
            if (sendIntent.resolveActivity(packageManager) != null) {
                startActivity(sendIntent)
            }
        }
        binding.btnSimpleIntent.setOnClickListener {
            val intentToSecondActivity = Intent(this, SecondActivity::class.java)
            startActivity(intentToSecondActivity)
        }
        binding.btnSimplePutExtra.setOnClickListener {
            val message = binding.etMessage.text.toString()
            val age = binding.etAge.text.toString().toInt()

            val simpleIntentExample =
                Intent(this, SimplePutExtraDestinationActivity::class.java).apply {
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

        binding.btnPutExtraserializable.setOnClickListener {
            if (binding.etMhsAge.text.isNotEmpty()) {
                val studentAndroid = StudentSerializable(
                    binding.etMhsName.text.toString(),
                    binding.etMhsAge.text.toString().toInt(),
                    binding.etMhsNim.text.toString()
                )

                val intentSerializable = Intent(this, SerializableActivity::class.java).apply {
                    putExtra(OBJECT_SERIALIZABLE, studentAndroid)
                }
                startActivity(intentSerializable)
            } else {
                Toast.makeText(this, "HARAP DI ISI UMUR", Toast.LENGTH_SHORT).show()
            }


        }
        binding.btnPutParcelable.setOnClickListener {
            if (binding.etAnmLegs.text.isNotEmpty()) {
                val animal = AnimalParcelable(
                    binding.etAnmName.text.toString(),
                    binding.etAnmColor.text.toString(),
                    binding.etAnmLegs.text.toString().toInt(),
                    binding.etAnmEnv.text.toString()
                )
                val intentParcelable = Intent(this, ParcelableActivity::class.java).apply {
                    putExtra(OBJECT_PARCELABLE, animal)
                }
                startActivity(intentParcelable)
            } else {
                Toast.makeText(this, "HARAP DI ISI KAKI", Toast.LENGTH_SHORT).show()
            }
        }
    }
}