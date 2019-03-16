package uz.dkamaloff.quizapp

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

		val javob = intent.getBooleanExtra("answer", false)

		show_answer_btn.setOnClickListener {
			show_answer_btn.visibility = View.GONE
			answer_tv.visibility = View.VISIBLE
			answer_tv.text = "$javob"
		}
	}

	companion object {
		fun newIntent(context: Context, answer: Boolean): Intent {
			val intent = Intent(context, CheatActivity::class.java)
			intent.putExtra("answer", answer)
			return intent
		}
	}
}
