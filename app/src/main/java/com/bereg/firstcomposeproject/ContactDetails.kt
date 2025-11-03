package com.bereg.firstcomposeproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContactDetails(contact: Contact) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        ContactImage(contact = contact)

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = getFullName(contact),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            if (contact.isFavorite) {
                Spacer(modifier = Modifier.size(8.dp))
                Icon(
                    painter = painterResource(id = android.R.drawable.star_big_on),
                    contentDescription = "Избранный",
                    tint = Color.Yellow,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            InfoRow(
                label = stringResource(id = R.string.phone),
                value = contact.phone
            )

            contact.address?.let { address ->
                InfoRow(
                    label = stringResource(id = R.string.address),
                    value = address
                )
            }

            contact.email?.let { email ->
                InfoRow(
                    label = stringResource(id = R.string.email),
                    value = email
                )
            }
        }
    }
}

private fun getFullName(contact: Contact): String {
    return if (contact.surname != null) {
        "${contact.familyName} ${contact.name} ${contact.surname}"
    } else {
        "${contact.familyName} ${contact.name}"
    }
}