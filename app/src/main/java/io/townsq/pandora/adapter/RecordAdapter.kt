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

class RecordAdapter() : RecyclerView.Adapter<RecordAdapter.RegisterViewHolder>() {

    private var record: List<Record> = listOf()
    private  var recordFilter = ArrayList<Record>()

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
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return RegisterViewHolder(view)
    }

    override fun getItemCount(): Int = record.size

    override fun onBindViewHolder(holder: RegisterViewHolder, position: Int) {
        val currentItem = record[position]
        holder.bind(currentItem)
    }

    inner class RegisterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var imgRegister: ImageView = view.findViewById(R.id.imgRegister)
        private var dateRegister: TextView = view.findViewById(R.id.dateRegister)
        private var infoVehicle: TextView = view.findViewById(R.id.infoVehicle)
        private var infoDriver: TextView = view.findViewById(R.id.infoDriver)

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