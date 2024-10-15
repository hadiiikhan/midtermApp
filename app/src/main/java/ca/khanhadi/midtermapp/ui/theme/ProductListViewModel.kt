package ca.khanhadi.midtermapp.ui.theme

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ca.khanhadi.midtermapp.ui.theme.fakeProductList

class ProductListViewModel {
    private val _uiState: MutableState<ProductListUiState> =
        mutableStateOf(ProductListUiState.Loaded(fakeProductList))
    val uiState: State<ProductListUiState> = _uiState
}