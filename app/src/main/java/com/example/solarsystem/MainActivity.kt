package com.example.solarsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.solarsystem.ui.theme.SolarSystemTheme
import androidx.compose.ui.layout.AlignmentLine

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolarSystemTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DrawCircles()
                    DrawPlanets()
                }
            }
        }
    }
}

@Composable
fun DrawCircles() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val strokeWidth = 2.dp.toPx()
        val radius = size.minDimension / 2 - strokeWidth / 2
        val colors = listOf(
            Color.Black,
            Color.Black,
            Color.Black,
            Color.Black,
            Color.Black,
            Color.Black,
            Color.Black,
            Color.Black,
            Color.Black)
        for (i in 0..8) {
            drawCircle(
                color = colors[i],
                center = center,
                radius = radius - i * 20.dp.toPx(),
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                alpha = 1f
            )
        }
    }
    Text(
        text = "Солнечная система",
        style= TextStyle(fontWeight= FontWeight.Bold,
            fontSize = 24.sp),
        textAlign= TextAlign.Center,
        modifier= Modifier
            .fillMaxWidth()
            .offset(x = 0.dp, y = 120.dp)
    )
}

@Composable
fun PlanetDescription(selectedPlanet: MutableState<String>) {
    val description = remember {
        mutableStateOf("")
    }

    when (selectedPlanet.value) {
        "Sun" -> {
            description.value = "Центральная звезда солнечной системы."
        }

        "Mercury" -> {
            description.value =
                "Ближайшая планета к Солнцу"
        }

        "Venus" -> {
            description.value =
                "Самая горячая планета."
        }
    }

    Text(
        text = description.value,
        style = TextStyle(fontSize = 16.sp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun DrawPlanets(){
    Image(painter = painterResource(id = R.drawable.sun),
        contentDescription = "Sun",
        modifier = Modifier
            .fillMaxSize()
            .scale(0.13f))
    Image(painter = painterResource(id = R.drawable.mercury),
        contentDescription = "Mercury",
        modifier = Modifier
            .fillMaxSize()
            .scale(0.03f)
            .offset(x = 1060.dp, y = -420.dp))
    Image(painter = painterResource(id = R.drawable.venus),
        contentDescription = "Venus",
        modifier = Modifier
            .fillMaxSize()
            .scale(0.05f)
            .offset(x = 550.dp, y = -950.dp))
    Image(painter = painterResource(id = R.drawable.earth),
        contentDescription = "Earth",
        modifier = Modifier
            .fillMaxSize()
            .scale(0.05f)
            .offset(x = -1350.dp, y = -600.dp))
    Image(painter = painterResource(id = R.drawable.mars),
        contentDescription = "Mars",
        modifier = Modifier
            .fillMaxSize()
            .scale(0.04f)
            .offset(x = 2250.dp, y = -700.dp))
    Image(painter = painterResource(id = R.drawable.jupiter),
        contentDescription = "Jupiter",
        modifier = Modifier
            .fillMaxSize()
            .scale(0.095f)
            .offset(x = -700.dp, y = 975.dp))
    Image(painter = painterResource(id = R.drawable.saturn),
        contentDescription = "Saturn",
        modifier = Modifier
            .fillMaxSize()
            .scale(0.09f)
            .offset(x = 900.dp, y = 1175.dp))
    Image(painter = painterResource(id = R.drawable.uranus),
        contentDescription = "Uranus",
        modifier = Modifier
            .fillMaxSize()
            .scale(0.06f)
            .offset(x = -1000.dp, y = 2410.dp))
    Image(painter = painterResource(id = R.drawable.neptune),
        contentDescription = "Neptune",
        modifier = Modifier
            .fillMaxSize()
            .scale(0.06f)
            .offset(x = 1200.dp, y = 2650.dp))
    Image(painter = painterResource(id = R.drawable.pluto),
        contentDescription = "Pluto",
        modifier = Modifier
            .fillMaxSize()
            .scale(0.035f)
            .offset(x = 4000.dp, y = -3900.dp))
}

@Preview(showBackground = true)
@Composable
fun DrawCirclePreview() {
    val selectedPlanet = remember { mutableStateOf("Sun") }
    SolarSystemTheme {
        DrawCircles()
        DrawPlanets()
        PlanetDescription(selectedPlanet)
    }
}