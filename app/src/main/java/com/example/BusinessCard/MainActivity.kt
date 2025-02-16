package com.example.BusinessCard

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.BusinessCard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   BusinessCardBackground(
                        stringResource(R.string.full_name),
                        stringResource(R.string.title),
                        stringResource(R.string.email),
                        stringResource(R.string.phone_number),
                        Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }


    @Composable
    fun BusinessCard(name: String, title: String, modifier: Modifier = Modifier) {

        //  Child component of BusinessCardBackground

        // Load the logo image resource
        val logo = painterResource(R.drawable.ic_launcher_foreground)

        // Arrange elements vertically
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 280.dp),
            verticalArrangement = Arrangement.Top
        ) {

            // A box container with a logo and a background
            Box (
                // Load the background color for the box container from the color resource
               modifier = Modifier.padding(start = 125.dp, end = 30.dp).width(200.dp).height(100.dp).background(color = colorResource(R.color.purple_700))
            ) {

                // Logo

                Image(
                    painter = logo,
                    contentDescription = null,
                    // Fill max width modifier to arrange the image vertically
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Name

            Text(
                text = name,
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                // Fill max width modifier to arrange the name vertically
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
            )

            // Title

            Text(
                text = title,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = colorResource(R.color.purple_700),
                fontWeight = FontWeight.Bold,
                // Fill max width modifier to arrange the title vertically
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
            )

        }
    }

    @Composable
    fun ContactInformation(
        email: String,
        sharedEmail: String,
        phoneNumber: String,
        modifier: Modifier
    ){
        // Arrange elements vertically
        Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement =  Arrangement.Center
        ) {

        // Child component of BusinessCardBackground

            // Phone number

            Row (
                modifier = Modifier.fillMaxWidth().padding(top = 500.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                // Use tint for loading a color for the logos from the color resource

                Icon(
                    // Use Icons.Filled to add the phone icon from the material design
                    imageVector = Icons.Filled.Phone,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 130.dp),
                    tint = colorResource(R.color.purple_700)
                )

                Text(
                    text = phoneNumber,
                    // Fill max width modifier to arrange the phone number vertically
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp)
                )

            }

            // Shared email
            Row (
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center
            ) {

            Icon(
                // Use Icons.Filled to add the share icon from the material design
                imageVector = Icons.Filled.Share,
                contentDescription = null,
                modifier = Modifier.padding(start = 130.dp),
                tint = colorResource(R.color.purple_700)
            )

            Text(
            text = sharedEmail,
            // Fill max width modifier to arrange the shared email vertically
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
              )
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    // Use Icons.Filled to add the email icon from the material design
                    imageVector = Icons.Filled.Email,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 130.dp),
                    tint = colorResource(R.color.purple_700)
                )

                Text(
                    text = email,
                    // Fill max width to arrange the email vertically
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp)
                )
            }
        }
    }

    @Composable
    fun BusinessCardBackground(name: String, title: String, email: String, phoneNumber : String, modifier: Modifier = Modifier){

        val sharedEmail = "@juniorAndroidDev"

        // Background container for Business card
        Box(
            // Import a background color for the background container from the color resource
            modifier = Modifier.fillMaxSize().background(color = colorResource(R.color.background))
        ){

        BusinessCard(
            name  = name,
            title = title,
            modifier = modifier
        )

         ContactInformation(
            phoneNumber = phoneNumber,
            sharedEmail = sharedEmail,
            email = email,
            modifier = modifier
          )
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        BusinessCardTheme {
            BusinessCard("", "");
        }
    }
}