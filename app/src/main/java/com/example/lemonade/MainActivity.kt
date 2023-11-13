package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                 AppLemonade()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppLemonade(modifier: Modifier = Modifier){
    Column {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Lemonade",
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
        Surface (modifier = Modifier
            .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background){
            PageStructure({})
        }

    }

}

@Composable
fun PageStructure(    onImageClick: () -> Unit,modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    when (result){
        1-> {
            TextandImageStructure(
                imageResource = R.drawable.lemon_tree,
                descriptionResource = R.string.lemon_tree_text,
                onImageClick = {  result = 2
                    squeezeCount = (2..4).random() })
        }
        2 -> {
            TextandImageStructure(
                imageResource = R.drawable.lemon_squeeze,
                descriptionResource = R.string.lemon_text,
                onImageClick = {
                    squeezeCount--
                    if (squeezeCount == 0) {
                        result = 3
                    }
                })
        }
        3 ->
        { TextandImageStructure(
                imageResource = R.drawable.lemon_drink,
                descriptionResource = R.string.lemon_juice_text,
                onImageClick = { result = 4})
        }
        4 -> {
        TextandImageStructure(
            imageResource = R.drawable.lemon_restart,
            descriptionResource = R.string.lemon_glass_text,
            onImageClick = {  result = 1 })
        }
    }

}

@Composable
fun TextandImageStructure(
    imageResource : Int,
    descriptionResource:Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier

){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize() //Isso garante que os filhos dentro da coluna fiquem centralizados na tela do dispositivo em relação à largura.

    ){
        Button(
            onClick = onImageClick,
            shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
        ){
            Image(
                painter = painterResource(imageResource),
                contentDescription = imageResource.toString(),
                modifier = Modifier
                    .wrapContentSize()
                 )}
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = stringResource(descriptionResource),style = MaterialTheme.typography.bodyLarge)

    }
}

@Preview
@Composable
fun DiceRollerApp() {
    PageStructure({})
}

/*

O código a baixo não está 100% certo pois não permite que se consiga programar quantas vezes seja necessário tocar numa imagem
* package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                 AppLemonade()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppLemonade(modifier: Modifier = Modifier){
    Column {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Lemonade",
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
        DiceWithButtonAndImage()
    }

}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when(result) {
        1 -> R.drawable.lemon_tree
        2 ->  R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textResource = when (result){
        1 -> R.string.lemon_tree_text
        2 -> R.string.lemon_text
        3 -> R.string.lemon_glass_text
        else -> R.string.Empty_glass
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize() //Isso garante que os filhos dentro da coluna fiquem centralizados na tela do dispositivo em relação à largura.
    ) {
        Button(onClick = {
            if (result != 4 ){
                result++
            } else result = 1
        }) {//No corpo da lambda onClick, defina a variável result como um intervalo entre 1 e 6 e, em seguida, chame o método random() nesse intervalo.
            Image(
                painter = painterResource(imageResource),
                contentDescription = result.toString()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))//espaço vertical entre eles
        Text(stringResource(textResource))

    }
}
@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}

* */