package org.ajavierfm7.horario


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.ajavierfm7.horario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var subjectAdapter: SubjectAdapter
    private val subjects = mutableListOf<Subject>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar RecyclerView
        subjectAdapter = SubjectAdapter(subjects)
        binding.rvSubjects.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = subjectAdapter
        }

        // Configurar botón para agregar materias
        binding.btnAddSubject.setOnClickListener {
            val name = binding.etSubjectName.text.toString()
            val professor = binding.etProfessor.text.toString()
            val classroom = binding.etClassroom.text.toString()
            val day = binding.etDay.text.toString()
            val time = binding.etTime.text.toString()

            if (name.isNotEmpty() && professor.isNotEmpty() && classroom.isNotEmpty() &&
                day.isNotEmpty() && time.isNotEmpty()) {
                val subject = Subject(name, professor, classroom, day, time)
                subjectAdapter.addSubject(subject)

                // Limpiar campos
                binding.etSubjectName.text.clear()
                binding.etProfessor.text.clear()
                binding.etClassroom.text.clear()
                binding.etDay.text.clear()
                binding.etTime.text.clear()
            }
        }
    }
}