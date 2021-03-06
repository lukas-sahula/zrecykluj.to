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
 * Use the [OtherMaterialFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OtherMaterialFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val mixed_waste_tips = arrayOf(
        "V domácnosti se nesmí vyhazovat do kanalizace látky infekční a karcinogenní, léčiva, látky ropné, látky omamné a hořlavé, jedy, žíraviny, výbušniny, pesticidy, organická rozpouštědla, látky působící změnu barvy vody, hygienické potřeby, pevné odpady včetně kuchyňských",
        "Tuby od zubní pasty patří do směsného odpadu. Mohou obsahovat hliníkovou vrstvu. Navíc většinou zůstává určité množství pasty v tubě, takže se jedná o znečištěný obal.",
        "Plastové obaly od CD, DVD nebo videokazet patří do plastů. DVD a videokazety odvezte nejlépe na sběrný dvůr. CD můžete v malém množství vyhodit do směsného odpadu, ve větším množství patří na sběrný dvůr.",
        "Pokud odpad nepatří do kontejneru na tříděný odpad, obecně lze říci, že pokud se nejedná o elektroodpad, baterie, světelné zařízení, nebezpečný a objemný odpad nebo o odpad, se kterým se musí nakládat zvláštním způsobem (např. zbytky léčiv), lze ho odložit do nádob na směsný odpad.",
        "Účtenky z termopapíru patří do směsného odpadu, protože v drtivé většině případů obsahuje látku Bisfenol.  Uvolněné látky pak znečišťují vodu v papírnách a dostávají se do papíroviny. Tyto účtenky lze tedy třídit pouze, pokud máme jistotu, že jsou fenol-free. Informaci o obsahu těchto látek však běžně na samotném termopapíru nedohledáme.",
        "Textil, pokud je nositelný, věnujte charitě nebo ho ve větším množství odevzdejte do sběrného dvora. V některých obcích, ale ne na celém území ČR, je i zaveden sběr textilu do nádob.",
        "Molitan v menším množství můžete hodit do směsného odpadu, ve větším množství patří do sběrného dvora.",
        "Elektroodpad patří na místa zpětného odběru jako jsou prodejny, kde jste elektro pořídili. Odnést je můžete  také na sběrný dvůr. Více informací k elektroodpadu naleznete např. na stránkách www.asekol.cz a www.elektrowin.cz",
        "Prázdné plastové obaly od kosmetiky vytřiďte do plastů, zbytky slijte a v menším množství je můžete vyhodit v pytlíku do směsného odpadu, ve větším množství odvezte na sběrný dvůr.",
        "Použité dětské pleny patří, stejně jako papírové kapesníky a dámské hygienické potřeby, do černého nebo šedého kontejneru na směsný odpad.",
        "Kazety i diskety patří do směsného odpadu, ve větším množství na sběrný dvůr. Papírové obaly se dají vytřídit do papíru a plastové do plastů.",
        "Řasenka je sice z plastu, ale je znečištěna zbytky barvy, proto ji vhazujte do směsného odpadu.",
        "U prosředků na hubení hmyzu se vždy řiďte pokyny na obalu. Ve většině případů patří do nebezpečného odpadu, odvezte je proto na sběrný dvůr nebo do mobilní sběrny nebezpečného odpadu. O nebezpečné vlastnosti výrobku  informuje oranžová výstražná značka na obalu."
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
        val view = inflater.inflate(R.layout.fragment_other_material, container, false)

        val linearLayout = view.findViewById<LinearLayout>(R.id.tipLinearLayout)

        val header = TextView(view.context)
        header.text = "Kontejner na směsný odpad, sběrný dvůr"
        header.setTextAppearance(R.style.TipHeadingTextView)
        header.setPadding(15,20,15,20)

        linearLayout.addView(header)

        for (tip in mixed_waste_tips){

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
         * @return A new instance of fragment OtherMaterialFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OtherMaterialFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}