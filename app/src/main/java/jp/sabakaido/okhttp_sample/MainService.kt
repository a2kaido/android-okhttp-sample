package jp.sabakaido.okhttp_sample

import android.os.AsyncTask
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Created by anikaido on 2017/06/07.
 */
class MainService {
    interface Callback {
        fun success()
    }

    /**
     * 処理するよ
     */
    fun provide(callback: Callback) {
        MainAsyncTask(callback).execute()
    }

    /**
     * 非同期処理やるよ
     */
    class MainAsyncTask(val callback: Callback) : AsyncTask<Void, Void, String?>() {

        override fun doInBackground(vararg params: Void?): String? {
            val client = OkHttpClient()

            val request = Request.Builder()
                    .url("http://example.com/")
                    .build()

            val response = client.newCall(request).execute()

            return response.body()?.string()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            callback.success()
        }
    }
}