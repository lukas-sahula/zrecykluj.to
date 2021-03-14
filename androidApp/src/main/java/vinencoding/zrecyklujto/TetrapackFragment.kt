package vinencoding.zrecyklujto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TetrapackFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TetrapackFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val tetrapack_tips = arrayOf(
        "Papírové krabice například od džusů nebo mléka nazýváme nápojovými kartony. Organizovaný sběr těchto obalů probíhá již v mnoha městech a obcích v celé ČR. Sběrné nádoby, do kterých lze použitý nápojový karton odkládat, jsou označeny speciální oranžovou nálepkou s označením Nápojový karton. V některých obcích je sbírán tento odpad do oranžových pytlů. O způsobu sběru nápojových kartonů ve vaší obci/městě se můžete informovat na obecním nebo městském úřadě (odbor životního prostředí nebo příslušný pracovník mající na starosti odpadové hospodářství).",
        "Z nápojového kartonu není nutné odtrhnout umělohmotný uzávěr. Pokud ve vaší obci probíhá sběr nápojových kartonů, prázdný karton pouze vypláchněte vodou, stlačte a i s víčkem odhoďte do kontejneru nebo oranžového pytle, který je ve vaší obci pro tento odpad určen.",
        "Sešlapávaní, mačkání a kroucení PET lahví a nápojových kartonů je velmi vhodné jak pro skladování, tak i následnou přepravu. Takto zmenšených odpadů se do kontejneru vejde cca 4x více. Některé kontejnery na nápojový karton jsou navíc konstruovány tak, aby do nich nešlo vhodit nezmáčknutý obal. Sníží se tak přepravní náklady.",
        "Do kontejneru na nápojový karton nepatří polohliníkové sáčky (např. od koření).",
        "Nápojové kartony nemusíme vymývat, stačí je důkladně vyprázdnit.",
        "Aseptický nápojový karton, který má recyklační značku C/PAP/ALU 84, je vyroben ze tří druhů materiálu, a to ze směsi papíru, plastu (cca 20 % polyethylenu) a hliníku (cca 5 %). Tento druh nápojových kartonů může být označen i jako UHT/trvanlivé výrobky.",
        "Neaseptický nápojový karton, který má recyklační značku C/PAP 81, je vyroben ze dvou druhů materiálů, a to ze směsi papíru a plastu. Používá se nejčastěji k balení pasterovaných výrobků."
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
        val view = inflater.inflate(R.layout.fragment_tetrapack, container, false)

        val linearLayout = view.findViewById<LinearLayout>(R.id.tipLinearLayout)

        val header = TextView(view.context)
        header.text = "Kontejner na nápojové kartony"
        header.setTextAppearance(R.style.TipHeadingTextView)
        header.setBackgroundResource(R.color.colorOrangeTetra)
        header.setPadding(15,20,15,20)

        linearLayout.addView(header)

        for (tip in tetrapack_tips){

            val tipTextView = TextView(view.context)
            tipTextView.text = tip
            tipTextView.setTextAppearance(R.style.TipTextView)
            tipTextView.setPadding(20,20,20,20)

            linearLayout.addView(tipTextView)
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
         * @return A new instance of fragment TetrapackFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TetrapackFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}