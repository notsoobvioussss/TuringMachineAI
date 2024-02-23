package immediate.crypto.trading.quantum

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class AboutFragment : Fragment() {
    private lateinit var cryptoView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cryptoView = inflater.inflate(R.layout.fragment_about, container, false)
        return cryptoView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val about = cryptoView.findViewById<Button>(R.id.about)
        val cu = cryptoView.findViewById<Button>(R.id.cu)
        val pp = cryptoView.findViewById<Button>(R.id.pp)
        about.setText("About")
        cu.setText("Contact Us")
        pp.setText("Privacy Policy")
        about.setOnClickListener {
            val text = "This mobile application is designed to obtain up-to-date information on the relationship between different cryptocurrencies and real currencies: euro, dollar, pound.\n" +
                    "You can also see the cost of popular cryptocurrencies at a given time.\n" +
                    "It is possible to practice financial literacy and keep a list of expenses in 3 categories."
            val dialogFragment = PopupDialogFragment.newInstance(text)
            dialogFragment.show(childFragmentManager, "popup_fragment")
        }
        cu.setOnClickListener {
            val email = "turingmachineai@gmail.com"

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            }
            if (intent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(intent)
            }
            else{
                Toast.makeText(requireContext(), "Email app not found", Toast.LENGTH_SHORT).show()
            }
        }
        pp.setOnClickListener {
            startActivity(Intent(activity, PPActivity::class.java))
        }
       }
}