package com.example.cadastro

class Formulario (
    val nome: String,
    val telefone: String,
    val email: String,
    val listaEmailCb: Boolean,
    val sexo: Int,
    val cidade: String,
    val uf: String
){
    override fun toString(): String {
        return "Nome: $nome\nTelefone: $telefone\nEmail: $email\nCidade: $cidade\nIngressar na lista: $listaEmailCb\nSexo: $sexo\nUF: $uf"
    }
}