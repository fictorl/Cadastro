package com.example.cadastro

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cadastro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        amb.ufSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selUf = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //NSA
            }
        }

        amb.salvaBt.setOnClickListener {
            val nome = amb.etNome.text.toString()
            val telefone = amb.etTelefone.text.toString()
            val email = amb.etEmail.text.toString()
            val listaEmailCb = amb.listaEmailCb.isChecked
            val sexo = if (amb.sexoRg.checkedRadioButtonId == R.id.masculinoRb) "Masculino" else "Feminino"
            val cidade = amb.etCidade.text.toString()
            val uf = amb.ufSp.selectedItem.toString()

            val formulario = Formulario(nome, telefone, email, listaEmailCb, sexo, cidade, uf)

            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }

        amb.limparBt.setOnClickListener {
            amb.etNome.text.clear()
            amb.etTelefone.text.clear()
            amb.etEmail.text.clear()
            amb.etCidade.text.clear()
            amb.listaEmailCb.isChecked = false
            amb.sexoRg.check(R.id.masculinoRb)
            amb.ufSp.setSelection(0)
        }
    }
}