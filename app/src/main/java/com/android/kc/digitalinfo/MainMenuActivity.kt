package com.android.kc.digitalinfo

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.android.kc.digitalinfo.adapter.menuAdapter
import com.android.kc.digitalinfo.adapter.opAdapter
import com.android.kc.digitalinfo.modul.pojo
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {

    //list event
    private val eventList = ArrayList<pojo>()

    //operator
    val listOp: ArrayList<String> = ArrayList()

    private var mTema: String? = null
    private var mInstansi: String? = null
    private var mKeterangan: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        EventData()
        initComponent()

        buttonLogProses.setOnClickListener {
/*            val intent = Intent(applicationContext, Main3Activity::class.java)
            startActivity(intent)*/

            Toast.makeText(this, "Click Log Proses ", Toast.LENGTH_SHORT).show()
        }

        buttonLogSelesai.setOnClickListener {
            Toast.makeText(this, "Click Log Selesai ", Toast.LENGTH_SHORT).show()
        }

    }

    fun initComponent(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = menuAdapter(eventList, this)

        recyclerView.addOnItemTouchListener(
                RecyclerItemClickListener(this, object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        mInstansi = eventList.get(position).title
                        mTema = eventList.get(position).tema
                        mKeterangan = eventList.get(position).tema
                        initDialogLoading()
                    }
                })
        )
    }

    private fun EventData() {
        var movie = pojo("PT. Ammase Sejati", "10/12/2018", "Before using CoordinatorLayout in your app, you must import the Android Support Design Library into your project, by adding the following dependency", "Ballroom Lt 6", "2")
        eventList.add(movie)

        movie = pojo("CV Toko Koding Cupu", "10/12/2018", "Before using CoordinatorLayout in your app, you must import the Android Support Design Library into your project, by adding the following dependency to your app build.gradle file", "Ballroom Lt 6", "20/03/2018")
        eventList.add(movie)

        movie = pojo("PT. Ammmse Sejati", "11/12/2018", "Before using CoordinatorLayout in your app, you must import the Android Support Design Library into your project, by adding the following dependency to your app build.gradle file", "Ballroom Lt 17", "20/03/2018")
        eventList.add(movie)

        movie = pojo("PT. Ammmse Sejati", "12/12/2018", "Before using CoordinatorLayout in your app, you must import the Android Support Design Library into your project, by adding the following dependency to your app build.gradle file", "Condotel 2 Lt 7", "20/03/2018")
        eventList.add(movie)

        movie = pojo("PT. Ammase Sejati", "13/12/2018", "Before using CoordinatorLayout in your app, you must import the Android Support Design Library into your project, by adding the following dependency to your app build.gradle file", "Condotel 2 Lt 3", "20/03/2018")
        eventList.add(movie)

        movie = pojo("PT. Ammase Sejati", "14/12/2018", "Before using CoordinatorLayout in your app, you must import the Android Support Design Library into your project, by adding the following dependency to your app build.gradle file", "Condotel 2 Lt 5", "20/03/2018")
        eventList.add(movie)
    }

    private fun AdminData(){
        listOp.add("Agie Design")
        listOp.add("Rama Design")
        listOp.add("Candra Design")
        listOp.add("Yudi IT")
        listOp.add("Sari Editor")
        listOp.add("Rifki AutoCat")
        listOp.add("Kiki Humas")
    }

    private fun initDialogLoading() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.layout_respon)
        dialog.setTitle("Custom Dialog")
        dialog.setCancelable(false)
        AdminData()
        val recyclerView = dialog.findViewById<View>(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = opAdapter(listOp, this)

        val _Instansi = dialog.findViewById<View>(R.id.textViewInstansi) as TextView
        val _Tema = dialog.findViewById<View>(R.id.textViewTema) as TextView
        val _Keterangan = dialog.findViewById<View>(R.id.textViewKeterangan) as TextView

        _Instansi.setText(mInstansi)
        _Tema.setText(mTema)
        _Keterangan.setText(mKeterangan)

        val imageButtonClose = dialog.findViewById<View>(R.id.imageButtonClose) as ImageButton
        imageButtonClose.setOnClickListener { dialog.dismiss() }

        dialog.show()
    }
}
