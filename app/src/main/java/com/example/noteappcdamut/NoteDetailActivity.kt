package com.example.noteappcdamut

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NoteDetailActivity : AppCompatActivity() {
    companion object {
        val EXTRA_NOTE = "note"
        val EXTRA_NOTE_INDEX = "noteIndex"

        lateinit var note: Note
        var noteIndex: Int = -1

        lateinit var titleView: TextView
        lateinit var contentView: TextView
    }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_note_detail)

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }


        note = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_NOTE, Note::class.java)!!
        } else {
            intent.getParcelableExtra<Note>(EXTRA_NOTE)!!
        }

            titleView = findViewById<TextView>(R.id.title)
            contentView = findViewById<TextView>(R.id.text)

            titleView.text = note.title
            contentView.text = note.content

            noteIndex = intent.getIntExtra(EXTRA_NOTE_INDEX, -1)


    }
}