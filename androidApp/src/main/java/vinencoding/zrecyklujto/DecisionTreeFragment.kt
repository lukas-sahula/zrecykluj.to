package vinencoding.zrecyklujto

import android.content.Context
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.cardview.widget.CardView
import vinencoding.zrecyklujto.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [DecisionTreeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DecisionTreeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val recycling_codes = arrayOf(
        "1;PET;Polyethylentereftalát (PET, PETE);kontejner na plasty, kontejner na PET;Pl",
        "2;PE-HD;Vysokohustotní (lineární) polyetylen (HDPE, PE-HD);kontejner na plasty;Pa",
        //....
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_decision_tree, container, false)

        val cardLinearLayout = view.findViewById<LinearLayout>(R.id.cardsLayout)

        for (code in recycling_codes){
            val parts = code.split(";").toTypedArray();

            val numCode = parts[0]
            val strCode = parts[1]
            val header = parts[2]
            val description = parts[3]
            var type = parts[4]

            val card = CardView(view.context, null, R.style.BaseCardView)
            val textView = TextView(card.context)

            textView.text = numCode
            if (type == "Pl")
                card.setCardBackgroundColor(R.color.colorYellowPlastic)
            else if (type == "Pa")
                card.setCardBackgroundColor(R.color.colorBluePaper)

            card.addView(textView)
            cardLinearLayout.addView(card)
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DecisionTreeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DecisionTreeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}