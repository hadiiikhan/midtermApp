package ca.khanhadi.midtermapp.ui.theme


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import ca.khanhadi.midtermapp.R
import ca.khanhadi.midtermapp.ui.theme.ProductListUiState
import ca.khanhadi.midtermapp.ui.theme.ProductListViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import ca.khanhadi.midtermapp.ui.theme.MidtermAppTheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductListViewModel
) {
    val uiState: ProductListUiState = viewModel.uiState.value
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            ProductTopAppBar(
                title = "Products",
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        when (uiState) {
            is ProductListUiState.Loaded -> ListBody(
                petList = uiState.products,
                modifier = modifier.padding(innerPadding)
            )
        }
    }
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
            ProductTopAppBar(
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

