package jp.sabakaido.okhttp_sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textview = findViewById(R.id.textView) as TextView

        // 実行
        MainService().provide(object : MainService.Callback {
            override fun success() {
                textview.text = "success"
            }
        })
    }
}
