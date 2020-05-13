package com.example.service

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getdariserver()

        val context = this
        back.setOnClickListener {
            val intent = Intent(context, Home::class.java)
            startActivity(intent)
            finish()
        }

        editShubuh.setOnClickListener {
            val intent = Intent(context, E_Shubuh::class.java)
            startActivity(intent)
            finish()
        }

        editDhuhur.setOnClickListener {
            val intent = Intent(context, E_Dhuhur::class.java)
            startActivity(intent)
            finish()
        }

        editAshar.setOnClickListener {
            val intent = Intent(context, E_Ashar::class.java)
            startActivity(intent)
            finish()
        }

        editMaghrib.setOnClickListener {
            val intent = Intent(context, E_Maghrib::class.java)
            startActivity(intent)
            finish()
        }


        editIsha.setOnClickListener {
            val intent = Intent(context, E_Isha::class.java)
            startActivity(intent)
            finish()
        }

        editDhuha.setOnClickListener {
            val intent = Intent(context, E_Dhuha::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun getdariserver(){

        AndroidNetworking.get("http://192.168.0.7/jamsholat/jadwal-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) { // do anything with response
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray= response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject= jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("shubuh"))
                        Log.e("_kotlinTitle", jsonObject.optString("dhuhuur"))
                        Log.e("_kotlinTitle", jsonObject.optString("ashar"))
                        Log.e("_kotlinTitle", jsonObject.optString("maghrib"))
                        Log.e("_kotlinTitle", jsonObject.optString("isha"))
                        Log.e("_kotlinTitle", jsonObject.optString("dhuha"))


                        txt1.setText(jsonObject.optString("shubuh"))
                        txt2.setText(jsonObject.optString("dhuhur"))
                        txt3.setText(jsonObject.optString("ashar"))
                        txt4.setText(jsonObject.optString("maghrib"))
                        txt5.setText(jsonObject.optString("isha"))
                        txt6.setText(jsonObject.optString("dhuha"))


                        
                    }
                }

                override fun onError(anError: ANError) { // handle error
                    Log.i("_err", anError.toString())
                }
            })
    }
}