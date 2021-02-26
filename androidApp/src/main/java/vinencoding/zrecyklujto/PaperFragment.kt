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
 * Use the [PaperFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PaperFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val paper_tips = arrayOf(
        "Z časopisů a jiných dokumentů není třeba odstraňovat odstraňovat svorky. Při dalším zpracování papíru v papírnách se při rozvláknění a následném několikastupňovém třídění jsou odloučeny.",
        "Laminátový papír nepatří do papíru. Jinak do papíru patří papír všeho druhu, kromě polaminátovaného a povoskovaného papíru.",
        "Do modrého kontejneru vhazujte skartovaný papír stejně jako každý jiný papír, který není mokrý, mastný nebo jinak znečištěný. Tím se myslí i biologické nečistoty.",
        "Do kontejneru na papír můžete vhazovat obálky i s foliovým okénkem. Při dalším zpracování papíru v papírnách se při rozvláknění a následném několikastupňovém třídění jsou odloučeny Pokud však vyhazujete obálku s ochrannou bublinkovou fólií, tak tu je potřeba odstranit.",
        "Krabice rozložte nebo sešlápněte, aby v kontejneru zabíraly co nejméně místa. Pokud z nich odstraníte izolepy, části hodně zanesené lepidly, nic tím nezkazíte.",
        "Dokumenty jako bankovní výpisy či jiné, které obsahují vaše osobní data, vždy roztrhejte, aby nemohlo dojít k jejich zneužití.",
        "Účtenky z termopapíru patří do směsného odpadu, protože v drtivé většině případů obsahuje látku Bisfenol.  Uvolněné látky pak znečišťují vodu v papírnách a dostávají se do papíroviny. Tyto účtenky lze tedy třídit pouze, pokud máme jistotu, že jsou fenol-free. Informaci o obsahu těchto látek však běžně na samotném termopapíru nedohledáme.",
        "Ruličky od toaletního papíru a plata od vajec už se třídí. Dříve se správně házeli do směsného odpadu, recyklační technologie ale pokročily a tak už můžete oba tyto odpady házet do modrých kontejnerů na papír. Ruličky od toaletního papíru, plata od vajec, karton i noviny lze kompostovat.",
        "Použité krabice nejsou odpad. Příbývá e-shopů, kam můžete krabice i výplňový materiál odevzdat. Pokud žádný ve svém okolí nemáte, rozloženou krabici můžete vyhodit do modrých kontejnerů na papír."
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
        val view = inflater.inflate(R.layout.fragment_paper, container, false)

        val linearLayout = view.findViewById<LinearLayout>(R.id.tipLinearLayout)

        val header = TextView(view.context)
        header.text = "Kontejner na papír"
        header.setTextAppearance(R.style.TipHeadingTextView)
        header.setBackgroundResource(R.color.colorBluePaper)
        header.setPadding(15,20,15,20)

        linearLayout.addView(header)

        for (tip in paper_tips){

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
         * @return A new instance of fragment PaperFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PaperFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}