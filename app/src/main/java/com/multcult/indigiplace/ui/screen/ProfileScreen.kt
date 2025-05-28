package com.multcult.indigiplace.ui.screen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.multcult.indigiplace.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
navController: NavHostController,
sellerName: String = "Pataxó Arte Viva",
sellerDescription: String = "No coração de Paraty, entre as montanhas e o mar, vive a linda Aldeia Pataxó, um lugar onde a terra fala, os ventos cantam e as tradições ancestrais seguem vivas, pulsando em cada gesto, em cada canto e em cada peça feita pelas mãos dos seus artesãos.\n" +
        "\n" +
        "Aqui, não se produz apenas artesanato; se produz memória, resistência e amor à natureza. A cada colar feito com sementes, a cada cesto tecido com fibras da mata, a história dos antepassados é contada, preservando os conhecimentos passados de geração em geração.\n" +
        "\n" +
        "A Aldeia Pataxó de Paraty é mais do que um lugar. É um símbolo da conexão profunda entre o povo e a floresta, entre o humano e o sagrado. É onde os ensinamentos dos mais velhos orientam as mãos dos mais jovens, onde cada traço, cada pintura corporal e cada objeto carrega os saberes milenares do povo Pataxó.\n" +
        "\n" +
        "Vivemos em harmonia com a natureza, cuidando da terra que nos sustenta e mantendo vivos os costumes, os cantos, a língua e a espiritualidade que nos fazem ser quem somos. Ao conhecer nosso trabalho, você não leva apenas uma peça artesanal, mas leva também um pedaço da nossa história, do nosso território e da nossa resistência enquanto povo originário.",
sellerLocation: String = "Aldeia Pataxó, Paraty",
sellerImageUrl: String = "https://example.com/profile.jpg"
) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Perfil do Vendedor",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF452A19)
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )


            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = sellerName,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = sellerLocation,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = sellerDescription,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0XFF452A19),
                    contentColor = Color.White
                )
            ) {
                Text("Voltar")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        navController = rememberNavController(),
        sellerName = "Pataxó Arte Viva",
        sellerDescription = "No coração de Paraty, entre as montanhas e o mar, vive a linda Aldeia Pataxó, um lugar onde a terra fala, os ventos cantam e as tradições ancestrais seguem vivas, pulsando em cada gesto, em cada canto e em cada peça feita pelas mãos dos seus artesãos.\n" +
                "\n" +
                "Aqui, não se produz apenas artesanato; se produz memória, resistência e amor à natureza. A cada colar feito com sementes, a cada cesto tecido com fibras da mata, a história dos antepassados é contada, preservando os conhecimentos passados de geração em geração.\n" +
                "\n" +
                "A Aldeia Pataxó de Paraty é mais do que um lugar. É um símbolo da conexão profunda entre o povo e a floresta, entre o humano e o sagrado. É onde os ensinamentos dos mais velhos orientam as mãos dos mais jovens, onde cada traço, cada pintura corporal e cada objeto carrega os saberes milenares do povo Pataxó.\n" +
                "\n" +
                "Vivemos em harmonia com a natureza, cuidando da terra que nos sustenta e mantendo vivos os costumes, os cantos, a língua e a espiritualidade que nos fazem ser quem somos. Ao conhecer nosso trabalho, você não leva apenas uma peça artesanal, mas leva também um pedaço da nossa história, do nosso território e da nossa resistência enquanto povo originário.",
        sellerLocation = "Aldeia Xingu, Mato Grosso",
        sellerImageUrl = "https://example.com/profile.jpg"
    )
}