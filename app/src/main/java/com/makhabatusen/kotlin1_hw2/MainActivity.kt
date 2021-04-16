package com.makhabatusen.kotlin1_hw2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.makhabatusen.kotlin1_hw2.databinding.ActivityMainBinding
import com.makhabatusen.kotlin1_hw2.extensions.loadImage


class MainActivity : AppCompatActivity() {
    private lateinit var ui: ActivityMainBinding
    private var list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)
        init()
    }

    private fun init() {

        initialUlrs()

        ui.btnAdd.setOnClickListener {
            if (!ui.editText.text.isNullOrBlank())
                list.add(ui.editText.text.toString())
        }

        ui.btnRandom.setOnClickListener {
            if (!list.isNullOrEmpty()) {
                val url = list.random()
                ui.imageView.loadImage(this, url)
            }
        }
    }

    private fun initialUlrs() {
        list.add("https://previews.123rf.com/images/snake3d/snake3d1907/snake3d190700173/127676254-helium-party-balloons-baloons-ballons-bunch-blue-white-pink-birthday-decoration-carnival-celebration.jpg")
    }
}
