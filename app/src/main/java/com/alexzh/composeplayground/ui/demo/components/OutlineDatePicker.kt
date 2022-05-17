package com.alexzh.composeplayground.ui.demo.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun OutlineDatePicker(
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    value: LocalDate,
    formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"),
    icon: ImageVector = Icons.Filled.DateRange,
    iconContentDescription: String = "Select a date",
    onValueChange: (LocalDate) -> Unit
) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val isDatePickerDisplayed = remember { mutableStateOf(false) }

    val datePickerDialog = DatePickerDialog(
        context, { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            onValueChange(LocalDate.of(year, month, dayOfMonth))
            isDatePickerDisplayed.value = false
            focusManager.clearFocus()
        }, value.year, value.monthValue, value.dayOfMonth
    )
    datePickerDialog.setOnDismissListener {
        isDatePickerDisplayed.value = false
        focusManager.clearFocus()
    }
    if (isDatePickerDisplayed.value) {
        datePickerDialog.show()
    }

    OutlinedTextField(
        modifier = modifier.onFocusChanged { isDatePickerDisplayed.value = it.isFocused },
        label = label,
        value = value.format(formatter),
        onValueChange = { onValueChange( LocalDate.parse(it, formatter)) },
        readOnly = true,
        trailingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = iconContentDescription,
                modifier = Modifier.clickable { isDatePickerDisplayed.value = true }
            )
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun Preview_OutlineDatePicker() {
    val date1 = remember { mutableStateOf(LocalDate.now()) }
    val date2 = remember { mutableStateOf(LocalDate.now()) }
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            OutlineDatePicker(
                label = { Text("Date") },
                value = date1.value,
                onValueChange = { date1.value = it }
            )

            Spacer(modifier = Modifier.height(32.dp))

            OutlineDatePicker(
                label = { Text("Date") },
                value = date2.value,
                formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG),
                onValueChange = { date2.value = it }
            )
        }
    }
}