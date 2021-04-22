package vinencoding.zrecyklujto

import androidx.cardview.widget.CardView
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.TextView
import android.widget.LinearLayout
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import androidx.navigation.Navigation


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
        "2;PE-HD;Vysokohustotní (lineární) polyetylen (HDPE, PE-HD);kontejner na plasty;Pl",
        "3;PVC;Polyvinylchlorid (PVC, V);sběrný dvůr;Va",
        "4;LDPE;Nízkohustotní (rozvětvený) polyetylen (LDPE, PE-LD);kontejner na plasty;Pl",
        "5;PP;Polypropylen (PP);kontejner na plasty;Pl",
        "6;PS;Polystyren (PS);kontejner na plasty;Pl",
        "7;O;Ostatní plasty (O, OTHER);sběrný dvůr;Va",
        "20;PAP;Vlnitá lepenka (PAP);kontejner na papír;Pa",
        "21;PAP;Hladká lepenka (PAP);kontejner na papír;Pa",
        "22-39;PAP;Papír (PAP);kontejner na papír;Pa",
        "40;Fe;Ocel (Fe);kontejner na kovy, sběrný dvůr;Me",
        "41;ALU;Hliník (ALU);kontejner na kovy, sběrný dvůr;Me",
        "42-49; ;Ostatní kovy;kontejner na kovy, sběrný dvůr;Me",
        "50;FOR;Dřevo (FOR);sběrný dvůr;Va",
        "51;FOR;Korek (FOR);sběrný dvůr;Va",
        "52-59;FOR;Ostatní dřevo (FOR);sběrný dvůr;Va",
        "60;TEX;Bavlna (TEX);kontejner na textil, sběrný dvůr;Va",
        "61;TEX;Juta (TEX);kontejner na textil, sběrný dvůr;Va",
        "62-69;TEX;Ostatní textilie (TEX);kontejner na textil, sběrný dvůr;Va",
        "70;GL;Bílé sklo (GL);kontejner na sklo;Gl",
        "71;GL;Zelené sklo (GL);kontejner na sklo;Gl",
        "72;GL;Hnědé sklo (GL);kontejner na sklo;Gl",
        "73-79;GL;Ostatní sklo (GL);kontejner na sklo;Gl",
        "81,84;C/PAP;Nápojový karton (C/PAP, C/PAP/ALU);kontejner na nápojové kartony;Te"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_decision_tree, container, false)

        val cardLinearLayout = view.findViewById<LinearLayout>(R.id.cardsLayout)

        val scale = resources.displayMetrics.density

        for (code in recycling_codes){
            val parts = code.split(";").toTypedArray()

            val numCode = parts[0]
            val strCode = parts[1]
            val header = parts[2]
            val description = parts[3]
            val type = parts[4]

            val card = CardView(view.context, null, R.style.BaseCardView)
            val params = LinearLayout.LayoutParams(-1, -1)
            params.setMargins(0,0,0, 32)
            card.layoutParams = params
            card.setPadding((16*scale).toInt())

            card.setOnClickListener {
                when (type) {
                    "Pl" -> Navigation.findNavController(view).navigate(R.id.action_decisionTreeFragment_to_plasticFragment)
                    "Pa" -> Navigation.findNavController(view).navigate(R.id.action_decisionTreeFragment_to_paperFragment)
                    "Me" -> Navigation.findNavController(view).navigate(R.id.action_decisionTreeFragment_to_metalFragment)
                    "Gl" -> Navigation.findNavController(view).navigate(R.id.action_decisionTreeFragment_to_glassFragment)
                    "Te" -> Navigation.findNavController(view).navigate(R.id.action_decisionTreeFragment_to_tetrapackFragment)
                    "Va" -> Navigation.findNavController(view).navigate(R.id.action_decisionTreeFragment_to_otherMaterialFragment)
                }
            }

            val cardContentLayout = LinearLayout(view.context)
            cardContentLayout.orientation = LinearLayout.HORIZONTAL

            val textLinearLayout = LinearLayout (view.context)
            textLinearLayout.orientation = LinearLayout.VERTICAL

            val symbolImageView = ImageView(view.context)
            symbolImageView.setImageResource(R.drawable.recycling_symbol)
            symbolImageView.layoutParams = LinearLayout.LayoutParams(126, 126)
            symbolImageView.id = id

            val textNumCode = TextView(card.context)
            textNumCode.text = numCode
            textNumCode.setTextAppearance(R.style.SymbolTextView)
            textNumCode.id = id
            textNumCode.gravity = Gravity.CENTER
            textNumCode.layoutParams = LinearLayout.LayoutParams(-1, -1)
            if (textNumCode.text.length > 2){
                textNumCode.setTextAppearance(R.style.SymbolTextViewSmaller)
                (textNumCode.layoutParams as LinearLayout.LayoutParams).apply{
                    topMargin = 45
                }
            }

            val textStrCode = TextView(card.context)
            textStrCode.text = strCode
            textStrCode.setTextAppearance(R.style.SymbolTextView)
            textStrCode.id = id
            textStrCode.gravity = Gravity.CENTER_HORIZONTAL

            val textViewHeader = TextView(card.context)
            textViewHeader.text = header
            textViewHeader.gravity = Gravity.TOP
            textViewHeader.setTextAppearance(R.style.HeadingTextView)
            textViewHeader.setPadding(20,0,0,30)

            val textViewDescription = TextView(card.context)
            textViewDescription.text = description
            textViewDescription.gravity = Gravity.BOTTOM
            textViewDescription.setTextAppearance(R.style.DescriptionTextView)
            textViewDescription.setPadding(20,10,0,0)

            when (type) {
                "Pl" -> card.setBackgroundResource(R.color.colorYellowPlastic)
                "Pa" -> card.setBackgroundResource(R.color.colorBluePaper)
                "Me" -> card.setBackgroundResource(R.color.colorGreyMetal)
                "Gl" -> card.setBackgroundResource(R.color.colorGreenGlass)
                "Te" -> card.setBackgroundResource(R.color.colorOrangeTetra)
            }

            val pictureLayout = LinearLayout(view.context)
            pictureLayout.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            pictureLayout.orientation = LinearLayout.VERTICAL

            val symbolLayout = FrameLayout(view.context)
            val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            symbolLayout.layoutParams = layoutParams
            layoutParams.setMargins(16)

            symbolLayout.addView(symbolImageView)
            symbolLayout.addView(textNumCode)
            pictureLayout.addView(symbolLayout)
            pictureLayout.addView(textStrCode)

            textLinearLayout.addView(textViewHeader)
            textLinearLayout.addView(textViewDescription)
            cardContentLayout.addView(pictureLayout)
            cardContentLayout.addView(textLinearLayout)
            card.addView(cardContentLayout)
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