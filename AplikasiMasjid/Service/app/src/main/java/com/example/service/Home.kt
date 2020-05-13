package com.example.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.isi
import kotlinx.android.synthetic.main.activity_marquee.*
import org.json.JSONObject

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getdariserver()
        isi.setSelected(true)

        val context = this

        jSholat.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        iMasjid.setOnClickListener {
            val intent = Intent(context, IdentitasMasjid::class.java)
            startActivity(intent)
            finish()
        }

        marq.setOnClickListener {
            val intent = Intent(context, Marquee::class.java)
            startActivity(intent)
            finish()
        }

        umuman.setOnClickListener {
            val intent = Intent(context, Pengumuman::class.java)
            startActivity(intent)
            finish()
        }

        slide.setOnClickListener {
            val intent = Intent(context, SlideShow::class.java)
            startActivity(intent)
            finish()
        }

        tag.setOnClickListener {
            val intent = Intent(context, Tagline::class.java)
            startActivity(intent)
            finish()
        }


    }


    fun getdariserver(){

        AndroidNetworking.get("http://192.168.0.7/jamsholat/marquee.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) { // do anything with response
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray= response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject= jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("isi_marquee"))


                        isi.setText(jsonObject.optString("isi_marquee"))

                    }
                }

                override fun onError(anError: ANError) { // handle error
                    Log.i("_err", anError.toString())
                }
            })
    }

}
