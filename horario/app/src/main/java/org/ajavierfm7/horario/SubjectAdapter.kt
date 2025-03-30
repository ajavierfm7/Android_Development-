package org.ajavierfm7.horario
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import org.ajavierfm7.horario.databinding.ItemSubjectBinding

class SubjectAdapter(private val subjects: MutableList<Subject>) :
    RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    inner class SubjectViewHolder(private val binding: ItemSubjectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(subject: Subject) {
            binding.tvSubjectName.text = subject.name
            binding.tvProfessor.text = "Profesor: ${subject.professor}"
            binding.tvClassroom.text = "Aula: ${subject.classroom}"
            binding.tvDay.text = "Día: ${subject.day}"
            binding.tvTime.text = "Horario: ${subject.time}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val binding = ItemSubjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.bind(subjects[position])
    }

    override fun getItemCount(): Int = subjects.size

    fun addSubject(subject: Subject) {
        subjects.add(subject)
        notifyItemInserted(subjects.size - 1)
    }
}