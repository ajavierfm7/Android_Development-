package org.ajavierfm7.mycamara

import android.content.res.Configuration
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import org.ajavierfm7.mycamara.databinding.ActivityMainBinding
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var currentPhotoPath: String
    private lateinit var photoURI: Uri

    private val takePictureLauncher =
        this.registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
            if (success) {
                val bitmap = BitmapFactory.decodeFile(currentPhotoPath)
                binding.imageView.setImageBitmap(bitmap)
            } else {
                Toast.makeText(this, "La foto no fue tomada", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTomarFoto.setOnClickListener {
            dispatchTakePictureIntent()
        }

        binding.btnGuardar.setOnClickListener {
            val description = binding.editDescription.text.toString()
            if (::currentPhotoPath.isInitialized && description.isNotEmpty()) {
                Toast.makeText(
                    this,
                    "Imagen guardada con descripción: $description",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(this, "Falta foto o descripción", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnModoClaro.setOnClickListener {
            binding.mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            Toast.makeText(this, "Modo Claro Activado", Toast.LENGTH_SHORT).show()
        }

        binding.btnModoOscuro.setOnClickListener {
            binding.mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
            Toast.makeText(this, "Modo Oscuro Activado", Toast.LENGTH_SHORT).show()
        }

        binding.btnEsp.setOnClickListener {
            setLocale("es")
        }

        binding.btnEng.setOnClickListener {
            setLocale("en")
        }


    }

    private fun dispatchTakePictureIntent() {
        val photoFile: File? = createImageFile()
        photoFile?.also {
            photoURI = FileProvider.getUriForFile(
                this,
                "${packageName}.fileprovider",
                it
            )
            takePictureLauncher.launch(photoURI)
        }
    }

    private fun createImageFile(): File {
        val timeStamp: String =
            SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir: File? = getExternalFilesDir("Pictures")
        return File.createTempFile(
            "IMG_${timeStamp}_",
            ".jpg",
            storageDir
        ).apply {
            currentPhotoPath = absolutePath
        }
    }

    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = Configuration()
        config.setLocale(locale)

        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val intent = intent
        finish()
        startActivity(intent)
    }

}
