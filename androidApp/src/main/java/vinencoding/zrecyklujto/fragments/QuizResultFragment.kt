package vinencoding.zrecyklujto.fragments

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import vinencoding.zrecyklujto.R
import vinencoding.zrecyklujto.utils.Constants

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_quiz_result, container, false)

        (activity as AppCompatActivity).supportActionBar?.show()

        val bundle = this.arguments
        if(bundle != null){
            val correctAnswers = arguments?.getInt(Constants.CORRECT_ANSWERS)
            val totalQuestions = arguments?.getInt(Constants.TOTAL_QUESTIONS)

            view.findViewById<TextView>(R.id.tv_score).text = resources.getString(R.string.score, correctAnswers.toString(), totalQuestions.toString())
        }

        view.findViewById<Button>(R.id.finish_button).setOnClickListener{
            findNavController().navigate(R.id.action_quizResultFragment_to_homeFragment)
        }

        return view
    }


    //override back button, app crashes when using back button in this fragment
    //TODO: check lifecycle of fragments to find better solution (pop stack of fragments in nav controller?
    override fun onResume() {
        super.onResume()
        this.view!!.isFocusableInTouchMode = true
        this.view!!.requestFocus()
        this.view!!.setOnKeyListener { _: View, keyCode: Int, _: KeyEvent ->
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                findNavController().navigate(R.id.action_quizResultFragment_to_homeFragment)
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuizResultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuizResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}