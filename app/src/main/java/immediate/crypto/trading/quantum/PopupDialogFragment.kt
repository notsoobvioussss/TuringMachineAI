package immediate.crypto.trading.quantum

import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class PopupDialogFragment : DialogFragment() {
    companion object {
        fun newInstance(text: String): PopupDialogFragment {
            val fragment = PopupDialogFragment()
            val args = Bundle()
            args.putString("text", text)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.popup_layout)

        val text = arguments?.getString("text")
        val textView = dialog.findViewById<TextView>(R.id.popupText)
        textView.text = text
        return dialog
    }

}
