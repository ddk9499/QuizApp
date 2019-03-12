package uz.dkamaloff.quizapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val question: Question = Question("Quyosh G\'arbdan chiqadi", false)

		question_tv.text = question.questionText

		true_btn.setOnClickListener {
			if (question.answer == true) {
				showToast("Sizning javobingiz to\'g\'ri")
			} else {
				showToast("Sizning javobingiz noto\'g\'ri")
			}
		}

		false_btn.setOnClickListener {
			if (question.answer == false) {
				showToast("Sizning javobingiz to\'g\'ri")
			} else {
				showToast("Sizning javobingiz noto\'g\'ri")
			}
		}
	}


	private fun showToast(message: String) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
	}

}
