package ca.khanhadi.midtermapp.ui.theme

import ca.khanhadi.midtermapp.ui.theme.Product

sealed interface ProductListUiState {
    data class Loaded(val products: List<Product>):ProductListUiState
}

