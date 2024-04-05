package com.example.a40karmybuilder.ui.factionoverviewlist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a40karmybuilder.data.ArmiesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel to retrieve, update and delete an item from the [ItemsRepository]'s data source.
 */
class FactionOverviewListViewModel(
    savedStateHandle: SavedStateHandle,
    private val armiesRepository: ArmiesRepository,
) : ViewModel() {

//    private val itemId: Int = checkNotNull(savedStateHandle[FactionOverviewListDestination.itemIdArg])

    /**
     * Holds the item details ui state. The data is retrieved from [ItemsRepository] and mapped to
     * the UI state.
     */
//    val uiState: StateFlow<ItemDetailsUiState> =
//        armiesRepository.getArmyStream(itemId)
//            .filterNotNull()
//            .map {
//                ItemDetailsUiState(outOfStock = it.quantity <= 0, itemDetails = it.toItemDetails())
//            }.stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
//                initialValue = ItemDetailsUiState()
//            )
//
//    /**
//     * Reduces the item quantity by one and update the [ItemsRepository]'s data source.
//     */
//    fun reduceQuantityByOne() {
//        viewModelScope.launch {
//            val currentItem = uiState.value.itemDetails.toItem()
//            if (currentItem.quantity > 0) {
//                itemsRepository.updateItem(currentItem.copy(quantity = currentItem.quantity - 1))
//            }
//        }
//    }
//
//    /**
//     * Deletes the item from the [ItemsRepository]'s data source.
//     */
//    suspend fun deleteItem() {
//        itemsRepository.deleteItem(uiState.value.itemDetails.toItem())
//    }
//
//    companion object {
//        private const val TIMEOUT_MILLIS = 5_000L
//    }
}

/**
 * UI state for ItemDetailsScreen
 */
data class FactionOverviewListUiState(
    val available: Boolean = true,
//    val itemDetails: ItemDetails = ItemDetails()
)