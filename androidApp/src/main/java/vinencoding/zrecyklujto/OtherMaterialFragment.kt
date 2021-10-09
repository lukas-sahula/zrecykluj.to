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
        "Sběrný dvůr je dnes už skoro v každém městě a obci. Můžete do něj odvézt v podstatě všechny odpady, které vzniknou u vás doma a nevejdou se do kontejneru, případně do něj vůbec nepatří (to platí zejména pro nebezpečné odpady).",
        "Ukládání odpadu ve sběrných dvorech je pro místní občany zdarma, resp. občan si jej platí v rámci celkového poplatku za komunální odpady v obci. U některého odpadu, jako jsou např. pneumatiky, se může vybírat manipulační poplatek, případně můžete odevzdat jen určité množství (zpravidla u stavebního a demoličního odpadu). Živnostníci a firmy mohou sběrný dvůr využívat také, ale většinou zaplatí obcí stanovený poplatek.",
        "Druhy odpadu, které mohou být odloženy do sběrného dvora, a podmínky provozu konkrétního dvora určuje vždy obec. Proto je nutné se vždy předem informovat (na obecním či městském úřadě, na internetu apod.), co do kterého sběrného dvora patří.",
        "V domácnosti se nesmí vyhazovat do kanalizace látky infekční a karcinogenní, léčiva, látky ropné, látky omamné a hořlavé, jedy, žíraviny, výbušniny, pesticidy, organická rozpouštědla, látky působící změnu barvy vody, hygienické potřeby, pevné odpady včetně kuchyňských",
        "Na sběrných dvorech můžete odložit, stejně jako do kontejnerů, i využitelné složky komunálního odpadu, jako jsou plast, papír, sklo, kovy a nápojový karton.",
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
        "U prosředků na hubení hmyzu se vždy řiďte pokyny na obalu. Ve většině případů patří do nebezpečného odpadu, odvezte je proto na sběrný dvůr nebo do mobilní sběrny nebezpečného odpadu. O nebezpečné vlastnosti výrobku  informuje oranžová výstražná značka na obalu.",
        "C/PAP a C/PP patří do směsného odpadu. Skládají se ze dvou či více materiálů, které od sebe nejsou jednoduše oddělitelné. Takovým obalem je např. tzv. blistr na léky (\"platíčko\" se zatavenými tabletkami). Většinu kombinovaných obalů nelze zpracovat. Výjimkou je nápojový karton (pevný karton určený na nápoje nebo omáčky) a některé další kombinované papírové obaly.",
        "Pokud obal od oleje pečlivě vymyjete teplou vodou s přípravkem na mytí nádobí, můžete jej vhodit do plastů. V případě, že tak neučiníte, vhazujte tento znečištěný obal do směsného odpadu. Olej totiž značně komplikuje následnou recyklaci tříděného odpadu. V některých obcích se olej sbírá, informujte se tedy o možnosti sběru použitého kuchyňského oleje na obecním úřadu, odboru životního prostředí. Obecně však platí, že fritovací olej z domácnosti patří do sběrných dvorů, můžete jej uchovávat v kanystru a až ve větším množství odevzdat.",
        "Zpětný odběr vysloužilých světelných zdrojů probíhá pomocí nádob k tomu určených. Tyto nádoby můžete nalézt na vašem obecním úřadě, prodejnách elektro nebo sběrném dvoře. Seznam sběrných míst http://www.ekolamp.cz/cz/sberna-mista Na těchto místech se odebírají lineární a kompaktní zářivky, halogenidové, sodíkové a směsné výbojky, světelné zdroje s LED diodami. Do zpětného odběru však nepatří běžné žárovky, ani reflektorové a halogenové žárovky, proto je jejich místo v popelnici se směsným odpadem.",
        "Obaly s technickými oleji, barvami, ředidly a jinými chemickými látkami odevzdejte na místa určená ke sběru nebezpečných látek, většinou do sběrného dvora. Oleje se sbírají také na místech zpětného odběru, což mohou být čerpací stanice a autoservisy. Lepší je nechat si olej vyměnit v servisu. Ve většině případů je toto uvedeno na etiketě výrobku.",
        "Varné a laboratorní sklo díky své vyšší teplotě tavení nepatří do běžných kontejnerů na ulicích. Pokud se Vám rozbije například skleněná varná konvice, hoďte ji do směsného odpadu. V případě většího množství tohoto skla využijte sběrný dvůr.",
        "Do kompostu lze dávat zbytky z vařených jídel. Nepatří tam ale například zbytky z masa a kostí nebo tekuté a silně mastné potraviny. To je totiž bioodpad, který může mít hygienická rizika. Do kompostu patří jakýkoli odpad, který je schopen anaerobního nebo aerobního rozkladu (např. zbytky potravin, odpad ze zeleně, čajové sáčky, skořápky od vajec, apod.)",
        "V obcích lze celoročně odkládat jedlý olej do speciálních kontejnerů nebo sběrných dvorů. Upravené odpadní oleje se používají při výrobě biopaliva nebo pro energetické využití.",
        "Plexisklo, nebo také tzv. akrylátové sklo, je syntetický polymer (polymethylmethakrylát – PMMA), který má vlastnosti termoplastu. Jedná se o bezbarvou, průhlednou amorfní hmotu, které se také přezdívá „organické sklo“. Patří do sběrného dvora.",
        "Na sběrné dvory lze kromě těchto menších odpadů odvážet i další kovové odpady – trubky, roury, plechy, hrnce, vany, kola a další objemnější předměty. Samostatnou kapitolou jsou kovové elektrospotřebiče, které lze na sběrných dvorech odkládat pouze kompletní.",
        "Tam, kde dosud sběrný dvůr ani sběrné místo není, má obec povinnost dvakrát ročně zorganizovat tzv. mobilní sběr."
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