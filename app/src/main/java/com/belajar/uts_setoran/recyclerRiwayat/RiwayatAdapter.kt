package com.belajar.uts_setoran.recyclerRiwayat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.belajar.uts_setoran.R

class RiwayatAdapter(private val listRiwayat: List<riwayatrowdata>) :
    RecyclerView.Adapter<RiwayatAdapter.RiwayatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tablerow_riwayat, parent, false)
        return RiwayatViewHolder(view)
    }

    override fun onBindViewHolder(holder: RiwayatViewHolder, position: Int) {
        val riwayat = listRiwayat[position]
        holder.bind(riwayat)
    }

    override fun getItemCount(): Int {
        return listRiwayat.size
    }

    class RiwayatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val Nomor: TextView = itemView.findViewById(R.id.Noriw)
        private val tgl: TextView = itemView.findViewById(R.id.tgl_setoran)
        private val Surah: TextView = itemView.findViewById(R.id.surahriw)
        private val mulaiAyat: TextView = itemView.findViewById(R.id.mulaiAyat)
        private val akhirAyat: TextView = itemView.findViewById(R.id.akhirAyat)
        private val note: TextView = itemView.findViewById(R.id.note)
        private val stat: TextView = itemView.findViewById(R.id.Status)



        fun bind(rowData: riwayatrowdata) {
            Nomor.text = rowData.Nomor.toString()
            tgl.text = rowData.tgl
            Surah.text = rowData.Surah
            mulaiAyat.text = rowData.mulaiAyat
            akhirAyat.text = rowData.akhirAyat
            note.text = rowData.note
            stat.text = rowData.stat
        }
    }
}
data class riwayatrowdata(
    val Nomor: Int,
    val tgl: String,
    val Surah: String,
    val mulaiAyat: String,
    val akhirAyat: String,
    val note: String,
    val stat: String
)
