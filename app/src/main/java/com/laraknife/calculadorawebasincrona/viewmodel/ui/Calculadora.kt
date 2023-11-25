package com.laraknife.calculadorawebasincrona.viewmodel.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laraknife.calculadorawebasincrona.viewmodel.data.MyViewModel

@Composable
fun Calculadora(myViewModel: MyViewModel) {
    MensajeError(myViewModel)
    myViewModel.reiniciarDatos()

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Toolbar()
            Datos(myViewModel)
            Botonera(myViewModel)
        }
    }
}

@Composable
fun Toolbar() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color(0xFFD6492B))) {
        Text(
            text = "Calculadora asíncrona by LaraKnife",
            Modifier.padding(16.dp),
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Datos(myViewModel: MyViewModel) {
    val operador1: String by myViewModel.operador1.observeAsState(initial = "0")
    val operador2: String by myViewModel.operador2.observeAsState(initial = "0")
    val servicio: String by myViewModel.servicio.observeAsState(initial = "Operación")
    val resultado: String by myViewModel.resultado.observeAsState(initial = "Resultado")

    Column(
        Modifier
            .fillMaxHeight(0.25f),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = operador1,
            fontSize = 22.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, top = 16.dp)
        )
        Text(
            text = servicio,
            fontSize = 22.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp)
        )
        Text(
            text = operador2,
            fontSize = 22.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp)
        )
        Text(
            text = resultado,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 32.dp)
        )
    }
}

@Composable
fun Botonera(myViewModel: MyViewModel) {
    Column(
        Modifier
            .fillMaxHeight()
            .padding(bottom = 36.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = { myViewModel.solicitarResultado() },
            Modifier
                .align(alignment = Alignment.End)
                .padding(end = 32.dp, bottom = 16.dp)
        ) {
            Text(
                text = "=",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                myViewModel.cambiarOperador("7")
            }) {
                Text(
                    text = "7",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(onClick = {
                myViewModel.cambiarOperador("8")
            }) {
                Text(
                    text = "8",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(onClick = {
                myViewModel.cambiarOperador("9")
            }) {
                Text(
                    text = "9",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(onClick = {
                myViewModel.cambiarServicio("MULTIPLICACION")
            }) {
                Text(
                    text = "*",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                myViewModel.cambiarOperador("4")
            }) {
                Text(
                    text = "4",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(onClick = {
                myViewModel.cambiarOperador("5")
            }) {
                Text(
                    text = "5",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(onClick = {
                myViewModel.cambiarOperador("6")
            }) {
                Text(
                    text = "6",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(onClick = {
                myViewModel.cambiarServicio("RESTA")
            }) {
                Text(
                    text = "-",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                myViewModel.cambiarOperador("1")
            }) {
                Text(
                    text = "1",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(onClick = {
                myViewModel.cambiarOperador("2")
            }) {
                Text(
                    text = "2",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(onClick = {
                myViewModel.cambiarOperador("3")
            }) {
                Text(
                    text = "3",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(onClick = {
                myViewModel.cambiarServicio("SUMA")
            }) {
                Text(
                    text = "+",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                myViewModel.reiniciarDatos()
            }) {
                Text(
                    text = "C",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(onClick = {
                myViewModel.cambiarOperador("0")
            }) {
                Text(
                    text = "0",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Button(onClick = {
                myViewModel.cambiarServicio("DIVISION")
            }) {
                Text(
                    text = "/",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun MensajeError(myViewModel: MyViewModel) {
    val error: Boolean by myViewModel.error.observeAsState(initial = false)
    if (error) {
        Toast.makeText(LocalContext.current, "Ocurrió un error", Toast.LENGTH_LONG).show()
        myViewModel.actualizarError()
    }
}