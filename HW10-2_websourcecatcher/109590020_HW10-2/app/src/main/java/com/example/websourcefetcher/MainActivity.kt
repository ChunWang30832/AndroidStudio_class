package com.example.websourcefetcher

import android.os.Bundle
import android.view.MenuInflater
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager
import androidx.loader.content.Loader

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<String> {


    private lateinit var httpTextView: TextView
    private lateinit var urlText: EditText
    private lateinit var pageSource: TextView
    private lateinit var Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        httpTextView = findViewById(R.id.http_textview)
        httpTextView.setOnClickListener { view ->
            val popup = PopupMenu(this, view)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.http_menu, popup.menu)

            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.http -> httpTextView.text = getString(R.string.http_text)
                    R.id.https -> httpTextView.text = getString(R.string.https_text)
                }
                true
            }
            popup.show()
        }
        urlText = findViewById(R.id.url)
        Button = findViewById(R.id.button)
        Button.setOnClickListener {
            LoaderManager.getInstance(this).restartLoader(0, null, this)
            pageSource.text = "Loading ..."
        }
        pageSource = findViewById(R.id.page_source)
    }
    override fun onCreateLoader(id: Int, args: Bundle?): Loader<String> {
        val url = httpTextView.text.toString() + urlText.text.toString()
        return HtmlLoader(this, url)
    }

    override fun onLoadFinished(loader: Loader<String>, data: String?) {
        pageSource.text = data
    }
    override fun onLoaderReset(loader: Loader<String>) {}
}