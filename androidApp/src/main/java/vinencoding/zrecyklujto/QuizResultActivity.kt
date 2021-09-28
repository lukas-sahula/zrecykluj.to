package vinencoding.zrecyklujto

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import vinencoding.zrecyklujto.utils.Constants


class QuizResultActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        val score = findViewById<TextView>(R.id.tv_score)
        score.text = "Skóre je $correctAnswers z $totalQuestions."

        val button = findViewById<Button>(R.id.finish_button)
        button.setOnClickListener{
            finish()
        }
    }
}
