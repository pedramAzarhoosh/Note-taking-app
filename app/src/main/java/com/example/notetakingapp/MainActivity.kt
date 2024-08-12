package com.example.notetakingapp

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.notetakingapp.database.NoteDatabase
import com.example.notetakingapp.databinding.ActivityMainBinding
import com.example.notetakingapp.repository.Repository
import com.example.notetakingapp.viewmodel.MyViewModel
import com.example.notetakingapp.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var noteViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.primary)))

        setUpViewModel()
    }

    private fun setUpViewModel(){
        val repo = Repository(NoteDatabase(this))
        val viewModelProviderFactory = MyViewModelFactory(application,repo)
        noteViewModel = ViewModelProvider(
            this, viewModelProviderFactory
        ).get(MyViewModel::class.java)
    }
}