package com.example.submit1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView

class DetailAnggota : AppCompatActivity() {

    companion object {
        const val DETAIL_DATA = "detail_data"
    }

    //variable untuk menampung anggota
    private lateinit var anggota: Anggota

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_anggota)

        anggota = intent.getParcelableExtra<Anggota>(DETAIL_DATA) as Anggota  //nerima paket ANGGOTA dan taro di variable anggota

        // inisiasi layout view
        val photoLayout: CircleImageView = findViewById(R.id.imageView)
        val nameLayOut: TextView = findViewById(R.id.txt_name)
        val locationLayOut: TextView = findViewById(R.id.txt_location)
        val usernameLayout: TextView = findViewById(R.id.txt_UserName)
        val companyLayout: TextView = findViewById(R.id.txt_company)
        val repositoryLayout: TextView = findViewById(R.id.txt_repository)
        val followersLayout: TextView = findViewById(R.id.txt_followers)
        val followingsLayout: TextView = findViewById(R.id.txt_followings)


        //mengisi layout dengan data paket
        photoLayout.setImageResource(anggota.photo)
        nameLayOut.text = anggota.name
        locationLayOut.text =
            resources.getString(R.string.data_location, anggota.location.toString())
        usernameLayout.text =
            resources.getString(R.string.data_username, anggota.username.toString())
        companyLayout.text = resources.getString(R.string.data_company, anggota.company.toString())
        repositoryLayout.text =
            resources.getString(R.string.data_repository, anggota.repository.toString())
        followersLayout.text =
            resources.getString(R.string.data_followers, anggota.followers.toString())
        followingsLayout.text =
            resources.getString(R.string.data_followings, anggota.followings.toString())


    }
}