package vinencoding.zrecyklujto.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import vinencoding.zrecyklujto.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GlassFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GlassFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val glass_tips = arrayOf(
        "Informace, podle kterých byste se měli při třídění odpadu řídit, naleznete přímo na barevných sběrných nádobách. Na kontejnerech jsou umístěny nálepky, které přesně popisují, co do nich patří a co ne. O místních podmínkách systému sběru tříděného odpadu vždy rozhoduje obec, proto se všude třídí jiným způsobem.",
        "Sklo se vhazuje do zeleného nebo bílého kontejneru. Pokud jsou k dispozici oba, je důležité třídit sklo i podle barev: Barevné do zeleného, čiré do bílého. Pokud máte kontejner na sklo jen jeden, pak do něj dávejte sklo bez ohledu na barvu. Vytříděné sklo není nutné rozbíjet, bude se dále třídit! Díky svým vlastnostem se dá skleněný odpad recyklovat do nekonečna.",
        "Do zeleného kontejneru můžeme vhazovat barevné sklo, například lahve od vína, alkoholických i nealkoholických nápojů. Vhodit do zeleného kontejneru můžete také tabulové sklo z oken a ze dveří.",
        "Do bílého kontejneru vhazujte sklo čiré, tedy sklenice od kečupů, marmelád či zavařenin a rozbité skleničky.",
        "Do těchto nádob nepatří keramika a porcelán. Nepatří sem ani autosklo, zrcadla nebo třeba drátované sklo, zlacená a pokovená skla. Varné a laboratorní sklo, stejně jako sklokeramika do zeleného kontejneru také nepatří. Vratné zálohované sklo vracejte zpět do obchodu.",
        "Varné a laboratorní sklo díky své vyšší teplotě tavení nepatří do běžných kontejnerů na ulicích. Pokud se Vám rozbije například skleněná varná konvice, hoďte ji do směsného odpadu. V případě většího množství tohoto skla využijte sběrný dvůr.",
        "O skle mluvíme jako o materiálu minulosti, současnosti a budoucnosti právě proto, že jej lze recyklovat donekonečna.",
        "Na třídičce umí: optická třídička prosvítit střepy a nevhodné položky odstranit. Poradí si i s oddělením kovů od skla – proto nevadí víčka. Laserová čidla umí střepy rozlišit podle barev.",
        "Etikety, ale ani zbytky obsahu při recyklaci nevadí, protože při teplotě tavení (cca 1 600 °C) shoří.",
        "Největší úskalí při tavení skla představují materiály, které se běžnému sklu podobají. Nesprávně do kontejnerů na sklo lidé třídí například porcelán, bezpečnostní sklo, autosklo, sklokeramiku nebo třeba varné sklo apod. Takové materiály mají úplně jiné tavicí nároky – vyžadují vyšší teploty k roztavení. Proto existují speciální rentgeny, které umí i tyto materiály odhalit a ty tak mohou být od „běžného“ skla odděleny."
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
        val view = inflater.inflate(R.layout.fragment_glass, container, false)

        val linearLayout = view.findViewById<LinearLayout>(R.id.tipLinearLayout)

        val header = TextView(view.context)
        header.text = "Kontejner na sklo"
        header.setTextAppearance(R.style.TipHeadingTextView)
        header.setBackgroundResource(R.color.colorGreenGlass)
        header.setPadding(15,20,15,20)

        linearLayout.addView(header)

        for (tip in glass_tips){

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
         * @return A new instance of fragment GlassFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GlassFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}