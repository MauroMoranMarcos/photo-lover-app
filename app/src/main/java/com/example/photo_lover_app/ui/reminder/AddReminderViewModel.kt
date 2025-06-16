package com.example.photo_lover_app.ui.reminder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.photo_lover_app.data.db.entities.Reminder
import com.example.photo_lover_app.data.repository.RemindersRepository

class AddReminderViewModel(private val remindersRepository: RemindersRepository) : ViewModel() {

    var reminderUiState by mutableStateOf(ReminderUiState())
        private set

    fun updateUiState(reminderDetails: ReminderDetails) {
        reminderUiState =
            ReminderUiState(reminderDetails = reminderDetails, isEntryValid = validateInput(reminderDetails))
    }

    suspend fun saveReminder() {
        if (validateInput()) {
            remindersRepository.insertReminder(reminderUiState.reminderDetails.toReminder())
        }
    }

    private fun validateInput(uiState: ReminderDetails = reminderUiState.reminderDetails): Boolean {
        return with(uiState) {
            date.isNotBlank() && description.isNotBlank() && imageUri.isNotBlank()
        }
    }
}

data class ReminderUiState(
    val reminderDetails: ReminderDetails = ReminderDetails(),
    val isEntryValid: Boolean = false
)

data class ReminderDetails(
    val id: Int = 0,
    val date: String = "",
    val description: String = "",
    val imageUri: String = "",
    val userId: Int = 0,
)

fun ReminderDetails.toReminder(): Reminder = Reminder(
    id = id,
    date = date,
    description = description,
    imageUri = imageUri,
    userId = userId
)

fun ReminderDetails.toReminderUiState(isEntryValid: Boolean = false): ReminderUiState = ReminderUiState(
    reminderDetails = this.toReminderDetails(),
    isEntryValid = isEntryValid
)

fun ReminderDetails.toReminderDetails(): ReminderDetails = ReminderDetails(
    id = id,
    date = date,
    description = description,
    imageUri = imageUri,
    userId = userId
)