package dev.francisco.listalistviewobjeto

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import dev.francisco.listalistviewobjeto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var pos = -1


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

            // pega a position do Username da password na lista

        binding.listviewUtilizadores.setOnItemClickListener { _, _, position, _ ->
            binding.editUsername.setText(listaUtilizador.get(position).username)
            binding.editPassword.setText(listaUtilizador.get(position).password)
            pos = position
        }

            // Insere um novo username e uma nova password

        binding.buttonInserir.setOnClickListener {
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            // edita o Username e a Password e mostra na tela

            if (!username.isEmpty() && !password.isEmpty()){
                listaUtilizador.add(Utilizador(username,password))
                adapter.notifyDataSetChanged()

                // limpa os campos depois de inseridos

                binding.editUsername.setText("")
                binding.editPassword.setText("")
            }

        }

          // Edita os elementos da lista

        binding.buttonEditar.setOnClickListener {

            if (pos >= 0) {
                val username = binding.editUsername.text.toString().trim()
                val password = binding.editPassword.text.toString().trim()
                if (!username.isEmpty() && !password.isEmpty()){
                    listaUtilizador.get(pos).username = username
                    listaUtilizador.get(pos).password = username
                    adapter.notifyDataSetChanged()
                    binding.editUsername.setText("")
                    binding.editPassword.setText("")
                    pos = -1
                }
            }
        }

           // Elimina o elemento na posição indicada

        binding.buttonEliminar.setOnClickListener {

            // valida se a posição é maior ou igual a 0

            if (pos >= 0) {
                listaUtilizador.removeAt(pos)
                adapter.notifyDataSetChanged()
                binding.editUsername.setText("")
                binding.editPassword.setText("")
                pos = -1
            }
        }

        binding.buttonLimpar.setOnClickListener {
            listaUtilizador.clear()
            adapter.notifyDataSetChanged()
            binding.editUsername.setText("")
            binding.editPassword.setText("")
            pos = -1
        }

    }
}