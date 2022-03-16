package com.ajgroup.belajarintent.intent.activitydestination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajgroup.belajarintent.AnimalParcelable
import com.ajgroup.belajarintent.MainActivity
import com.ajgroup.belajarintent.databinding.ActivityParcelableBinding

class ParcelableActivity : AppCompatActivity() {
    private lateinit var binding: ActivityParcelableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParcelableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAnimal = intent.getParcelableExtra<AnimalParcelable>(MainActivity.OBJECT_PARCELABLE)

        binding.tvName.text = myAnimal?.name
        binding.tvColor.text = myAnimal?.color
        binding.tvLegs.text = myAnimal?.legs.toString()
        binding.tvEnv.text = myAnimal?.environment
    }
}