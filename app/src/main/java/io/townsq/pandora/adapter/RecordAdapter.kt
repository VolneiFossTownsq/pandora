package io.townsq.pandora.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.townsq.pandora.R
import io.townsq.pandora.data.Record
import io.townsq.pandora.data.RecordType
import io.townsq.pandora.databinding.ListItemBinding

class RecordAdapter() : RecyclerView.Adapter<RecordAdapter.RegisterViewHolder>() {

    private var binding: ListItemBinding? = null
    private var record: List<Record> = listOf()
    private var recordFilter = ArrayList<Record>()

    init {
        recordFilter.addAll(record)
    }

    fun filterByRecordType(recordType: RecordType) {
        record = recordFilter.filter { it.recordType == recordType }
        notifyDataSetChanged()
    }

    fun setRecords(newRecords: List<Record>) {
        record = newRecords
        recordFilter.clear()
        recordFilter.addAll(newRecords)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegisterViewHolder {
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RegisterViewHolder(binding!!.root)
    }

    override fun getItemCount(): Int = record.size

    override fun onBindViewHolder(holder: RegisterViewHolder, position: Int) {
        val currentItem = record[position]
        holder.bind(currentItem)
    }

    inner class RegisterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var imgRegister: ImageView = binding!!.imgRegister
        private var dateRegister: TextView = binding!!.dateRegister
        private var infoVehicle: TextView = binding!!.infoVehicle
        private var infoDriver: TextView = binding!!.infoDriver

        fun bind(record: Record) {
            imgRegister.setImageResource(iconForEachRecordType(record.recordType))
            dateRegister.text = record.recordDate.toString()
            infoDriver.text = record.vehicle.driver.firstName
            infoVehicle.text = record.vehicle.name
        }

        private fun iconForEachRecordType(recordType: RecordType): Int {
            return when (recordType) {
                RecordType.MAINTENANCE -> R.drawable.ic_maintenance
                RecordType.SHIFT_START, RecordType.SHIFT_END -> R.drawable.ic_shift
                RecordType.GAS -> R.drawable.ic_gas_station
            }
        }
    }
}