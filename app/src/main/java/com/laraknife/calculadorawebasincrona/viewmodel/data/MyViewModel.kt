package com.laraknife.calculadorawebasincrona.viewmodel.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.laraknife.calculadorawebasincrona.viewmodel.retrofit.CalculoResponse
import com.laraknife.calculadorawebasincrona.viewmodel.retrofit.RetrofitClient
import com.laraknife.calculadorawebasincrona.viewmodel.retrofit.datos
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MyViewModel : ViewModel() {

    private val retrofit = RetrofitClient.getInstance()

    private val _operador1 = MutableLiveData<String>()
    val operador1: LiveData<String> = _operador1

    private val _operador2 = MutableLiveData<String>()
    val operador2: LiveData<String> = _operador2

    private val _servicio = MutableLiveData<String>()
    val servicio: LiveData<String> = _servicio

    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String> = _resultado

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> = _error

    fun cambiarOperador(valor: String) {
        if (operador1.value == "0") {
            _operador1.value = valor
        } else if (operador1.value != "0" && servicio.value == "Operación") {
            _operador1.value += valor
        } else if (servicio.value != "Operación" && operador2.value == "0") {
            _operador2.value = valor
        } else {
            _operador2.value += valor
        }
    }

    fun cambiarServicio(operacion: String) {
        _servicio.value = operacion
    }

    fun reiniciarDatos() {
        _operador1.value = "0"
        _operador2.value = "0"
        _servicio.value = "Operación"
        _resultado.value = "Resultado"
    }

    fun solicitarResultado() {
        if (operador1.value != "0" || servicio.value != "Operación") {
            val aux1 = operador1.value!!.toInt()
            val aux2 = servicio.value.toString()
            val aux3 = operador2.value!!.toInt()
            val datos = datos(aux1, aux2, aux3)

            CoroutineScope(Dispatchers.IO).launch {
                val deferred = async { retrofit.getCalculo(post = datos) }
                val response: Response<CalculoResponse> = deferred.await()

                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        _resultado.value = response.body()?.valor.toString()
                    }else{
                        _error.value = true
                    }
                }
            }
        }
    }

    fun actualizarError() {
        _error.value = false
    }
}