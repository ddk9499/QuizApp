package uz.dkamaloff.quizapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_cheat.*

class CheatActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_cheat)

		val javob = intent.getBooleanExtra(answerKey, false)

		show_answer_btn.setOnClickListener {
			show_answer_btn.visibility = View.GONE
			answer_tv.visibility = View.VISIBLE
			answer_tv.text = "$javob"
			val intent = Intent()
			intent.putExtra(cheaterKey, true)
			setResult(Activity.RESULT_OK, intent)
		}
	}

	companion object {
		private val answerKey = "answer"
		private val cheaterKey = "cheater"

		fun newIntent(context: Context, answer: Boolean): Intent {
			val intent = Intent(context, CheatActivity::class.java)
			intent.putExtra(answerKey, answer)
			return intent
		}

		fun wasAnswerShown(data: Intent): Boolean {
			return data.getBooleanExtra(cheaterKey, false)
		}
	}
}
