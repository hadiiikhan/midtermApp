package ca.khanhadi.midtermapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import ca.khanhadi.midtermapp.ui.theme.AppRootScreen
import ca.khanhadi.midtermapp.ui.theme.ListBody
import ca.khanhadi.midtermapp.ui.theme.MidtermAppTheme
import ca.khanhadi.midtermapp.ui.theme.Product
import ca.khanhadi.midtermapp.ui.theme.ProductListViewModel
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MidtermAppTheme {
                Scaffold(
                    topBar = {
                        ProductTopAppBar(title = "Products")
                    }
                ) {
                    innerPadding ->
                    ProductListScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier,
) {
    // Sample data and state management
    val products = remember { mutableStateListOf<Product>() } // List of products
    var isLoading by remember { mutableStateOf(true) } // Loading state
    var errorMessage by remember { mutableStateOf<String?>(null) } // Error message

    // Simulating data loading
    LaunchedEffect(Unit) {
        // Simulate a network call
        delay(2000) // Simulating loading time
        products.addAll(listOf(
            Product("Max","Hoodie", "Forest Green", "Unisex", 79.99),
            Product("Lewis","T-Shirt", "Jet Black", "Unisex", 29.99),
            Product("Oscar","Jeans", "Navy Blue", "Unisex", 59.99),
            Product("Emily","Hoodie", "Maroon", "Female", 39.99)
        ))
        isLoading = false // Set loading to false after data is loaded
    }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            ca.khanhadi.midtermapp.ui.theme.ProductTopAppBar(
                title = "Products",
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        if (isLoading) {
            // Show loading state UI
            CircularProgressIndicator(modifier = Modifier.padding(innerPadding))
        } else if (errorMessage != null) {
            // Show error state UI
            Text(text = errorMessage!!, modifier = Modifier.padding(innerPadding))
        } else {
            // Show product list
            ListBody(
                petList = products,
                modifier = modifier.padding(innerPadding)
            )
        }
    }
}


