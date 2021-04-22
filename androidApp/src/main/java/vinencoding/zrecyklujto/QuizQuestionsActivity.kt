package vinencoding.zrecyklujto

import android.app.Dialog
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import android.widget.TextView
import vinencoding.zrecyklujto.R.layout.explanation_dialog


class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var currentPosition: Int = 1
    private var questionsList: ArrayList<Question>? = null
    private var selectedOptionPosition: Int = 0
    private var correctAnswer: Int = 0
    private var randomArray: ArrayList<Question>? = Constants.getQuestions()
    private var question: Question? = null

    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null
    private var submitButton: Button? = null
    private var explanationButton: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        //shuffle questions in list, make new list with 10 questions
        shuffleQuestions(randomArray!!)
        val list = randomArray!!.subList(0,10)
        questionsList = ArrayList(list)

        submitButton = findViewById(R.id.button_submit)
        optionOne = findViewById(R.id.tv_option_one)
        optionTwo = findViewById(R.id.tv_option_two)
        optionThree = findViewById(R.id.tv_option_three)
        optionFour = findViewById(R.id.tv_option_four)
        explanationButton = findViewById(R.id.tv_quiz_explanation)

        setQuestion()

        optionOne!!.setOnClickListener(this)
        optionTwo!!.setOnClickListener(this)
        optionThree!!.setOnClickListener(this)
        optionFour!!.setOnClickListener(this)
        submitButton!!.setOnClickListener(this)

        explanationButton!!.setOnClickListener{
            showExplanationDialog()
        }
    }

    //assigns values of the 10 selected questions to prepared objects in xml file
    private fun setQuestion(){
        question = questionsList!![currentPosition - 1]

        defaultOptionsView()

        if(currentPosition == questionsList!!.size) {
            submitButton!!.text = getString(R.string.button_finish_text)
        }else{
            submitButton!!.text = getString(R.string.button_submit_text)
        }

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress = currentPosition

        val tvProgress = findViewById<TextView>(R.id.tv_progress)
        tvProgress.text = "$currentPosition/${progressBar.max}"

        val tvQuestion = findViewById<TextView>(R.id.tv_question)
        tvQuestion.text = question!!.question

        optionOne!!.text = question!!.optionOne
        optionTwo!!.text = question!!.optionTwo
        optionThree!!.text = question!!.optionThree
        optionFour!!.text = question!!.optionFour
    }

    private fun showExplanationDialog() {
        val explanationDialog = Dialog(this)
        explanationDialog.setContentView(explanation_dialog)

        val tvExplanation = explanationDialog.findViewById<TextView>(R.id.tv_explanation)
        tvExplanation.text = question!!.explanation

        explanationDialog.show()
    }

    //set default style to textview options
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,optionOne!!)
        options.add(1,optionTwo!!)
        options.add(2,optionThree!!)
        options.add(3,optionFour!!)

        for (option in options){
            option.setTextAppearance(R.style.QuizTextButton)
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_bg)
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_option_one -> {
                selectedOptionView(optionOne!!, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(optionTwo!!, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(optionThree!!, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(optionFour!!, 4)
            }
            R.id.button_submit -> {
                if(selectedOptionPosition == 0){
                    explanationButton!!.visibility = View.INVISIBLE

                    currentPosition ++

                    //user can choose from options
                    optionOne!!.isClickable = true
                    optionTwo!!.isClickable = true
                    optionThree!!.isClickable = true
                    optionFour!!.isClickable = true

                    when{
                        currentPosition <= questionsList!!.size -> {
                            setQuestion()
                        }else ->{
                        //sends data and moves to result activity
                        val intent = Intent(this, QuizResultActivity::class.java)
                        intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswer)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList!!.size)
                        startActivity(intent)
                        finish()
                        }
                    }
            }else{
                val question = questionsList?.get(currentPosition - 1)
                    //wrong answer selected
                if(question!!.correctAnswer != selectedOptionPosition){
                    answerView(selectedOptionPosition, R.drawable.wrong_option_bg)
                    }else{
                        //right answer selected
                        correctAnswer ++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_bg)

                    if(currentPosition == questionsList!!.size){
                        submitButton!!.text = getString(R.string.button_finish_text)
                    }else{
                        explanationButton!!.visibility = View.VISIBLE
                        submitButton!!.text = getString(R.string.button_next_text)

                        //user can not change answer (textview is not clickable)
                        optionOne!!.isClickable = false
                        optionTwo!!.isClickable = false
                        optionThree!!.isClickable = false
                        optionFour!!.isClickable = false
                    }
                    selectedOptionPosition = 0
                }
            }
        }
    }

    //sets style of selected textview option
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()

        selectedOptionPosition = selectedOptionNum

        tv.setTextAppearance(R.style.QuizTextButton)
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
    }

    //set style to selected textview
    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                optionOne!!.background = ContextCompat.getDrawable(
                    this, drawableView
                )}
            2 -> {
                optionTwo!!.background = ContextCompat.getDrawable(
                    this, drawableView
                )}
            3 -> {
                optionThree!!.background = ContextCompat.getDrawable(
                    this, drawableView
                )}
            4 -> {
                optionFour!!.background = ContextCompat.getDrawable(
                    this, drawableView
                )}
        }
    }

    private fun shuffleQuestions(list: ArrayList<Question>){
        list.shuffle()
    }
}


