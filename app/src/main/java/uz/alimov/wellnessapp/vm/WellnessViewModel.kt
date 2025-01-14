package uz.alimov.wellnessapp.vm

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import uz.alimov.wellnessapp.model.WellnessTask

class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask> get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked.value = checked
        }
    }

}

fun getWellnessTasks() = List(30) { i ->
    WellnessTask(i, "Task # $i")
}