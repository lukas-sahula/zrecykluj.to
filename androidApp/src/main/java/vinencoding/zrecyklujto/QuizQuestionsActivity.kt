package vinencoding.zrecyklujto

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import android.widget.TextView




class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private var randomArray: ArrayList<Question>? = Constants.getQuestions()

    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null
    private var submitButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        //shuffle questions in list, make new list with 10 questions
        shuffleQuestions(randomArray!!)
        val list = randomArray!!.subList(0,10)
        mQuestionsList = ArrayList(list)

        submitButton = findViewById(R.id.button_submit)
        optionOne = findViewById(R.id.tv_option_one)
        optionTwo = findViewById(R.id.tv_option_two)
        optionThree = findViewById(R.id.tv_option_three)
        optionFour = findViewById(R.id.tv_option_four)

        setQuestion()

        optionOne!!.setOnClickListener(this)
        optionTwo!!.setOnClickListener(this)
        optionThree!!.setOnClickListener(this)
        optionFour!!.setOnClickListener(this)
        submitButton!!.setOnClickListener(this)
    }

    private fun setQuestion(){
        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size) {
            submitButton!!.text = "Ukončit"
        }else{
            submitButton!!.text = "Potvrdit"
        }

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress = mCurrentPosition

        val tv_progress = findViewById<TextView>(R.id.tv_progress)
        tv_progress.text = "$mCurrentPosition" + "/" + "${progressBar.max}"

        val tv_question = findViewById<TextView>(R.id.tv_question)
        tv_question.text = question.question

        val image = findViewById<ImageView>(R.id.iv_image)
        image.setImageResource(question.image)
        if (question.image != 0){
            image.isVisible = true
        }

        optionOne!!.text = question.optionOne
        optionTwo!!.text = question.optionTwo
        optionThree!!.text = question.optionThree
        optionFour!!.text = question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,optionOne!!)
        options.add(1,optionTwo!!)
        options.add(2,optionThree!!)
        options.add(3,optionFour!!)

        for (option in options){
            option.setTextColor(Color.BLACK)
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_bg)
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_option_one -> {selectedOptionView(optionOne!!, selectedOptionNum = 1)}
            R.id.tv_option_two -> {selectedOptionView(optionTwo!!, selectedOptionNum = 2)}
            R.id.tv_option_three -> {selectedOptionView(optionThree!!, selectedOptionNum = 3)}
            R.id.tv_option_four -> {selectedOptionView(optionFour!!, selectedOptionNum = 4)}
            R.id.button_submit -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    optionOne!!.isClickable = true
                    optionTwo!!.isClickable = true
                    optionThree!!.isClickable = true
                    optionFour!!.isClickable = true

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else ->{
                        val intent = Intent(this, QuizResultActivity::class.java)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswer)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                        startActivity(intent)
                        finish()
                        }
                    }
            }else{
                val question = mQuestionsList?.get(mCurrentPosition - 1)
                if(question!!.correctAnswer != mSelectedOptionPosition){
                    answerView(mSelectedOptionPosition, R.drawable.wrong_option_bg)
                    }else{
                        mCorrectAnswer ++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        submitButton!!.text = "Potvrdit"
                    }else{
                        submitButton!!.text = "Další otázka"
                        optionOne!!.isClickable = false
                        optionTwo!!.isClickable = false
                        optionThree!!.isClickable = false
                        optionFour!!.isClickable = false
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.BLACK)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
    }

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


