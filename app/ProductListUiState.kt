import ca.khanhadi.midtermApp

class ProductListUiState {
}

sealed interface PetListUiState {
    data class Loaded(val pets: List<Pet>):PetListUiState
}