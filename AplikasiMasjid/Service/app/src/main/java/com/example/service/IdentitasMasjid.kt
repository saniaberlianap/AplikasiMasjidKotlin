package com.example.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_identitas_masjid.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pengumuman.*
import org.json.JSONArray
import org.json.JSONObject

class IdentitasMasjid : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identitas_masjid)

        getdariserver()

        val context = this
        backIdentitas.setOnClickListener {
            val intent = Intent(context, Home::class.java)
            startActivity(intent)
            finish()
        }

        btnSimpanMasjid.setOnClickListener {

            var data_namaMasjid = txtIdentitas1.text.toString()
            var data_alamatMasjid = txtIdentitas2.text.toString()

            postkeserver(data_namaMasjid, data_alamatMasjid)

            val intent = Intent(context, Home::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun getdariserver(){

        AndroidNetworking.get("http://192.168.0.7/jamsholat/identitas-masjid.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) { // do anything with response
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray= response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject= jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("nama_masjid"))
                        Log.e("_kotlinTitle", jsonObject.optString("alamat_masjid"))

                        nama_masjid.setText(jsonObject.optString("nama_masjid"))
                        alamat_masjid.setText(jsonObject.optString("alamat_masjid"))

                    }
                }

                override fun onError(anError: ANError) { // handle error
                    Log.i("_err", anError.toString())
                }
            })
    }


    fun postkeserver(data1:String, data2:String){

        AndroidNetworking.post("http://192.168.0.7/jamsholat/proses-identitas.php")
            .addBodyParameter("nama_masjid", data1)
            .addBodyParameter("alamat_masjid", data2)
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


