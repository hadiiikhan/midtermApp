package ca.khanhadi.midtermapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.khanhadi.midtermapp.R
import ca.khanhadi.midtermapp.ui.theme.Product

@Composable
fun ListBody(
    petList: List<Product>,
    modifier: Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp, horizontal = 16.dp
        ), modifier = modifier
    ) {
        items(petList) { pet ->
            ProductListItem(pet)
        }
    }

}

@Composable
fun ProductListItem(product: Product) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            // Placeholder for the image; swap in AsyncImage or Image later
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.Gray), // Placeholder color
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Image",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = product.type.capitalize(Locale.current),
                        fontSize = 28.sp
                    )
                    Text(
                        text = product.name,
                        fontSize = 28.sp
                    )
                }
                Text(
                    text = "${product.name} - $${product.price}",
                    fontSize = 24.sp
                )
            }
        }
    }
}

