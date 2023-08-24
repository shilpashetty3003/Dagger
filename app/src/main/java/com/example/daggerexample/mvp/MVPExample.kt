package com.example.daggerexample.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.daggerexample.R

class MVPExample : AppCompatActivity(), Contract.View {
    private var textView: TextView? = null
    private var button: Button? = null
    private var progressBar: ProgressBar? = null

    var presenter: Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvpexample)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)
        presenter = Presenter(this, Model())
        this.button!!.setOnClickListener { presenter!!.onButtonClick() }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }

    override fun showProgress() {
        progressBar?.visibility = View.VISIBLE
        textView?.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
        textView!!.visibility = View.VISIBLE
    }

    override fun setString(string: String?) {
        textView!!.text = string
    }
}