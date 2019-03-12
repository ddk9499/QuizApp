package uz.dkamaloff.quizapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	lateinit var question: Question
	var currentIndex = 0

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val questions = mutableListOf<Question>()
		questions.add(Question("Quyosh G\'arbdan chiqadi", false))
		questions.add(Question("Samarkand is the capital of Uzbekistan", false))
		questions.add(Question("Nil is the longest river", true))
		questions.add(Question("Current year is 2019", true))
		questions.add(Question("Moon is the planet", false))

		question = questions[currentIndex]

		question_tv.text = question.questionText

		true_btn.setOnClickListener {
			checkAnswer(true, question.answer)
		}

		false_btn.setOnClickListener {
			checkAnswer(false, question.answer)
		}

		next_btn.setOnClickListener {
			if (currentIndex == questions.size - 1) {
				currentIndex = 0
			} else {
				currentIndex = currentIndex % (questions.size - 1) + 1
			}
			question = questions[currentIndex]
			question_tv.text = question.questionText
		}
	}

	private fun checkAnswer(userPressed: Boolean, answer: Boolean) {
		if (userPressed == answer) {
			showToast("Sizning javobingiz to\'g\'ri")
		} else {
			showToast("Sizning javobingiz noto\'g\'ri")
		}
	}

	private fun showToast(message: String) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
	}

}
