package com.example.service

import android.content.Intent
import android.icu.text.DateFormat.MEDIUM
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.RenderScript
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_e__dhuhur.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.back
import org.json.JSONArray
import org.json.JSONObject
import java.text.DateFormat.MEDIUM

class E_Dhuhur : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e__dhuhur)

        getdariserver()

        val context = this
        back.setOnClickListener {
            val intent = Intent(context, Home::class.java)
            startActivity(intent)
            finish()
        }

        btnSimpanDhuhur.setOnClickListener {

            var data_isiDhuhur = txtDhuhur.text.toString()

            postkeserver(data_isiDhuhur)

            val backmarquee = Intent(context, MainActivity::class.java)
            startActivity(backmarquee)
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
                        Log.e("_kotlinTitle", jsonObject.optString("dhuhur"))


                        txt22.setText(jsonObject.optString("dhuhur"))


                    }
                }

                override fun onError(anError: ANError) { // handle error
                    Log.i("_err", anError.toString())
                }
            })
    }


    fun postkeserver(data1:String){

        AndroidNetworking.post("http://192.168.0.7/jamsholat/proses-dhuhur.php")
            .addBodyParameter("dhuhur", data1)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {
//                  do anything with response
                }

                override fun onError(anError: ANError?) {
                    // handle error
                }
            })
    }


}
