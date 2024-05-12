package com.example.labexam04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.labexam04.databinding.ActivityAddTaskBinding
import com.example.labexam04.databinding.ActivityMainBinding

class  AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding
    private lateinit var db: TasksDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TasksDatabaseHelper(this)

        binding. saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding. contentEditText.text.toString()
            val task = Task( 0, title, content)
            db.insertTask(task)
            finish()
            Toast.makeText( this,"Task Saved", Toast.LENGTH_SHORT).show()
        }
    }
}
