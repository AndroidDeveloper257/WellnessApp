package uz.alimov.wellnessapp

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.alimov.wellnessapp.model.WellnessTask

@Composable
fun WellnessTaskItem(
    modifier: Modifier = Modifier,
    task: WellnessTask,
    onClose: (WellnessTask) -> Unit
) {
    var checkedState by rememberSaveable { mutableStateOf(false) }
    WellnessTaskItemStateless(
        modifier = modifier,
        task = task,
        checked = checkedState,
        onCheckedChange = { checkedState = it },
        onClose = { onClose(it) }
    )
}

@Composable
fun WellnessTaskItemStateless(
    modifier: Modifier = Modifier,
    task: WellnessTask,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: (WellnessTask) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            text = task.label
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(
            onClick = { onClose(task) }
        ) {
            Icon(Icons.Filled.Close, contentDescription = null)
        }
    }
}