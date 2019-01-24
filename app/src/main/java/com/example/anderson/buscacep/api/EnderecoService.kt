package com.example.anderson.buscacep.api

import com.example.anderson.buscacep.model.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EnderecoService {

        @GET("/ws/{cep}/json/")
        fun buscar(@Path("cep") cep: String): Call<Endereco>
}



