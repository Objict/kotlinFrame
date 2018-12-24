package com.example.kin.kotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kin.kotlindemo.activity.demo.SimpleRecycleViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_simple_adapter.setOnClickListener {
            startActivity(Intent(this,SimpleRecycleViewActivity::class.java))
        }
    }
}
