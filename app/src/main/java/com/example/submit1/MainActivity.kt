package com.example.submit1

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: AnggotaAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var dataUsername: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataRepository: IntArray
    private lateinit var dataFollowers: IntArray
    private lateinit var dataFollowings: IntArray
    private var anggotaes = arrayListOf<Anggota>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView: ListView = findViewById(R.id.lv_list)
        adapter = AnggotaAdapter(this)
        listView.adapter = adapter



        prepare()
        addItem()




        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            //pindah activity dengan intent parcelable
            val moveIntent = Intent(this@MainActivity, DetailAnggota::class.java) //kotak tujuan pindahnya
            moveIntent.putExtra(DetailAnggota.DETAIL_DATA, anggotaes[position]) //data yang mau dikirim/pindah


            startActivity(moveIntent) //aksi pindah

        }

    }

    private fun prepare() {
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        dataName = resources.getStringArray(R.array.data_name)
        dataLocation = resources.getStringArray(R.array.data_location)
        dataUsername = resources.getStringArray(R.array.data_username)
        dataCompany = resources.getStringArray(R.array.data_company)

        dataRepository = resources.getIntArray(R.array.data_repository)
        dataFollowers = resources.getIntArray(R.array.data_followers)
        dataFollowings = resources.getIntArray(R.array.data_followings)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val anggota = Anggota(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataLocation[position],
                dataUsername[position],
                dataCompany[position],
                dataRepository[position],
                dataFollowers[position],
                dataFollowings[position]
            )
            anggotaes.add(anggota)
        }
        adapter.anggotaes = anggotaes
    }
}