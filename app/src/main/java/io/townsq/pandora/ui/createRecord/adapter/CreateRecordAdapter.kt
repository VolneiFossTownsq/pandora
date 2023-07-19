package io.townsq.pandora.ui.createRecord.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import io.townsq.pandora.R
import io.townsq.pandora.data.models.Vehicle

class CreateRecordAdapter(private val onVehicleSelected: (Vehicle) -> Unit) :
    RecyclerView.Adapter<CreateRecordAdapter.CreateRecordViewHolder>() {

    private var selectedItemPosition = -1
    private var vehicleList: List<Vehicle> = listOf()


    fun setVehicleList(vehicleList: List<Vehicle>) {
        this.vehicleList = vehicleList
    }

    fun updateSelectedItemPosition(position: Int) {
        selectedItemPosition = position
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateRecordViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item_record_vehicle, parent, false)
        return CreateRecordViewHolder(itemView)
    }

    override fun getItemCount() = vehicleList.size

    override fun onBindViewHolder(holder: CreateRecordViewHolder, position: Int) {
        val currentItem = vehicleList[position]
        holder.bind(currentItem, position, selectedItemPosition)
    }

    inner class CreateRecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val vehicleSelect: RadioButton = itemView.findViewById(R.id.vehicleSelect)
        private val vehicleSelected: View = itemView.findViewById(R.id.vehicleSelected)
        private val vehicleName: TextView = itemView.findViewById(R.id.vehicleName)
        private val licensePlate: TextView = itemView.findViewById(R.id.licensePlate)

        fun bind(vehicle: Vehicle, position: Int, selectedItemPosition: Int) {
            vehicleName.text = vehicle.name
            licensePlate.text = vehicle.licensePlate

            vehicleSelect.isChecked = position == selectedItemPosition

            vehicleSelect.setOnClickListener {
                updateSelectedItemPosition(position)
                onVehicleSelected(vehicle)
            }

            vehicleSelected.isVisible = position == selectedItemPosition
        }
    }
}
