package immediate.crypto.trading.quantum.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import immediate.crypto.trading.quantum.R

class NotificationsFragment : Fragment() {
    private lateinit var cryptoView: View
    var ip = 0
    var itt = 0
    var ir = 0
    var ep = 0
    var et = 0
    var er = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        cryptoView = inflater.inflate(R.layout.fragment_notifications, container, false)
        return cryptoView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val income = cryptoView.findViewById<ImageView>(R.id.income)
        val expenses = cryptoView.findViewById<ImageView>(R.id.expenses)
        val plus = cryptoView.findViewById<ImageView>(R.id.plus)
        val plus2 = cryptoView.findViewById<ImageView>(R.id.plus2)
        val plus3 = cryptoView.findViewById<ImageView>(R.id.plus3)
        val oper1 = cryptoView.findViewById<TextView>(R.id.oper1)
        val oper2 = cryptoView.findViewById<TextView>(R.id.oper2)
        val oper3 = cryptoView.findViewById<TextView>(R.id.oper3)
        val paste = cryptoView.findViewById<EditText>(R.id.paste)
        val paste2 = cryptoView.findViewById<EditText>(R.id.paste2)
        val paste3 = cryptoView.findViewById<EditText>(R.id.paste3)
        Toast.makeText(requireContext(), "Choose the type of operation", Toast.LENGTH_LONG).show()
        income.setOnClickListener {
            oper1.setText("$ip")
            oper2.setText("$itt")
            oper3.setText("$ir")
            paste.hint = "Income for products"
            paste2.hint = "Income for transport"
            paste3.hint = "Income for restaurants"
            if(paste.hint.toString()=="Income for products"){
                plus.setOnClickListener {
                    ip = paste.text.toString().toInt()
                }
                plus2.setOnClickListener {
                    itt = paste2.text.toString().toInt()
                }
                plus3.setOnClickListener {
                    ir = paste3.text.toString().toInt()
                }
            }
            if(paste.hint.toString()=="Expenses for products"){
                plus.setOnClickListener {
                    ep = paste.text.toString().toInt()
                }
                plus2.setOnClickListener {
                    et = paste2.text.toString().toInt()
                }
                plus3.setOnClickListener {
                    er = paste3.text.toString().toInt()
                }
            }
            Toast.makeText(requireContext(), "To confirm operation click to type of operation", Toast.LENGTH_LONG).show()
        }
        expenses.setOnClickListener {
            oper1.setText("$ep")
            oper2.setText("$et")
            oper3.setText("$er")
            paste.hint = "Expenses for products"
            paste2.hint = "Expenses for transport"
            paste3.hint = "Expenses for restaurants"
            if(paste.hint.toString()=="Income for products"){
                plus.setOnClickListener {
                    ip = paste.text.toString().toInt()
                    Toast.makeText(requireContext(), "To confirm operation click to type of operation", Toast.LENGTH_LONG).show()
                }
                plus2.setOnClickListener {
                    itt = paste2.text.toString().toInt()
                    Toast.makeText(requireContext(), "To confirm operation click to type of operation", Toast.LENGTH_LONG).show()
                }
                plus3.setOnClickListener {
                    ir = paste3.text.toString().toInt()
                    Toast.makeText(requireContext(), "To confirm operation click to type of operation", Toast.LENGTH_LONG).show()
                }
            }
            if(paste.hint.toString()=="Expenses for products"){
                plus.setOnClickListener {
                    ep = paste.text.toString().toInt()
                    Toast.makeText(requireContext(), "To confirm operation click to type of operation", Toast.LENGTH_LONG).show()
                }
                plus2.setOnClickListener {
                    et = paste2.text.toString().toInt()
                    Toast.makeText(requireContext(), "To confirm operation click to type of operation", Toast.LENGTH_LONG).show()
                }
                plus3.setOnClickListener {
                    er = paste3.text.toString().toInt()
                    Toast.makeText(requireContext(), "To confirm operation click to type of operation", Toast.LENGTH_LONG).show()
                }
            }
        }
        if(paste.hint.toString()=="Income for products"){
            plus.setOnClickListener {
                ip = paste.text.toString().toInt()
                Toast.makeText(requireContext(), "To confirm operation click to type of operation", Toast.LENGTH_LONG).show()
            }
            plus2.setOnClickListener {
                itt = paste2.text.toString().toInt()
                Toast.makeText(requireContext(), "To confirm operation click to type of operation", Toast.LENGTH_LONG).show()
            }
            plus3.setOnClickListener {
                ir = paste3.text.toString().toInt()
                Toast.makeText(requireContext(), "To confirm operation click to type of operation", Toast.LENGTH_LONG).show()
            }
        }
        if(paste.hint.toString()=="Expenses for products"){
            plus.setOnClickListener {
                ep = paste.text.toString().toInt()
                Toast.makeText(requireContext(), "To confirm operation click to type of operation", Toast.LENGTH_LONG).show()
            }
            plus2.setOnClickListener {
                et = paste2.text.toString().toInt()
                Toast.makeText(requireContext(), "To confirm operation click to type of operation", Toast.LENGTH_LONG).show()
            }
            plus3.setOnClickListener {
                er = paste3.text.toString().toInt()
                Toast.makeText(requireContext(), "To confirm operation click to type of operation", Toast.LENGTH_LONG).show()
            }
            Toast.makeText(requireContext(), "To confirm operation click to type of operation", Toast.LENGTH_LONG).show()
        }
    }
}