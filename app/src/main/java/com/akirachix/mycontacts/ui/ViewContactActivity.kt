package com.akirachix.mycontacts.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.akirachix.mycontacts.R
import com.akirachix.mycontacts.databinding.ActivityMainBinding
import com.akirachix.mycontacts.databinding.ActivityViewContactBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    var contactId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.extras!=null){
            contactId = intent.getIntExtra("Contact_Id", 0)
        }
        else{
            finish()
        }

    }
}