package io.townsq.pandora.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import io.townsq.pandora.data.Record
import io.townsq.pandora.databinding.CardItemRecordVehicleBinding
import io.townsq.pandora.ui.createRecord.RecordViewModel

class CreateRecordAdapter(private val viewModel: RecordViewModel) :
    RecyclerView.Adapter<CreateRecordAdapter.CreateRecordViewHolder>() {

    private var binding: CardItemRecordVehicleBinding? = null
    private var recordList = listOf<Record>()

    fun setRecords(recordList: List<Record>) {
        this.recordList = recordList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateRecordViewHolder {
        binding =
            CardItemRecordVehicleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CreateRecordViewHolder(binding!!.root)
    }

    override fun getItemCount() = recordList.size

    override fun onBindViewHolder(holder: CreateRecordViewHolder, position: Int) {
        val currentItem = recordList[position]
        holder.bind(currentItem, position)
    }

    inner class CreateRecordViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var vehicleSelect: RadioButton? = binding?.vehicleSelect
        private var vehicleSelected: View? = binding?.vehicleSelected
        private var vehicleName: TextView? = binding?.VehicleName
        private var licensePlate: TextView? = binding?.licensePlate

        fun bind(record: Record, position: Int) {
            vehicleName?.text = record.vehicle.name
            licensePlate?.text = record.vehicle.licensePlate

            vehicleSelect?.isChecked = position == viewModel.selectedItemPosition.value

            vehicleSelect?.setOnClickListener {
                viewModel.updateSelectedItemPosition(position)
                notifyDataSetChanged()
            }

            viewModel.selectedItemPosition.observe(itemView.context as LifecycleOwner) { selectedPosition ->
                vehicleSelected?.isVisible = position == selectedPosition
            }
        }
    }
}
