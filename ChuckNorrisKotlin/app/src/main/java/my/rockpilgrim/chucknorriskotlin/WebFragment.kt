package my.rockpilgrim.chucknorriskotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.web_fragment.view.*
import my.rockpilgrim.chucknorriskotlin.databinding.WebFragmentBinding

class WebFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = WebFragmentBinding.inflate(inflater, container, false)
        val webView=binding.root.webView
        webView.webViewClient = WebViewClient()
        webView.settings.useWideViewPort = true
        webView.settings.loadWithOverviewMode= true

        webView.loadUrl(getString(R.string.api_url))
        return binding.root
    }
}