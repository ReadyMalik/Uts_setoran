package com.belajar.uts_setoran.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.belajar.uts_setoran.R

class TableAdapter(private val data: List<tableData>) : RecyclerView.Adapter<TableAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_table_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rowData = data[position]
        holder.bind(rowData)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nomor: TextView = itemView.findViewById(R.id.nomor)
        private val surah: TextView = itemView.findViewById(R.id.surah)
        private val keterangan: TextView = itemView.findViewById(R.id.keterangan)
        private val paraf: TextView = itemView.findViewById(R.id.paraf)

        fun bind(rowData: tableData) {
            nomor.text = rowData.nomor.toString()
            surah.text = rowData.surah
            keterangan.text = rowData.keterangan
            paraf.text = rowData.paraf
        }
    }
}

data class tableData(
    val nomor: Int,
    val surah: String,
    val keterangan: String,
    val paraf: String
)
