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
 * Use the [PlasticFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlasticFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val plastic_tips = arrayOf(
        "Informace, podle kterých byste se měli při třídění odpadu řídit, naleznete přímo na barevných sběrných nádobách. Na kontejnerech jsou umístěny nálepky, které přesně popisují, co do nich patří a co ne. O místních podmínkách systému sběru tříděného odpadu vždy rozhoduje obec, proto se všude třídí jiným způsobem.",
        "Nádoba na třídění plastu by měla být vždy označena žlutou barvou a viditelnou nálepkou s informacemi. V některých obcích naleznete společné třídicí nádoby pro plast i nápojové kartony.",
        "PET láhve můžete do kontejneru vhazovat s etiketou i víčkem. Obojí bude při dalším zpracování automaticky odděleno. PET láhve sešlápněte, nasaďte víčko a to již neutahujte! Nesešlápnuté láhve jsou objemné a tím zdražují přepravu, komplikují manipulaci a recyklace se tak stává nákladnější.",
        "Pokud má PET lahev místo etikety tzv. shrink sleeve (rukávek/návlek zpravidla po celém těle lahve), je nutné tento návlek z lahve odstranit a vytřídit do kontejneru na plasty zvlášť. (Mohou být vyrobeny z jiných materiálů a zpracování společně s PET by pak nebylo možné).",
        "Kelímky od jogurtů a jiných potravin není třeba důkladně vymývat, drobné znečištění obalů nevadí. Stačí tedy, když potravinu důkladně dojíte nebo z kelímku pořádně vyškrábnete. Ale je lepší je lehce vypláchnout vlažnou vodou, protože při delším skladování doma, by mohly být cítit. Navíc mastné obaly či obaly se zbytky potravin omezují následnou recyklaci.",
        "Sešlapávaní, mačkání a kroucení PET lahví a nápojových kartonů je velmi vhodné jak pro skladování, tak i následnou přepravu. Takto zmenšených odpadů se do kontejneru vejde cca 4x více. Některé kontejnery na nápojový karton jsou navíc konstruovány tak, aby do nich nešlo vhodit nezmáčknutý obal. Sníží se tak přepravní náklady.",
        "Nově lze do speciálně označených žlutých kontejnerů házet kromě plastu také kov. Materiály se pak oddělí v dotřiďovací lince.",
        "Plastové obaly od CD, DVD nebo videokazet patří do plastů. DVD a videokazety odvezte nejlépe na sběrný dvůr. CD můžete v malém množství vyhodit do směsného odpadu, ve větším množství patří na sběrný dvůr.",
        "Obaly od kosmetiky patří do tříděného odpadu. Nejedná se o žádné nebezpečné látky, stačí tedy, když zbytky kosmetických přípravků jako jsou mýdla, šampony, krémy zcela spotřebujete. Do kontejneru na tříděný odpad pak můžete klidně prázdné obaly vhodit.",
        "Pokud obal od oleje pečlivě vymyjete teplou vodou s přípravkem na mytí nádobí, můžete jej vhodit do plastů. V případě, že tak neučiníte, vhazujte tento znečištěný obal do směsného odpadu. Olej totiž značně komplikuje následnou recyklaci tříděného odpadu.",
        "Do kontejneru na plast nepatří  mastné obaly se zbytky potravin nebo čistících přípravků, obaly od žíravin, barev a jiných nebezpečných látek, podlahové krytiny či novodurové trubky."
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
        val view = inflater.inflate(R.layout.fragment_plastic, container, false)

        val linearLayout = view.findViewById<LinearLayout>(R.id.tipLinearLayout)

        val header = TextView(view.context)
        header.text = "Kontejner na plast"
        header.setBackgroundResource(R.color.colorYellowPlastic)
        header.setTextAppearance(R.style.TipHeadingTextView)
        header.setPadding(15,20,15,20)

        linearLayout.addView(header)

        for (tip in plastic_tips){

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
         * @return A new instance of fragment PlasticFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlasticFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}