package com.arifsamsudin.recycleview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.arifsamsudin.recycleview.adapter.AdapterTeamBola
import com.arifsamsudin.recycleview.databinding.ActivityMainBinding
import com.arifsamsudin.recycleview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listItemPemainBinding = ArrayList<Pemain>()
        listItemPemainBinding.add(Pemain("Thibaut Courtois", R.drawable.courtois, "Penjaga Gawang", "2.00 m", "Bree (Belgia)", "11 Mei 1992"))
        listItemPemainBinding.add(Pemain("Karim Benzema", R.drawable.benzema, "Penyerang", "1,85 m", "Lyon (Perancis)", "19 Desember 1987"))
        listItemPemainBinding.add(Pemain("Marcelo Vieira da Silva", R.drawable.marcello, "Belakang", "1,74 m", "Rio de Janeiro (Brasil)", "12 Mei 1988"))
        listItemPemainBinding.add(Pemain("Sergio Ramos García", R.drawable.ramos, "Belakang", "1,84 m", "Camas (Sevilla)", "30 Maret 1986"))
        listItemPemainBinding.add(Pemain("Zinedine Yazid Zidane", R.drawable.zidan, "Pelatih", "1,85 m", "Marseille (Prancis)", "23 Juni 1972"))

        binding.list.adapter = AdapterTeamBola(this, listItemPemainBinding, object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image =this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                    val posisi = this.findViewById<TextView>(R.id.txtposisi)
                    val tinggi = this.findViewById<TextView>(R.id.txttinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txttempatlahir)
                    val tanggallahir = this.findViewById<TextView>(R.id.txttanggallahir)

                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggibadan}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tanggallahir.text = "${item?.tanggallahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }
        })
    }

}