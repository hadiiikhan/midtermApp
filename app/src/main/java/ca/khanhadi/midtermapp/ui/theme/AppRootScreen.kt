package ca.khanhadi.midtermapp.ui.theme

import androidx.compose.runtime.Composable
import ca.khanhadi.midtermapp.ui.theme.ProductListScreen

@Composable
fun AppRootScreen(
    productListViewModel: ProductListViewModel
){
    ProductListScreen(viewModel = productListViewModel)

}