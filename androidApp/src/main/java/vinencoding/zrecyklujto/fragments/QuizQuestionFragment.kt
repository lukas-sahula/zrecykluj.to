package vinencoding.zrecyklujto.fragments

import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import vinencoding.zrecyklujto.R
import vinencoding.zrecyklujto.models.Question
import vinencoding.zrecyklujto.utils.Constants

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizQuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizQuestionFragment : Fragment(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private lateinit var mQuestionsList: ArrayList<Question>
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    private lateinit var optionOne: TextView
    private lateinit var optionTwo: TextView
    private lateinit var optionThree: TextView
    private lateinit var optionFour: TextView

    private var optionSubmitted: Boolean = false

    private lateinit var submitButton: Button
    private lateinit var explanationButton: CardView

    private lateinit var progressBar: ProgressBar
    private lateinit var progressTextView: TextView
    private lateinit var questionTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_quiz_question, container, false)

        (activity as AppCompatActivity).supportActionBar?.hide()

        //get questions list from constants, shuffle list and set the list size to 10
        mQuestionsList = get10ShuffledQuestions(Constants.getQuestions())

        optionOne = view.findViewById(R.id.tv_option_one)
        optionTwo = view.findViewById(R.id.tv_option_two)
        optionThree = view.findViewById(R.id.tv_option_three)
        optionFour = view.findViewById(R.id.tv_option_four)

        submitButton = view.findViewById(R.id.button_submit)
        explanationButton = view.findViewById(R.id.cv_quiz_explanation)

        progressBar = view.findViewById(R.id.progressBar)
        progressBar.progressTintList = ColorStateList.valueOf(Color.parseColor("#E1FFE0"))
        progressTextView = view.findViewById(R.id.tv_progress)
        questionTextView = view.findViewById(R.id.tv_question)

        setQuestion()

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
        submitButton.setOnClickListener(this)
        explanationButton.setOnClickListener(this)

        if(mSelectedOptionPosition == 0){
            submitButton.isClickable = false
        }

        return view
    }

    //set default look for buttons
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, optionOne)
        options.add(1, optionTwo)
        options.add(2, optionThree)
        options.add(3, optionFour)

        for (option in options){
            option.setTextColor(Color.parseColor("#232323"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(context!!, R.drawable.default_option_bg)
        }
    }

    private fun setQuestion(){
        val question = mQuestionsList[mCurrentPosition - 1]

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList.size){
            submitButton.text = getString(R.string.button_finish_text)
        }else{
            if (!optionSubmitted){
                submitButton.isClickable = false
            }
            submitButton.text = getString(R.string.button_submit_text)
        }

        //setting up progress bar from layout resource
        progressBar.progress = mCurrentPosition
        progressTextView.text = "$mCurrentPosition" + "/" + progressBar.max

        //setting up quiz text
        questionTextView.text = question.question
        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
        optionFour.text = question.optionFour
    }

    private fun get10ShuffledQuestions(list: ArrayList<Question>): ArrayList<Question> {
        list.shuffle()
        val newlist = list.subList(0, 10)
        return ArrayList(newlist)
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                optionOne.background = ContextCompat.getDrawable(context!!, drawableView)
            }
            2 -> {
                optionTwo.background = ContextCompat.getDrawable(context!!, drawableView)
            }
            3 -> {
                optionThree.background = ContextCompat.getDrawable(context!!, drawableView)
            }
            4 -> {
                optionFour.background = ContextCompat.getDrawable(context!!, drawableView)
            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuizQuestionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuizQuestionFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_one -> {
                selectedOptionView(optionOne, 1)
                submitButton.isClickable = true
            }
            R.id.tv_option_two -> {
                selectedOptionView(optionTwo, 2)
                submitButton.isClickable = true
            }
            R.id.tv_option_three -> {
                selectedOptionView(optionThree, 3)
                submitButton.isClickable = true
            }
            R.id.tv_option_four -> {
                selectedOptionView(optionFour, 4)
                submitButton.isClickable = true
            }
            R.id.cv_quiz_explanation -> {
                //TODO: dialog is ugly and should not be used to display info, find better view (card shared element transition?)
                val dialog = Dialog(context!!)
                dialog.setContentView(R.layout.explanation_dialog)
                dialog.setCancelable(true)
                dialog.findViewById<TextView>(R.id.tv_explanation).text = mQuestionsList[mCurrentPosition - 1].explanation
                dialog.show()
            }
            R.id.button_submit -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    optionSubmitted = false
                    optionClickable()

                    when{
                        // set next question when it's not end of list
                        mCurrentPosition <= mQuestionsList.size ->{
                            explanationButton.visibility = View.INVISIBLE
                            setQuestion()
                        }else -> {
                            val bundle = Bundle()
                            bundle.putInt(Constants.TOTAL_QUESTIONS, mQuestionsList.size)
                            bundle.putInt(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            findNavController().navigate(R.id.action_quizQuestionFragment_to_quizResultFragment, bundle)
                        }
                    }
                }else{
                    // if user selected option
                    val question = mQuestionsList[mCurrentPosition - 1]
                    // wrong answer selected
                    if(question.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_bg)
                    }else{
                        //right answer selected
                        mCorrectAnswers ++
                    }
                    // in both cases set correct answer view
                    answerView(question.correctAnswer, R.drawable.correct_option_bg)

                    //end of quiz
                    if(mCurrentPosition == mQuestionsList.size){
                        explanationButton.visibility = View.VISIBLE
                        submitButton.text = getString(R.string.button_finish_text)
                    }else{
                        explanationButton.visibility = View.VISIBLE
                        submitButton.text = getString(R.string.button_next_text)

                        //user can not change answer after submitting
                        optionSubmitted = true
                        optionClickable()
                    }
                    // reset selected option
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    //set style for selected button, called in onClick event
    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int){
        defaultOptionsView() //switching to another option resets previous button to default
        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#292929"))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(context!!, R.drawable.selected_option_bg)
    }

    private fun optionClickable(){
        if (optionSubmitted){
            optionOne.isClickable = false
            optionTwo.isClickable = false
            optionThree.isClickable = false
            optionFour.isClickable = false
        }else{
            optionOne.isClickable = true
            optionTwo.isClickable = true
            optionThree.isClickable = true
            optionFour.isClickable = true
        }
    }
}