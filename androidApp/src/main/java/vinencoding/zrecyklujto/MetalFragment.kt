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
 * Use the [MetalFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MetalFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val metal_tips = arrayOf(
        "Informace, podle kterých byste se měli při třídění odpadu řídit, naleznete přímo na barevných sběrných nádobách. Na kontejnerech jsou umístěny nálepky, které přesně popisují, co do nich patří a co ne. O místních podmínkách systému sběru tříděného odpadu vždy rozhoduje obec, proto se všude třídí jiným způsobem.",
        "Kovové obaly a hliníková víčka odhazujte, do sběrných nádob nebo pytlů určených pro sběr kovů. Větší množství můžete odnést do sběrného dvora nebo výkupny kovů.",
        "Nově lze do speciálně označených žlutých kontejnerů házet kromě plastu také kov. Materiály se pak oddělí v dotřiďovací lince.",
        "V Praze lze použité kávové kapsle (hliníkové) vyhodit do veřejných sběrných nádob na kovové obaly.",
        "Kovy je možné vytřídit např. také ve sběrných dvorech, v některých obcích do nádob na třídění odpadu s jinými odpady (viz samolepky na kontejnerech, které informují o specificích třídění odpadů v dané obci) nebo např. v rámci speciálních akcí, jako jsou tzv. kovové neděle.",
        "Do kontejneru na kovy patří šroubovací uzávěry od nápojů i zavařovacích sklenic, nápojové plechovky, hliníková víčka od jogurtů (nikoliv z pokoveného plastu), hliníkové obaly od potravin (ne kombinované), fólie od tavených sýrů či čokolád, prázdné kovové tuby od kosmetiky (pasty a krémů), kovové nádoby od aerosolů po kompletním vyprázdnění (spreje od laků na vlasy, šlehaček, antiprespirantů a deodorantů apod.)",
        "Na sběrné dvory lze kromě těchto menších odpadů odvážet i další kovové odpady – trubky, roury, plechy, hrnce, vany, kola a další objemnější předměty. Samostatnou kapitolou jsou kovové elektrospotřebiče, které lze na sběrných dvorech odkládat pouze kompletní.",
        "Do kontejnerů na ulici nepatří plechovky od barev a jiných nebezpečných látek, tlakové nádoby se zbytky nebezpečných látek, ani domácí spotřebiče a jiná vysloužilá zařízení složená z více materiálů. Tyto druhy odpadů se třídí na sběrných dvorech samostatně. Nepatří do nich ani těžké nebo toxické kovy, jakou jsou olovo či rtuť. Samostatnou kapitolu pak tvoří autovraky, jež převezmou a doklad o ekologické likvidaci vystaví na vrakovištích.",
        "Výhodou používání obalů vyrobených z kovů je, že je můžeme recyklovat za splnění určitých podmínek donekonečna, podobně jako je tomu v případě skla (třeba takový papír má životní cyklus omezený na 5–7 použití). I v případě zpracování kovového odpadu při výrobě nových produktů šetříme nejen primární suroviny potřebné při výrobě, ale také např. energie a emise."
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
        val view = inflater.inflate(R.layout.fragment_metal, container, false)

        val linearLayout = view.findViewById<LinearLayout>(R.id.tipLinearLayout)

        val header = TextView(view.context)
        header.text = "Kontejner na kov"
        header.setTextAppearance(R.style.TipHeadingTextView)
        header.setBackgroundResource(R.color.colorGreyMetal)
        header.setPadding(15,20,15,20)

        linearLayout.addView(header)

        for (tip in metal_tips){

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
         * @return A new instance of fragment MetalFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MetalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}