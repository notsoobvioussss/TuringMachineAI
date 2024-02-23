package immediate.crypto.trading.quantum.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import immediate.crypto.trading.quantum.PopupDialogFragment
import immediate.crypto.trading.quantum.R
import org.json.JSONObject
import java.lang.Math.abs
import java.text.DecimalFormat
import kotlin.random.Random

class HomeFragment : Fragment() {

    private lateinit var cryptoView: View
    private val apiUrl1 = "https://api.coingecko.com/api/v3/simple/price?ids=dogecoin,bitcoin,litecoin,ethereum&vs_currencies=usd"
    private val apiUrl2 = "https://api.coingecko.com/api/v3/simple/price?ids=dogecoin,bitcoin,litecoin,ethereum&vs_currencies=eur"
    private var vl1 = 0
    private var vl2 = 0
    var dogecoinRateu = 0.092701
    var bitcoinRateu = 41933.0
    var litecoinRateu = 72.31
    var etheriumRateu = 2210.63
    var dogecoinRatee = 0.086059
    var bitcoinRatee = 38951.0
    var litecoinRatee = 67.07
    var etheriumRatee = 2053.48

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        cryptoView = inflater.inflate(R.layout.fragment_home, container, false)
        return cryptoView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val up1 = cryptoView.findViewById<ImageView>(R.id.up1)
        val up2 = cryptoView.findViewById<ImageView>(R.id.up2)
        val down1 = cryptoView.findViewById<ImageView>(R.id.down1)
        val down2 = cryptoView.findViewById<ImageView>(R.id.down2)
        val h24 = cryptoView.findViewById<ImageView>(R.id.h24)
        val w1 = cryptoView.findViewById<ImageView>(R.id.w1)
        val m1 = cryptoView.findViewById<ImageView>(R.id.m1)
        val m6 = cryptoView.findViewById<ImageView>(R.id.m6)
        val y1 = cryptoView.findViewById<ImageView>(R.id.y1)
        val y3 = cryptoView.findViewById<ImageView>(R.id.y3)
        val per1 = cryptoView.findViewById<TextView>(R.id.per1)
        val per2 = cryptoView.findViewById<TextView>(R.id.per2)
        val per3 = cryptoView.findViewById<TextView>(R.id.per3)
        val val2 = cryptoView.findViewById<TextView>(R.id.val2)
        val val1 = cryptoView.findViewById<TextView>(R.id.val1)
        val btc1 = cryptoView.findViewById<ImageView>(R.id.btc1)
        val usd1 = cryptoView.findViewById<ImageView>(R.id.usd1)
        val kurs = cryptoView.findViewById<TextView>(R.id.kurs)
        val opiss1 = cryptoView.findViewById<TextView>(R.id.opiss1)
        val opiss2 = cryptoView.findViewById<TextView>(R.id.opiss2)
        val opiss3 = cryptoView.findViewById<TextView>(R.id.opiss3)
        val opiss4 = cryptoView.findViewById<TextView>(R.id.opiss4)
        opiss1.setText("Click to read the first article")
        opiss2.setText("Click to read the second article")
        opiss3.setText("Click to read the third article")
        opiss4.setText("Click to read the fourth article")
        var r1 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
        var r2 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
        var r3 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
        per1.setText("$r1%")
        per2.setText("$r2%")
        per3.setText("$r3%")
        vl2 %= 2
        vl1 %= 4
        kurs.setText("$bitcoinRateu")
        h24.setOnClickListener {
            var r1 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            var r2 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            var r3 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            per1.setText("$r1%")
            per2.setText("$r2%")
            per3.setText("$r3%")
        }
        w1.setOnClickListener {
            var r1 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            var r2 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            var r3 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            per1.setText("$r1%")
            per2.setText("$r2%")
            per3.setText("$r3%")
        }
        m1.setOnClickListener {
            var r1 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            var r2 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            var r3 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            per1.setText("$r1%")
            per2.setText("$r2%")
            per3.setText("$r3%")
        }
        m6.setOnClickListener {
            var r1 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            var r2 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            var r3 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            per1.setText("$r1%")
            per2.setText("$r2%")
            per3.setText("$r3%")
        }
        y1.setOnClickListener {
            var r1 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            var r2 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            var r3 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            per1.setText("$r1%")
            per2.setText("$r2%")
            per3.setText("$r3%")
        }
        y3.setOnClickListener {
            var r1 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            var r2 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            var r3 = DecimalFormat("#.#").format(Random.nextDouble(from = 5.0, until = 15.0))
            per1.setText("$r1%")
            per2.setText("$r2%")
            per3.setText("$r3%")
        }
        up1.setOnClickListener {
            vl1++
            updateCryptoData()
        }
        down1.setOnClickListener {
            vl1--
            updateCryptoData()
        }
        up2.setOnClickListener {
            vl2++
            updateCryptoData()
        }
        down2.setOnClickListener {
            vl2--
            updateCryptoData()
        }
        opiss1.setOnClickListener {
            val text = "Bitcoin and other large-cap cryptocurrencies have been consistently declining since the beginning of the week, but it was the second most capitalised coin, Ethereum (ETH), that lost more value than any other asset in the top ten.\n" +
                    "On the night of 13 October, the price of ETH fell to as low as \$1523 at one point. Earlier, the coin was traded at this level in May this year. As of 11:00 Moscow time, the ETH rate is \$1548 paired with the Tether USD (USDT) stablecoin on the Binance exchange, a drop of 5% over the past seven days."
            val dialogFragment = PopupDialogFragment.newInstance(text)
            dialogFragment.show(childFragmentManager, "popup_fragment")
        }
        opiss2.setOnClickListener {
            val text = "USDT steiblcoin issuer Tether will appoint its long-time CTO Paolo Ardoino as CEO, The Block writes. He will take up the new position in December, while the company's current CEO Jean-Louis Van der Velde will move into an advisory role.\n" +
                    "Van der Velde will remain head of cryptocurrency exchange Bitfinex. At the same time, Ardoino will remain CTO of Bitfinex and Chief Strategy Officer of Holepunch, a platform for building decentralised applications backed by Bitfinex, Tether and Hypercore."
            val dialogFragment = PopupDialogFragment.newInstance(text)
            dialogFragment.show(childFragmentManager, "popup_fragment")
        }
        opiss3.setOnClickListener {
            val text = "Ethereum's (ETH) share of the total \$1.09 trillion cryptocurrency market capitalisation has fallen from 18.4% at the start of the year to the current 17.8%, according to CoinMarketCap. At the same time, bitcoin's dominance rose from 40 per cent to 50.3 per cent.\n" +
                    "The ETH exchange rate fell below \$1.6k and hit its lowest in almost a month - the asset last traded around \$1.5k on 12 September. Some of the analysts interviewed by business publications call market participants' disappointment with Ethereum the reason for the growth of ETH share."
            val dialogFragment = PopupDialogFragment.newInstance(text)
            dialogFragment.show(childFragmentManager, "popup_fragment")
        }
        opiss4.setOnClickListener {
            val text = "Long-term investors continue to actively accumulate bitcoins, contributing to the market's declining liquidity, researchers at analyst firm Glassnode stated in a report.\n" +
                    "The company's proprietary metrics showing changes in the net position of long-term holders of the cryptocurrency indicate that long-term investors or crypto wallets with a coin ownership history of at least 155 days are accumulating up to 50,000 BTC (\$1.35 billion at the October 11 exchange rate) per month."
            val dialogFragment = PopupDialogFragment.newInstance(text)
            dialogFragment.show(childFragmentManager, "popup_fragment")
        }
         CoroutineScope(Dispatchers.IO).launch {
            fetchCryptoData()
        }
    }
    private fun updateCryptoData() {
            val val2 = cryptoView.findViewById<TextView>(R.id.val2)
            val val1 = cryptoView.findViewById<TextView>(R.id.val1)
            val btc1 = cryptoView.findViewById<ImageView>(R.id.btc1)
            val usd1 = cryptoView.findViewById<ImageView>(R.id.usd1)
            val kurs = cryptoView.findViewById<TextView>(R.id.kurs)
            vl2 %= 2
            vl1 %= 4
            if (vl2 == 0) {
                val2.setText("USD")
                usd1.setImageResource(R.drawable.usd)
                vl1 %= 4
                if (abs(vl1) == 0) {
                    val1.setText("BTC")
                    btc1.setImageResource(R.drawable.bitcoin)
                    kurs.setText("$bitcoinRateu")
                } else if (abs(vl1) == 1) {
                    val1.setText("ETH")
                    btc1.setImageResource(R.drawable.etherium)
                    kurs.setText("$etheriumRateu")
                } else if (abs(vl1) == 2) {
                    val1.setText("LTC")
                    btc1.setImageResource(R.drawable.litecoin)
                    kurs.setText("$litecoinRateu")
                } else if(abs(vl1) == 3) {
                    val1.setText("DOGE")
                    btc1.setImageResource(R.drawable.dogecoin)
                    kurs.setText("$dogecoinRateu")
                }
                else{
                    null
                }
            }
            else {
                val2.setText("EUR")
                usd1.setImageResource(R.drawable.eur)
                if (abs(vl1) == 0) {
                    val1.setText("BTC")
                    btc1.setImageResource(R.drawable.bitcoin)
                    kurs.setText("$bitcoinRatee")
                } else if (abs(vl1) == 1) {
                    val1.setText("ETH")
                    btc1.setImageResource(R.drawable.etherium)
                    kurs.setText("$etheriumRatee")
                } else if (abs(vl1) == 2) {
                    val1.setText("LTC")
                    btc1.setImageResource(R.drawable.litecoin)
                    kurs.setText("$litecoinRatee")
                } else if (abs(vl1) == 3){
                    val1.setText("DOGE")
                    btc1.setImageResource(R.drawable.dogecoin)
                    kurs.setText("$dogecoinRatee")
                }
                else{
                    null
                }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
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

    private suspend fun fetchCryptoData() {
        val client1 = OkHttpClient()
        val request1 = Request.Builder()
            .url(apiUrl1)
            .build()
        val client2 = OkHttpClient()
        val request2 = Request.Builder()
            .url(apiUrl2)
            .build()

        val response1 = client1.newCall(request1).await()
        val jsonData1 = response1.body?.string()
        val response2 = client2.newCall(request2).await()
        val jsonData2 = response2.body?.string()
        parseCryptoData(jsonData1, jsonData2)
    }


    private fun parseCryptoData(jsonData1: String?, jsonData2: String?) {
        val jsonObject1 = JSONObject(jsonData1)
            dogecoinRateu = jsonObject1.getJSONObject("dogecoin").getDouble("usd")
            bitcoinRateu = jsonObject1.getJSONObject("bitcoin").getDouble("usd")
            litecoinRateu = jsonObject1.getJSONObject("litecoin").getDouble("usd")
            etheriumRateu = jsonObject1.getJSONObject("ethereum").getDouble("usd")

        val jsonObject2 = JSONObject(jsonData2)

        dogecoinRatee = jsonObject2.getJSONObject("dogecoin").getDouble("eur")
        bitcoinRatee = jsonObject2.getJSONObject("bitcoin").getDouble("eur")
        litecoinRatee = jsonObject2.getJSONObject("litecoin").getDouble("eur")
        etheriumRatee = jsonObject2.getJSONObject("ethereum").getDouble("eur")
    }
}
