package io.townsq.pandora.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.townsq.pandora.R
import io.townsq.pandora.data.models.Record
import io.townsq.pandora.data.models.RecordType
import io.townsq.pandora.databinding.ListItemBinding
import io.townsq.pandora.utils.DateFormat

class RecordAdapter(private val onRecordCardClicked: (String) -> Unit) :
    RecyclerView.Adapter<RecordAdapter.RegisterViewHolder>() {

    private var binding: ListItemBinding? = null
    private var recordList: List<Record> = listOf()
    private var filteredList: MutableList<Record> = mutableListOf()

    init {
        filteredList.addAll(recordList)
    }

    fun setRecords(newRecords: List<Record>) {
        recordList = newRecords
        filteredList.clear()
        filteredList.addAll(recordList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegisterViewHolder {
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RegisterViewHolder(binding?.root)
    }

    override fun getItemCount(): Int = filteredList.size

    override fun onBindViewHolder(holder: RegisterViewHolder, position: Int) {
        val currentItem = filteredList[position]
        holder.bind(currentItem, onRecordCardClicked)
    }

    inner class RegisterViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {

        private var imgRegister: ImageView? = binding?.imgRegister
        private var dateRegister: TextView? = binding?.dateRegister
        private var infoVehicle: TextView? = binding?.infoVehicle
        private var infoDriver: TextView? = binding?.infoDriver

        fun bind(record: Record, onRecordCardClicked: (String) -> Unit) {

            val dateString = record.recordDate
            val formatter = DateFormat()
            val date = formatter.formatDate(dateString)

            imgRegister?.setImageResource(iconForEachRecordType(record.recordType))
            dateRegister?.text = date
            infoDriver?.text =
                "${record.vehicle.driver.firstName} " + "${record.vehicle.driver.lastName}"
            infoVehicle?.text = record.vehicle.name

            itemView.setOnClickListener {
                onRecordCardClicked(record.id)
            }
        }

        private fun iconForEachRecordType(recordType: RecordType): Int {
            return when (recordType) {
                RecordType.MAINTENANCE -> R.drawable.ic_maintenance
                RecordType.SHIFT -> R.drawable.ic_shift
                RecordType.GAS -> R.drawable.ic_gas_station
            }
        }
    }
}
