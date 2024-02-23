package immediate.crypto.trading.quantum.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import immediate.crypto.trading.quantum.PopupDialogFragment
import immediate.crypto.trading.quantum.R

class DashboardFragment : Fragment() {

    private lateinit var cryptoView: View
    private val apiUrl1 =
        "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=btc"
    private val apiUrl2 =
        "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=eth"
    private val apiUrl3 =
        "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=ltc"
    private val apiUrl4 =
        "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd"
    private val apiUrl5 =
        "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=eur"
    private val apiUrl6 =
        "https://api.coingecko.com/api/v3/simple/price?ids=dogecoin&vs_currencies=usd"
    var btcRate = 1.0
    var ethRate = 18.97
    var ltcRate = 579.91
    var usdRate = 41933.0
    var eurRate = 38951.0
    var dogeRate = 451415.30719523

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cryptoView = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return cryptoView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*CoroutineScope(Dispatchers.IO).launch {
            fetchCryptoData1()
            fetchCryptoData2()
            fetchCryptoData3()
            fetchCryptoData4()
            fetchCryptoData5()
            fetchCryptoData6()
        }*/

        val bitcoinRateTextView = cryptoView.findViewById<TextView>(R.id.bitcoinbtc)
        bitcoinRateTextView.text = "$btcRate"
        val ethereumRateTextView = cryptoView.findViewById<TextView>(R.id.ethereumbtc)
        ethereumRateTextView.text = "$ethRate"
        val litecoinRateTextView = cryptoView.findViewById<TextView>(R.id.litecoinbtc)
        litecoinRateTextView.text = "$ltcRate"
        val usdRateTextView = cryptoView.findViewById<TextView>(R.id.usdbtc)
        usdRateTextView.text = "$usdRate"
        val eurRateTextView = cryptoView.findViewById<TextView>(R.id.eurbtc)
        eurRateTextView.text = "$eurRate"
        val dogeRateTextView = cryptoView.findViewById<TextView>(R.id.dogecoinbtc)
        dogeRateTextView.text = "$dogeRate"

        val ibtc = cryptoView.findViewById<ImageView>(R.id.ibtc)
        val ieth = cryptoView.findViewById<ImageView>(R.id.ieth)
        val iltc = cryptoView.findViewById<ImageView>(R.id.iltc)
        val iusd = cryptoView.findViewById<ImageView>(R.id.iusd)
        val ieur = cryptoView.findViewById<ImageView>(R.id.ieur)
        val idoge = cryptoView.findViewById<ImageView>(R.id.idoge)
        ibtc.setOnClickListener {
            val text = "Bitcoin - a decentralized digital cryptocurrency, often referred to as BTC, that allows peer-to-peer transactions on a blockchain network, created in 2009 by an anonymous entity known as Satoshi Nakamoto."
            val dialogFragment = PopupDialogFragment.newInstance(text)
            dialogFragment.show(childFragmentManager, "popup_fragment")
        }
        ieth.setOnClickListener {
            val text = "Ethereum is an open-source, blockchain-based platform that enables the creation and execution of smart contracts and decentralized applications (DApps). It features its own cryptocurrency called Ether (ETH) and is known for its versatility in building decentralized systems and services."
            val dialogFragment = PopupDialogFragment.newInstance(text)
            dialogFragment.show(childFragmentManager, "popup_fragment")
        }
        iltc.setOnClickListener {
            val text = "Litecoin is a peer-to-peer cryptocurrency that was created as a \"lite\" version of Bitcoin. It offers fast transaction confirmation times and low transaction fees. Litecoin is often used for small transactions and as a testing ground for new blockchain technologies."
            val dialogFragment = PopupDialogFragment.newInstance(text)
            dialogFragment.show(childFragmentManager, "popup_fragment")
        }
        iusd.setOnClickListener {
            val text = "The US Dollar is the official currency of the United States. It is the world's primary reserve currency and is used as a standard currency in international trade. The symbol for the US Dollar is \"\$.\""
            val dialogFragment = PopupDialogFragment.newInstance(text)
            dialogFragment.show(childFragmentManager, "popup_fragment")
        }
        ieur.setOnClickListener {
            val text = "The Euro is the official currency of the Eurozone, which consists of 19 of the 27 European Union member states. It is the second most traded currency in the world after the US Dollar. The symbol for the Euro is \"€.\""
            val dialogFragment = PopupDialogFragment.newInstance(text)
            dialogFragment.show(childFragmentManager, "popup_fragment")
        }
        idoge.setOnClickListener {
            val text = "Dogecoin is a cryptocurrency that started as a meme and has gained popularity for its friendly community and low transaction fees. It features the Shiba Inu dog from the \"Doge\" meme as its logo. Dogecoin is often used for tipping and small online transactions."
            val dialogFragment = PopupDialogFragment.newInstance(text)
            dialogFragment.show(childFragmentManager, "popup_fragment")
        }
    }

    /*@OptIn(ExperimentalCoroutinesApi::class)
    suspend fun Call.await(): Response {
        return suspendCancellableCoroutine { continuation ->
            enqueue(object : Callback {
                override fun onResponse(call: Call, response: Response) {
                    continuation.resume(response)
                }

                override fun onFailure(call: Call, e: IOException) {
                    continuation.resumeWithException(e)
                }
            })

            continuation.invokeOnCancellation {
                try {
                    cancel()
                } catch (ex: Exception) {
                }
            }
        }
    }
    private suspend fun fetchCryptoData1() {
        val client1 = OkHttpClient()
        val request1 = Request.Builder()
            .url(apiUrl1)
            .build()

        val response1 = client1.newCall(request1).await()
        val jsonData1 = response1.body?.string()
        parseCryptoData1(jsonData1)
    }

    private fun parseCryptoData1(jsonData1: String?) {
        val jsonObject1 = JSONObject(jsonData1)
        btcRate = jsonObject1.getJSONObject("bitcoin").getDouble("btc")
    }

    private suspend fun fetchCryptoData2() {
        val client2 = OkHttpClient()
        val request2 = Request.Builder()
            .url(apiUrl2)
            .build()

        val response2 = client2.newCall(request2).await()
        val jsonData2 = response2.body?.string()
        parseCryptoData2(jsonData2)
    }

    private fun parseCryptoData2(jsonData2: String?) {
        val jsonObject2 = JSONObject(jsonData2)

        ethRate = jsonObject2.getJSONObject("bitcoin").getDouble("eth")

    }

    private suspend fun fetchCryptoData3() {
        val client3 = OkHttpClient()
        val request3 = Request.Builder()
            .url(apiUrl3)
            .build()

        val response3 = client3.newCall(request3).await()
        val jsonData3 = response3.body?.string()
        parseCryptoData3(jsonData3)
    }

    private fun parseCryptoData3(jsonData3: String?) {
        val jsonObject3 = JSONObject(jsonData3)
        ltcRate = jsonObject3.getJSONObject("bitcoin").getDouble("ltc")
    }
    private fun fetchCryptoData4() {
        val client4 = OkHttpClient()
        val request4 = Request.Builder()
            .url(apiUrl4)
            .build()

        val response4 = client4.newCall(request4).execute()
        val jsonData4 = response4.body?.string()
        parseCryptoData4(jsonData4)
    }

    private fun parseCryptoData4(jsonData4: String?) {
        val jsonObject4 = JSONObject(jsonData4)
        usdRate = jsonObject4.getJSONObject("bitcoin").getDouble("usd")
    }
    private suspend fun fetchCryptoData5() {
        val client5 = OkHttpClient()
        val request5 = Request.Builder()
            .url(apiUrl5)
            .build()

        val response5 = client5.newCall(request5).await()
        val jsonData5 = response5.body?.string()
        parseCryptoData5(jsonData5)
    }

    private fun parseCryptoData5(jsonData5: String?) {
        val jsonObject5 = JSONObject(jsonData5)
        eurRate = jsonObject5.getJSONObject("bitcoin").getDouble("eur")
    }
    private suspend fun fetchCryptoData6() {
        val client61 = OkHttpClient()
        val request61 = Request.Builder()
            .url(apiUrl6)
            .build()
        val client62 = OkHttpClient()
        val request62 = Request.Builder()
            .url(apiUrl4)
            .build()

        val response61 = client61.newCall(request61).await()
        val jsonData61 = response61.body?.string()
        val response62 = client62.newCall(request62).await()
        val jsonData62 = response62.body?.string()
        parseCryptoData6(jsonData61, jsonData62)
    }

    private fun parseCryptoData6(jsonData61: String?, jsonData62: String?) {
        val jsonObject61 = JSONObject(jsonData61)
        val jsonObject62 = JSONObject(jsonData62)
        dogeRate = (jsonObject62.getJSONObject("bitcoin").getDouble("usd"))/(jsonObject61.getJSONObject("dogecoin").getDouble("usd"))
    }*/
}
