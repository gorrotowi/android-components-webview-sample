package com.gorrotowi.webviewsample

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import mozilla.components.browser.engine.system.SystemEngine
import mozilla.components.concept.engine.Engine
import mozilla.components.concept.engine.EngineView


class MainActivity : AppCompatActivity() {

    private val engine: Engine by lazy {
        SystemEngine(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val engine = GeckoEngine(this)

        val session = engine.createSession()
        engineView.render(session)
        session.loadUrl("https://roundme.com/tour/395921/view/1419269/")//("https://mozilla.org")

    }

    override fun onCreateView(parent: View?, name: String?, context: Context, attrs: AttributeSet?): View? =
        when (name) {
            EngineView::class.java.name -> engine.createView(context, attrs).asView()
            else -> super.onCreateView(parent, name, context, attrs)
        }

}
