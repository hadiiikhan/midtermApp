package ca.khanhadi.midtermapp.ui.theme


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import ca.khanhadi.midtermapp.R
import ca.khanhadi.midtermapp.ui.theme.ProductListUiState
import ca.khanhadi.midtermapp.ui.theme.ProductListViewModel

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetListScreen(
    modifier: Modifier = Modifier,
    viewModel: PetListViewModel = viewModel()
){
    val state: State<PetListUiState> = viewModel.uiState
    val uiState: PetListUiState = state.value

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PetDataTopAppBar(
                title = stringResource(R.string.list_title),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        when (uiState) {
            is PetListUiState.Loaded -> ListBody(
                petList = uiState.pets,
                modifier = modifier.padding(innerPadding)
            )
        }
    }
}*/

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

