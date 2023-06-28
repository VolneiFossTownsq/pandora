package io.townsq.pandora.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import io.townsq.pandora.R
import io.townsq.pandora.data.models.Record

class CreateRecordAdapter : RecyclerView.Adapter<CreateRecordAdapter.CreateRecordViewHolder>() {
    private var recordList = listOf<Record>()
    private var selectedItemPosition = -1

    fun setRecords(recordList: List<Record>) {
        this.recordList = recordList
        notifyDataSetChanged()
    }

    fun updateSelectedItemPosition(position: Int) {
        selectedItemPosition = position
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateRecordViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_item_record_vehicle, parent, false)
        return CreateRecordViewHolder(itemView)
    }

    override fun getItemCount() = recordList.size

    override fun onBindViewHolder(holder: CreateRecordViewHolder, position: Int) {
        val currentItem = recordList[position]
        holder.bind(currentItem, position, selectedItemPosition)
    }

    inner class CreateRecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val vehicleSelect: RadioButton = itemView.findViewById(R.id.vehicleSelect)
        private val vehicleSelected: View = itemView.findViewById(R.id.vehicleSelected)
        private val vehicleName: TextView = itemView.findViewById(R.id.vehicleName)
        private val licensePlate: TextView = itemView.findViewById(R.id.licensePlate)

        fun bind(record: Record, position: Int, selectedItemPosition: Int) {
            vehicleName.text = record.vehicle.name
            licensePlate.text = record.vehicle.licensePlate

            vehicleSelect.isChecked = position == selectedItemPosition

            vehicleSelect.setOnClickListener {
                updateSelectedItemPosition(position)
            }

            vehicleSelected.isVisible = position == selectedItemPosition
        }
    }
}
