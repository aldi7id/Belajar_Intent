package com.ajgroup.belajarintent.intent.activitydestination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajgroup.belajarintent.MainActivity
import com.ajgroup.belajarintent.StudentSerializable
import com.ajgroup.belajarintent.databinding.ActivityMainBinding
import com.ajgroup.belajarintent.databinding.ActivitySerializableBinding

class SerializableActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySerializableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySerializableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myStudent: StudentSerializable = intent.getSerializableExtra(MainActivity.OBJECT_SERIALIZABLE) as StudentSerializable

        binding.tvName.text = myStudent.name
        binding.tvNim.text = myStudent.nim
        binding.tvAge.text = myStudent.age.toString()
    }
}