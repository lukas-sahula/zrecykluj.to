package vinencoding.zrecyklujto.utils

import vinencoding.zrecyklujto.models.Question
import vinencoding.zrecyklujto.models.RecyclingCode

object Constants {

    const val LOCATION_PERMISSION_REQUEST_CODE = 2

    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getDecisionTreeCardInformation(): ArrayList<RecyclingCode> {
        val recyclingCodesList : ArrayList<RecyclingCode> = ArrayList()

        val recyclingCode1 = RecyclingCode(
            "1",
            "PET",
            "Polyethylentereftalát (PET, PETE)",
            "kontejner na plasty, kontejner na PET",
            "Pl"
        )
        recyclingCodesList.add(recyclingCode1)

        val recyclingCode2 = RecyclingCode(
            "2",
            "PE-HD",
            "Vysokohustotní (lineární) polyetylen (HDPE, PE-HD)",
            "kontejner na plasty",
            "Pl"
        )
        recyclingCodesList.add(recyclingCode2)

        val recyclingCode3 = RecyclingCode(
            "3",
            "PVC",
            "Polyvinylchlorid (PVC, V)",
            "sběrný dvůr",
            "Va"
        )
        recyclingCodesList.add(recyclingCode3)

        val recyclingCode4 = RecyclingCode(
            "4",
            "LDPE",
            "Nízkohustotní (rozvětvený) polyetylen (LDPE, PE-LD)",
            "kontejner na plasty",
            "Pl"
        )
        recyclingCodesList.add(recyclingCode4)

        val recyclingCode5 = RecyclingCode(
            "5",
            "PP",
            "Polypropylen (PP)",
            "kontejner na plasty",
            "Pl"
        )
        recyclingCodesList.add(recyclingCode5)

        val recyclingCode6 = RecyclingCode(
            "6",
            "PS",
            "Polystyren (PS)",
            "kontejner na plasty",
            "Pl"
        )
        recyclingCodesList.add(recyclingCode6)

        val recyclingCode7 = RecyclingCode(
            "7",
            "O",
            "Ostatní plasty (O, OTHER)",
            "sběrný dvůr",
            "Va"
        )
        recyclingCodesList.add(recyclingCode7)

        val recyclingCode8 = RecyclingCode(
            "20",
            "PAP",
            "Vlnitá lepenka (PAP)",
            "kontejner na papír",
            "Pa"
        )
        recyclingCodesList.add(recyclingCode8)

        val recyclingCode9 = RecyclingCode(
            "21",
            "PAP",
            "Hladká lepenka (PAP)",
            "kontejner na papír",
            "Pa"
        )
        recyclingCodesList.add(recyclingCode9)

        val recyclingCode10 = RecyclingCode(
            "22-39",
            "PAP",
            "Papír (PAP)",
            "kontejner na papír",
            "Pa"
        )
        recyclingCodesList.add(recyclingCode10)

        val recyclingCode11 = RecyclingCode(
            "40",
            "Fe",
            "Ocel (Fe)",
            "kontejner na kovy, sběrný dvůr",
            "Me"
        )
        recyclingCodesList.add(recyclingCode11)

        val recyclingCode12 = RecyclingCode(
            "41",
            "ALU",
            "Hliník (ALU)",
            "kontejner na kovy, sběrný dvůr",
            "Me"
        )
        recyclingCodesList.add(recyclingCode12)

        val recyclingCode13 = RecyclingCode(
            "42-49",
            "",
            "Ostatní kovy",
            "kontejner na kovy, sběrný dvůr",
            "Me"
        )
        recyclingCodesList.add(recyclingCode13)

        val recyclingCode14 = RecyclingCode(
            "50",
            "FOR",
            "Dřevo (FOR)",
            "sběrný dvůr",
            "Va"
        )
        recyclingCodesList.add(recyclingCode14)

        val recyclingCode15 = RecyclingCode(
            "51",
            "FOR",
            "Korek (FOR)",
            "sběrný dvůr",
            "Va"
        )
        recyclingCodesList.add(recyclingCode15)

        val recyclingCode16 = RecyclingCode(
            "52-59",
            "FOR",
            "Ostatní dřevo (FOR)",
            "sběrný dvůr",
            "Va"
        )
        recyclingCodesList.add(recyclingCode16)

        val recyclingCode17 = RecyclingCode(
            "60",
            "TEX",
            "Bavlna (TEX)",
            "kontejner na textil, sběrný dvůr",
            "Va"
        )
        recyclingCodesList.add(recyclingCode17)

        val recyclingCode18 = RecyclingCode(
            "61",
            "TEX",
            "Juta (TEX)",
            "kontejner na textil, sběrný dvůr",
            "Va"
        )
        recyclingCodesList.add(recyclingCode18)

        val recyclingCode19 = RecyclingCode(
            "62-69",
            "TEX",
            "Ostatní textilie (TEX)",
            "kontejner na textil, sběrný dvůr",
            "Va"
        )
        recyclingCodesList.add(recyclingCode19)

        val recyclingCode20 = RecyclingCode(
            "70",
            "GL",
            "Bílé sklo (GL)",
            "kontejner na sklo",
            "Gl"
        )
        recyclingCodesList.add(recyclingCode20)

        val recyclingCode21 = RecyclingCode(
            "71",
            "GL",
            "Zelené sklo (GL)",
            "kontejner na sklo",
            "Gl"
        )
        recyclingCodesList.add(recyclingCode21)

        val recyclingCode22 = RecyclingCode(
            "72",
            "GL",
            "Hnědé sklo (GL)",
            "kontejner na sklo",
            "Gl"
        )
        recyclingCodesList.add(recyclingCode22)

        val recyclingCode23 = RecyclingCode(
            "73-79",
            "GL",
            "Ostatní sklo (GL)",
            "kontejner na sklo",
            "Gl"
        )
        recyclingCodesList.add(recyclingCode23)

        val recyclingCode24 = RecyclingCode(
            "81,84",
            "C/PAP",
            "Nápojový karton (C/PAP, C/PAP/ALU)",
            "kontejner na nápojové kartony",
            "Te"
        )
        recyclingCodesList.add(recyclingCode24)

        return recyclingCodesList
    }

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Kam patří PET lahev?",
            "do kontejneru na plasty",
            "do kontejneru na papír",
            "do kontejneru na sklo",
            "do směsného odpadu",
            1,
            "PET láhve můžete do kontejneru vhazovat s etiketou i víčkem. Obojí bude při dalším zpracování automaticky odděleno. PET láhve sešlápněte, nasaďte víčko a to již neutahujte!!! Nesešlápnuté láhve jsou objemné a tím zdražují přepravu, komplikují manipulaci a recyklace se tak stává nákladnější."
        )

        questionsList.add(que1)

        val que2 = Question(
            2,
            "Kam patří tuba od zubní pasty?",
            "do nebezpečného odpadu",
            "do směsného odpadu",
            "do kontejneru na plasty",
            "do kontejneru na sklo",
            2,
            "Tuby od zubní pasty patří do směsného odpadu. Mohou obsahovat hliníkovou vrstvu. Navíc většinou zůstává určité množství pasty v tubě, takže se jedná o znečištěný obal."
        )

        questionsList.add(que2)

        val que3 = Question(
            3,
            "Kam patří molitan?",
            "do kontejneru na papír",
            "do kontejneru na plasty",
            "do kontejneru na bioodpad",
            "do směsného odpadu",
            4,
            "Molitan v menším množství můžete hodit do směsného odpadu, ve větším množství patří do sběrného dvora."
        )

        questionsList.add(que3)

        val que4 = Question(
            4,
            "Kam patří elektroodpad?",
            "do směsného odpadu",
            "do nebezpečného odpadu",
            "do místa zpětného odběru",
            "do kontejneru na textil",
            3,
            "Elektroodpad patří na místa zpětného odběru jako jsou prodejny, kde jste elektro pořídili. Odnést je můžete  také na sběrný dvůr."
        )

        questionsList.add(que4)

        val que5 = Question(
            5,
            "Kam patří použité papírové kapesníky?",
            "do směsného odpadu",
            "do kontejneru na papír",
            "do kontejneru na bioodpad",
            "do nebezpečného odpadu",
            1,
            "Použité dětské pleny patří, stejně jako papírové kapesníky a dámské hygienické potřeby, do černého nebo šedého kontejneru na směsný odpad."
        )

        questionsList.add(que5)

        val que6 = Question(
            6,
            "Kam patří blistr na léky?",
            "do směsného odpadu",
            "do kontejneru na kov",
            "do kontejneru na plasty",
            "do kontejneru na sklo",
            1,
            "C/PAP a C/PP patří do směsného odpadu. Skládají se ze dvou či více materiálů, které od sebe nejsou jednoduše oddělitelné. Takovým obalem je např. tzv. blistr na léky (\"platíčko\" se zatavenými tabletkami). Většinu kombinovaných obalů nelze zpracovat. Výjimkou je nápojový karton (pevný karton určený na nápoje nebo omáčky) a některé další kombinované papírové obaly."
        )

        questionsList.add(que6)

        val que7 = Question(
            7,
            "Kam patří nevymytá lahev od kuchyňského oleje?",
            "do kontejneru na plasty",
            "do kontejneru na nápojové kartony",
            "do směsného odpadu",
            "do nebezpečného odpadu",
            3,
            "Pokud obal od oleje pečlivě vymyjete teplou vodou s přípravkem na mytí nádobí, můžete jej vhodit do plastů. V případě, že tak neučiníte, vhazujte tento znečištěný obal do směsného odpadu. Olej totiž značně komplikuje následnou recyklaci tříděného odpadu. V některých obcích se olej sbírá, informujte se tedy o možnosti sběru použitého kuchyňského oleje na obecním úřadu, odboru životního prostředí. Obecně však platí, že fritovací olej z domácnosti patří do sběrných dvorů, můžete jej uchovávat v kanystru a až ve větším množství odevzdat."
        )

        questionsList.add(que7)

        val que8 = Question(
            8,
            "Kam patří skleněná varná konvice?",
            "do kontejneru na kov",
            "do kontejneru na sklo",
            "do kontejneru na papír",
            "do směsného odpadu",
            4,
            "Varné a laboratorní sklo díky své vyšší teplotě tavení nepatří do běžných kontejnerů na ulicích. Pokud se Vám rozbije například skleněná varná konvice, hoďte ji do směsného odpadu. V případě většího množství tohoto skla využijte sběrný dvůr."
        )

        questionsList.add(que8)

        val que9 = Question(
            9,
            "Kam patří plexisklo?",
            "do sběrného dvora",
            "do kontejneru na sklo",
            "do kontejneru na plasty",
            "do kontejneru na textil",
            1,
            "Plexisklo, nebo také tzv. akrylátové sklo, je syntetický polymer (polymethylmethakrylát – PMMA), který má vlastnosti termoplastu. Jedná se o bezbarvou, průhlednou amorfní hmotu, které se také přezdívá „organické sklo“. Patří do sběrného dvora."
        )

        questionsList.add(que9)

        val que10 = Question(
            10,
            "Kam patří povoskovaný papír?",
            "do kontejneru na plasty",
            "do kontejneru na papír",
            "do směsného odpadu",
            "do kontejneru na nápojové kartony",
            3,
            "Laminátový papír nepatří do papíru. Jinak do papíru patří papír všeho druhu, kromě polaminátovaného a povoskovaného papíru."
        )

        questionsList.add(que10)

        val que11 = Question(
            11,
            "Kam patří laminátový papír??",
            "do kontejneru na papír",
            "do směsného odpadu",
            "do kontejneru na plasty",
            "do kontejneru na kov",
            2,
            "Laminátový papír nepatří do papíru. Jinak do papíru patří papír všeho druhu, kromě polaminátovaného a povoskovaného papíru."
        )

        questionsList.add(que11)

        val que12 = Question(
            12,
            "Kam patří obálka s foliovým okénkem?",
            "do kontejneru na plasty",
            "do směsného odpadu",
            "do kontejneru na papír",
            "do kontejneru na sklo",
            3,
            "Do kontejneru na papír můžete vhazovat obálky i s foliovým okénkem. Při dalším zpracování papíru v papírnách jsou při rozvláknění a následném několikastupňovém třídění odloučeny. Pokud však vyhazujete obálku s ochrannou bublinkovou fólií, tak tu je potřeba odstranit.\""
        )

        questionsList.add(que12)

        val que13 = Question(
            13,
            "Kam patří ruličky od toaletního papíru?",
            "do kontejneru na papír",
            "do kontejneru na sklo",
            "do směsného odpadu",
            "do kontejneru na kov",
            1,
            "Ruličky od toaletního papíru a plata od vajec už se třídí. Dříve se správně házeli do směsného odpadu, recyklační technologie ale pokročily a tak už můžete oba tyto odpady házet do modrých kontejnerů na papír. Ruličky od toaletního papíru, plata od vajec, karton i noviny lze kompostovat."
        )

        questionsList.add(que13)

        val que14 = Question(
            14,
            "Kam patří plata od vajec?",
            "do směsného odpadu",
            "do kontejneru na nápojové kartony",
            "do nebezpečného odpadu",
            "do kontejneru na papír",
            4,
            "Ruličky od toaletního papíru a plata od vajec už se třídí. Dříve se správně házeli do směsného odpadu, recyklační technologie ale pokročily a tak už můžete oba tyto odpady házet do modrých kontejnerů na papír. Ruličky od toaletního papíru, plata od vajec, karton i noviny lze kompostovat."
        )

        questionsList.add(que14)

        val que15 = Question(
            15,
            "Kam patří fotografie?",
            "do kontejneru na papír",
            "do směsného odpadu",
            "do kontejneru na plasty",
            "do kontejneru na kov",
            2,
            "Fotky bývají nejčastěji vytištěny na speciální fotografický papír. Základem fotopapíru může být obyčejný, barytový či laminovaný papír. Povrch fotopapíru je pak potažen fotocitlivou vrstvou. Díky ní jsou fotografie kvalitní a barva na nich dlouho vydrží. Právě díky speciálním povrchovým úpravám nelze fotografie recyklovat, proto je vyhazujeme do směsného odpadu."
        )

        questionsList.add(que15)

        val que16 = Question(
            16,
            "Kam patří nápojové plechovky?",
            "do kontejneru na nápojové kartony",
            "do nebezpečného odpadu",
            "do kontejneru na kov",
            "do směsného odpadu",
            3,
            "Kovové obaly a hliníková víčka odhazujte do sběrných nádob nebo pytlů určených pro sběr kovů. Větší množství můžete odnést do sběrného dvora nebo výkupny kovů."
        )

        questionsList.add(que16)

        val que17 = Question(
            17,
            "Kam patří víčko od jogurtu?",
            "do směsného odpadu",
            "do kontejneru na kov",
            "do kontejneru na nápojové kartony",
            "do kontejneru na plasty",
            2,
            "Kovové obaly a hliníková víčka odhazujte do sběrných nádob nebo pytlů určených pro sběr kovů. Větší množství můžete odnést do sběrného dvora nebo výkupny kovů."
        )

        questionsList.add(que17)

        val que18 = Question(
            18,
            "Kam patří folie of čokolády nebo taveného sýru?",
            "do kontejneru na bioodpad",
            "do kontejneru na nápojové kartony",
            "do směsného odpadu",
            "do kontejneru na kov",
            4,
            "Kovové obaly a hliníková víčka odhazujte do sběrných nádob nebo pytlů určených pro sběr kovů. Větší množství můžete odnést do sběrného dvora nebo výkupny kovů."
        )

        questionsList.add(que18)

        val que19 = Question(
            19,
            "Kam patří plechovka od barvy?",
            "do sběrného dvora",
            "do kontejneru na sklo",
            "do kontejneru na kov",
            "do směsného odpadu",
            1,
            "Obaly s technickými oleji, barvami, ředidly a jinými chemickými látkami odevzdejte na místa určená ke sběru nebezpečných látek, většinou do sběrného dvora. Oleje se sbírají také na místech zpětného odběru, což mohou být čerpací stanice a autoservisy. Lepší je nechat si olej vyměnit v servisu. Ve většině případů je toto uvedeno na etiketě výrobku."
        )

        questionsList.add(que19)

        val que20 = Question(
            20,
            "Kam patří lahev od vína?",
            "do nebezpečného odpadu",
            "do kontejneru na nápojové kartony",
            "do kontejneru na kov",
            "do kontejneru na sklo",
            4,
            "Do kontejneru na vytříděné sklo patří skleněné láhve od moštů, vína, piva, štávy, oleje i mléka. Zálohované sklo vracejte."
        )

        questionsList.add(que20)

        val que21 = Question(
            21,
            "Kam patří tabulové sklo?",
            "do kontejneru na sklo",
            "do směsného odpadu",
            "do kontejneru na plasty",
            "do kontejneru na bioodpad",
            1,
            "Do zeleného kontejneru můžeme vhazovat barevné sklo, například lahve od vína, alkoholických i nealkoholických nápojů. Vhodit do zeleného kontejneru můžete také tabulové sklo z oken a ze dveří."
        )

        questionsList.add(que21)

        val que22 = Question(
            22,
            "Kam patří rozbité skleničky?",
            "do směsného odpadu",
            "do kontejneru na sklo",
            "do kontejneru na papír",
            "do nebezpečného odpadu",
            2,
            "Rozbité sklo třídění nevadí, můžete ho hodit do kontejneru na sklo. Do těchto nádob ale nepatří keramika a porcelán nebo například zrcadlo."
        )

        questionsList.add(que22)

        val que23 = Question(
            23,
            "Kam patří keramika?",
            "do směsného odpadu",
            "do kontejneru na plasty",
            "do kontejneru na sklo",
            "do nebezpečného odpadu",
            1,
            "Optická třídička skla umí prosvítit střepy a nevhodné položky odstranit. Poradí si i s oddělením kovů od skla – proto nevadí víčka. Laserová čidla umí střepy rozlišit podle barev. Etikety, ale ani zbytky obsahu při recyklaci nevadí, protože při teplotě tavení (cca 1 600 °C) shoří.Při tavení skla je nejvetší problém s materiály, které se sklu podobají. Nesprávně do kontejnerů na sklo lidé třídí například porcelán, bezpečnostní sklo, autosklo, sklokeramiku nebo třeba varné sklo apod."
        )

        questionsList.add(que23)

        val que24 = Question(
            24,
            "Kam patří porcelán?",
            "do kontejneru na sklo",
            "do směsného odpadu",
            "do kontejneru na nápojové kartony",
            "do kontejneru na papír",
            2,
            "Optická třídička skla umí prosvítit střepy a nevhodné položky odstranit. Poradí si i s oddělením kovů od skla – proto nevadí víčka. Laserová čidla umí střepy rozlišit podle barev. Etikety, ale ani zbytky obsahu při recyklaci nevadí, protože při teplotě tavení (cca 1 600 °C) shoří.Při tavení skla je nejvetší problém s materiály, které se sklu podobají. Nesprávně do kontejnerů na sklo lidé třídí například porcelán, bezpečnostní sklo, autosklo, sklokeramiku nebo třeba varné sklo apod."
        )

        questionsList.add(que24)

        val que25 = Question(
            25,
            "Kam patří zrcadlo?",
            "do nebezpečného odpadu",
            "do kontejneru na kov",
            "do směsného odpadu",
            "do kontejneru na sklo",
            3,
            "Optická třídička skla umí prosvítit střepy a nevhodné položky odstranit. Poradí si i s oddělením kovů od skla – proto nevadí víčka. Laserová čidla umí střepy rozlišit podle barev. Etikety, ale ani zbytky obsahu při recyklaci nevadí, protože při teplotě tavení (cca 1 600 °C) shoří.Při tavení skla je nejvetší problém s materiály, které se sklu podobají. Nesprávně do kontejnerů na sklo lidé třídí například porcelán, bezpečnostní sklo, autosklo, sklokeramiku nebo třeba varné sklo apod."
        )

        questionsList.add(que25)

        val que26 = Question(
            26,
            "Kam patří sklokeramika?",
            "do kontejneru na sklo",
            "do kontejneru na kov",
            "do kontejneru na nápojové kartony",
            "do směsného odpadu",
            4,
            "Optická třídička skla umí prosvítit střepy a nevhodné položky odstranit. Poradí si i s oddělením kovů od skla – proto nevadí víčka. Laserová čidla umí střepy rozlišit podle barev. Etikety, ale ani zbytky obsahu při recyklaci nevadí, protože při teplotě tavení (cca 1 600 °C) shoří.Při tavení skla je nejvetší problém s materiály, které se sklu podobají. Nesprávně do kontejnerů na sklo lidé třídí například porcelán, bezpečnostní sklo, autosklo, sklokeramiku nebo třeba varné sklo apod."
        )

        questionsList.add(que26)

        val que27 = Question(
            27,
            "Kam patří krabice od mléka?",
            "do směsného odpadu",
            "do kontejneru na plasty",
            "do kontejneru na nápojové kartony",
            "do kontejneru na papír",
            3,
            "Z nápojového kartonu není nutné odtrhnout umělohmotný uzávěr. Pokud ve vaší obci probíhá sběr nápojových kartonů, prázdný karton pouze vypláchněte vodou, stlačte a i s víčkem odhoďte do kontejneru nebo oranžového pytle, který je ve vaší obci pro tento odpad určen."
        )

        questionsList.add(que27)

        val que28 = Question(
            28,
            "Kam patří krabice od džusů?",
            "do kontejneru na nápojové kartony",
            "do směsného odpadu",
            "do kontejneru na papír",
            "do kontejneru na plasty",
            1,
            "Z nápojového kartonu není nutné odtrhnout umělohmotný uzávěr. Pokud ve vaší obci probíhá sběr nápojových kartonů, prázdný karton pouze vypláchněte vodou, stlačte a i s víčkem odhoďte do kontejneru nebo oranžového pytle, který je ve vaší obci pro tento odpad určen."
        )

        questionsList.add(que28)

        val que29 = Question(
            29,
            "Kam patří polohliníkové sáčky (např. od koření)?",
            "do kontejneru na plasty",
            "do kontejneru na nápojové kartony",
            "do kontejneru na kov",
            "do směsného odpadu",
            4,
            "Obal z kombinovaného materiálu nelze recyklovat, patří tedy do směsného odpadu (např. „kombinované“ sáčky typické pro kávu, polévky, koření, instantní těstoviny atd.). Vyjímkou jsou nápojové kartony (C/PAP, 81, 84)."
        )

        questionsList.add(que29)

        val que30 = Question(
            30,
            "Jaká je průměrná vzdálenost k nádobám na tříděný odpad?",
            "5 metrů",
            "91 metrů",
            "185 metrů",
            "520 metrů",
            2,
            "Průměrná vzdálenost k nádobám na tříděný odpad se každoročně zkracuje. Aktuální vzdálenost je 91 metrů, ale podle průzkumů jsou lidé ochotni jít k barevným kontejnerům o dalších čtyřicet metrů dál. Sběrná síť se stále zahušťuje, v současné době je k dispozici už dokonce 473 359 nádob na tříděný odpad! V Evropě se řadíme k zemím s nejhustší sběrnou sítí."
        )

        questionsList.add(que30)

        val que31 = Question(
            31,
            "Kolikrát lze recyklovat papír?",
            "2–3×",
            "5–7×",
            "10–15×",
            "donekonečna",
            2,
            "Papír lze proměnit na nový papír asi pětkrát až sedmkrát. Celulózová vlákna papíru se každou recyklací zkracují."
        )

        questionsList.add(que31)

        val que32 = Question(
            32,
            "Kolikrát lze recyklovat sklo?",
            "3×",
            "6×",
            "10×",
            "donekonečna",
            4,
            "O skle mluvíme jako o materiálu minulosti, současnosti a budoucnosti právě proto, že jej lze recyklovat donekonečna. Ještě nikdo nevymyslel zdravější a ekologičtější obalový materiál na potraviny a nápoje. "
        )

        questionsList.add(que32)

        return questionsList
    }

}

