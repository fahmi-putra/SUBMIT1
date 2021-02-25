package com.example.submit1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class AnggotaAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var anggotaes = arrayListOf<Anggota>()

    override fun getCount(): Int = anggotaes.size

    override fun getItem(i: Int): Anggota = anggotaes[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_anggota, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val anggota = getItem(position)
        viewHolder.bind(anggota)
        return itemView
    }

    private inner class ViewHolder(view: View) {
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtLocation: TextView = view.findViewById(R.id.txt_location)

        fun bind(anggota: Anggota) {
            imgPhoto.setImageResource(anggota.photo)
            txtName.text = anggota.name
            txtLocation.text = anggota.location

        }
    }
}

