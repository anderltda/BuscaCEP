package com.example.anderson.buscacep.ui.pesquisar

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.anderson.buscacep.model.Endereco
import com.example.anderson.buscacep.repository.EnderecoRepository

class PesquisaViewModel: ViewModel() {

    val enderecoRepository = EnderecoRepository()

    val endereco = MutableLiveData<Endereco>()
    val mensagemErro = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun buscar(cep: String) {

        isLoading.value = true

        enderecoRepository.buscar(
                cep,
                onComplete = {
                    endereco.value = it
                    mensagemErro.value = ""
                    isLoading.value = false
                },
                onError = {
                    endereco.value = null
                    mensagemErro.value = it?.message
                    isLoading.value = false
                }

        )

    }

}