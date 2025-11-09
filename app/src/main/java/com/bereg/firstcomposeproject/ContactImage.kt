package com.bereg.firstcomposeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest.Builder

@Composable
fun ContactImage(contact: Contact) {
    val initials = remember(contact) {
        getInitials(contact)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(60.dp)
    ) {
        if (contact.imageRes == null) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(60.dp)
                    .background(Color.LightGray, CircleShape)
            ) {
                Text(
                    text = initials,
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        } else {
            Image(
                painter = rememberAsyncImagePainter(
                    Builder(LocalContext.current).data(
                    data = Constants.Contact.DEFAULT_AVATAR_URL
                ).apply(block = { -> crossfade(true) }).build()),
                contentDescription = Constants.Contact.CONTACT_IMAGE_DESCRIPTION,
                modifier = Modifier
                    .size(120.dp)
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )
        }
    }
}

private fun getInitials(contact: Contact): String {
    val firstInitial = contact.name.take(1)
    val lastInitial = contact.familyName.take(1)
    return "$firstInitial$lastInitial"
}
