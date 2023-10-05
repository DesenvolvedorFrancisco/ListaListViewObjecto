package dev.francisco.listalistviewobjeto

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import dev.francisco.listalistviewobjeto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listaUtilizador = ArrayList<Utilizador>()
        listaUtilizador.add(Utilizador("paulo","pass"))
        listaUtilizador.add(Utilizador("andre","pwd123"))
        listaUtilizador.add(Utilizador("marques","bbb"))

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listaUtilizador)
        binding.listviewUtilizadores.adapter = adapter

        binding.listviewUtilizadores.setOnItemClickListener { _, _, position, _ ->
            binding.editUsername.setText(listaUtilizador.get(position).username)
            binding.editPassword.setText(listaUtilizador.get(position).password)
        }

    }
}