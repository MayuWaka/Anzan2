package app.wakayama.tama.anzan2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        //クイズ画面から問題を受け取る
        val displayQuestion = intent.getStringExtra("question")
        //クイズ画面から入力された数字を受け取る
        val yourAnswer = intent.getStringExtra("answer")
        //クイズ画面正解の数字を受け取る
        val correctAnswer = intent.getStringExtra("correct")

        //問題をTextViewに反映する
        questionText.text = displayQuestion
        //入力された数字をTextViewに反映する
        yourAnswerText.text = yourAnswer

        if (yourAnswer == correctAnswer){
            //正解の時、○の画像をImageViewに反映する
            markImage.setImageResource(R.drawable.correct_image)
            //正解の時、正解のランディ画像をImageViewに反映する
            randyImage.setImageResource(R.drawable.randy_happy_image)
        } else{
            //不正解の時×のイメージをImageViewに
            markImage.setImageResource(R.drawable.miss_image)
            randyImage.setImageResource(R.drawable.randy_sad_image)
        }

        //もどるボタンがタップされた時
        backButton.setOnClickListener {
            //クイズ画面を表示する画面に情報を送る変数を準備する
            val questionPage = Intent(this,MainActivity::class.java)
            //クイズ画面を起動する
            startActivity(questionPage)
            //答え合わせ画面を閉じる
            finish()
        }
    }
}
