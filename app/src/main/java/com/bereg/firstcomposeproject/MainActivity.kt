package com.bereg.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                Surface(
                    color = colorResource(id = R.color.custom_blue_100),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                ) { }
                Surface(
                    color = colorResource(id = R.color.custom_blue_50),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(16.dp),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }

                val testContact = Contact(
                    name = "Алексей",
                    familyName = "Иванов",
                    phone = "+7 495 111 22 33",
                    address = "Москва, ул. Тестовая, д. 5",
                    email = "alex.ivanov@example.com",
                    imageRes = 1,
                    isFavorite = true
                )
                ContactDetails(contact = testContact)
            }
        }
    }
}

@Preview(showBackground = true, name = "Избранный контакт")
@Composable
fun ContactDetailsPreview1() {
    Column(modifier = Modifier.fillMaxSize()) {
        Surface(
            color = colorResource(id = R.color.custom_blue_100),
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
        ) { }
        Surface(
            color = colorResource(id = R.color.custom_blue_50),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(16.dp),
                color = Color.White,
                fontSize = 20.sp
            )
        }
        val contact = Contact(
            name = "Иван",
            surname = "Сергеевич",
            familyName = "Петров",
            phone = "+7 495 123 45 67",
            address = "Москва, ул. Примерная, д. 1",
            email = "ivan.petrov@example.com",
            imageRes = null,
            isFavorite = true
        )
        ContactDetails(contact = contact)
    }
}

@Preview(showBackground = true, name = "Обычный контакт")
@Composable
fun ContactDetailsPreview2() {
    Column(modifier = Modifier.fillMaxSize()) {
        Surface(
            color = colorResource(id = R.color.custom_blue_100),
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
        ) { }
        Surface(
            color = colorResource(id = R.color.custom_blue_50),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(16.dp),
                color = Color.White,
                fontSize = 20.sp
            )
        }
        val contact = Contact(
            name = "Мария",
            familyName = "Сидорова",
            phone = "+7 495 765 43 21",
            address = "Санкт-Петербург, Невский пр-т, д. 10",
            email = null,
            imageRes = 2,
            isFavorite = false
        )
        ContactDetails(contact = contact)
    }
}