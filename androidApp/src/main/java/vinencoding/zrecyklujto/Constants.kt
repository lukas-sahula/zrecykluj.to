package vinencoding.zrecyklujto

object Constants {

    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Kam patří PET lahev?",
            0,
            "do kontejneru na plasty",
            "do kontejneru na papír",
            "do kontejneru na sklo",
            "do směsného odpadu",
            1
        )

        questionsList.add(que1)

        val que2 = Question(
            2,
            "Kam patří tuba od zubní pasty?",
            0,
            "do nebezpečného odpadu",
            "do směsného odpadu",
            "do kontejneru na plasty",
            "do kontejneru na sklo",
            2
        )

        questionsList.add(que2)

        val que3 = Question(
            3,
            "Kam patří molitan?",
            0,
            "do kontejneru na papír",
            "do kontejneru na plasty",
            "do kontejneru na bioodpad",
            "do směsného odpadu",
            4
        )

        questionsList.add(que3)

        val que4 = Question(
            4,
            "Kam patří elektroodpad?",
            0,
            "do směsného odpadu",
            "do nebezpečného odpadu",
            "do místa zpětného odběru",
            "do kontejneru na textil",
            3
        )

        questionsList.add(que4)

        val que5 = Question(
            5,
            "Kam patří použité papírové kapesníky?",
            0,
            "do směsného odpadu",
            "do kontejneru na papír",
            "do kontejneru na bioodpad",
            "do nebezpečného odpadu",
            1
        )

        questionsList.add(que5)

        val que6 = Question(
            6,
            "Kam patří blistr na léky?",
            0,
            "do směsného odpadu",
            "do kontejneru na kov",
            "do kontejneru na plasty",
            "do kontejneru na sklo",
            1
        )

        questionsList.add(que6)

        val que7 = Question(
            7,
            "Kam patří nevymytá lahev od kuchyňského oleje?",
            0,
            "do kontejneru na plasty",
            "do kontejneru na nápojové kartony",
            "do směsného odpadu",
            "do nebezpečného odpadu",
            3
        )

        questionsList.add(que7)

        val que8 = Question(
            8,
            "Kam patří skleněná varná konvice?",
            0,
            "do kontejneru na kov",
            "do kontejneru na sklo",
            "do kontejneru na papír",
            "do směsného odpadu",
            4
        )

        questionsList.add(que8)

        val que9 = Question(
            9,
            "Kam patří plexisklo?",
            0,
            "do sběrného dvora",
            "do kontejneru na sklo",
            "do kontejneru na plasty",
            "do kontejneru na textil",
            1
        )

        questionsList.add(que9)

        val que10 = Question(
            10,
            "Kam patří povoskovaný papír?",
            0,
            "do kontejneru na plasty",
            "do kontejneru na papír",
            "do směsného odpadu",
            "do kontejneru na nápojové kartony",
            3
        )

        questionsList.add(que10)

        val que11 = Question(
            11,
            "Kam patří laminátový papír??",
            0,
            "do kontejneru na papír",
            "do směsného odpadu",
            "do kontejneru na plasty",
            "do kontejneru na kov",
            2
        )

        questionsList.add(que11)

        val que12 = Question(
            12,
            "Kam patří obálka s foliovým okénkem?",
            0,
            "do kontejneru na plasty",
            "do směsného odpadu",
            "do kontejneru na papír",
            "do kontejneru na sklo",
            3
        )

        questionsList.add(que12)

        val que13 = Question(
            13,
            "Kam patří ruličky od toaletního papíru?",
            0,
            "do kontejneru na papír",
            "do kontejneru na sklo",
            "do směsného odpadu",
            "do kontejneru na kov",
            1
        )

        questionsList.add(que13)

        val que14 = Question(
            14,
            "Kam patří plata od vajec?",
            0,
            "do směsného odpadu",
            "do kontejneru na nápojové kartony",
            "do nebezpečného odpadu",
            "do kontejneru na papír",
            4
        )

        questionsList.add(que14)

        val que15 = Question(
            15,
            "Kam patří fotografie?",
            0,
            "do kontejneru na papír",
            "do směsného odpadu",
            "do kontejneru na plasty",
            "do kontejneru na kov",
            2
        )

        questionsList.add(que15)

        val que16 = Question(
            16,
            "Kam patří nápojové plechovky?",
            0,
            "do kontejneru na nápojové kartony",
            "do nebezpečného odpadu",
            "do kontejneru na kov",
            "do směsného odpadu",
            3
        )

        questionsList.add(que16)

        val que17 = Question(
            17,
            "Kam patří víčko od jogurtu?",
            0,
            "do směsného odpadu",
            "do kontejneru na kov",
            "do kontejneru na nápojové kartony",
            "do kontejneru na plasty",
            2
        )

        questionsList.add(que17)

        val que18 = Question(
            18,
            "Kam patří folie of čokolády nebo taveného sýru?",
            0,
            "do kontejneru na bioodpad",
            "do kontejneru na nápojové kartony",
            "do směsného odpadu",
            "do kontejneru na kov",
            4
        )

        questionsList.add(que18)

        val que19 = Question(
            19,
            "Kam patří plechovka od barvy?",
            0,
            "do sběrného dvora",
            "do kontejneru na sklo",
            "do kontejneru na kov",
            "do směsného odpadu",
            1
        )

        questionsList.add(que19)

        val que20 = Question(
            20,
            "Kam patří lahev od vína?",
            0,
            "do nebezpečného odpadu",
            "do kontejneru na nápojové kartony",
            "do kontejneru na kov",
            "do kontejneru na sklo",
            4
        )

        questionsList.add(que20)

        val que21 = Question(
            21,
            "Kam patří tabulové sklo?",
            0,
            "do kontejneru na sklo",
            "do směsného odpadu",
            "do kontejneru na plasty",
            "do kontejneru na bioodpad",
            1
        )

        questionsList.add(que21)

        val que22 = Question(
            22,
            "Kam patří rozbité skleničky?",
            0,
            "do směsného odpadu",
            "do kontejneru na sklo",
            "do kontejneru na papír",
            "do nebezpečného odpadu",
            2
        )

        questionsList.add(que22)

        val que23 = Question(
            23,
            "Kam patří keramika?",
            0,
            "do směsného odpadu",
            "do kontejneru na plasty",
            "do kontejneru na sklo",
            "do nebezpečného odpadu",
            1
        )

        questionsList.add(que23)

        val que24 = Question(
            24,
            "Kam patří porcelán?",
            0,
            "do kontejneru na sklo",
            "do směsného odpadu",
            "do kontejneru na nápojové kartony",
            "do kontejneru na papír",
            2
        )

        questionsList.add(que24)

        val que25 = Question(
            25,
            "Kam patří zrcadlo?",
            0,
            "do nebezpečného odpadu",
            "do kontejneru na kov",
            "do směsného odpadu",
            "do kontejneru na sklo",
            3
        )

        questionsList.add(que25)

        val que26 = Question(
            26,
            "Kam patří sklokeramika?",
            0,
            "do kontejneru na sklo",
            "do kontejneru na kov",
            "do kontejneru na nápojové kartony",
            "do směsného odpadu",
            4
        )

        questionsList.add(que26)

        val que27 = Question(
            27,
            "Kam patří krabice od mléka?",
            0,
            "do směsného odpadu",
            "do kontejneru na plasty",
            "do kontejneru na nápojové kartony",
            "do kontejneru na papír",
            3
        )

        questionsList.add(que27)

        val que28 = Question(
            28,
            "Kam patří krabice od džusů?",
            0,
            "do kontejneru na nápojové kartony",
            "do směsného odpadu",
            "do kontejneru na papír",
            "do kontejneru na plasty",
            1
        )

        questionsList.add(que28)

        val que29 = Question(
            29,
            "Kam patří polohliníkové sáčky (např. od koření)?",
            0,
            "do kontejneru na plasty",
            "do kontejneru na nápojové kartony",
            "do kontejneru na kov",
            "do směsného odpadu",
            4
        )

        questionsList.add(que29)

        val que30 = Question(
            30,
            "Jaká je průměrná vzdálenost k nádobám na tříděný odpad?",
            0,
            "5 metrů",
            "91 metrů",
            "185 metrů",
            "520 metrů",
            2
        )

        questionsList.add(que30)

        return questionsList
    }

}

