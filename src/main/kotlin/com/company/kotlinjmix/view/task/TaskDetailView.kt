package com.company.kotlinjmix.view.task


import com.company.kotlinjmix.entity.Task
import com.company.kotlinjmix.entity.TaskPriority
import com.company.kotlinjmix.view.main.MainView
import com.vaadin.flow.component.AbstractField
import com.vaadin.flow.router.Route
import io.jmix.flowui.component.textarea.JmixTextArea
import io.jmix.flowui.view.*

@Route(value = "tasks/:id", layout = MainView::class)
@ViewController("Task_.detail")
@ViewDescriptor("task-detail-view.xml")
@EditedEntityContainer("taskDc")
@DialogMode(width = "AUTO", height = "AUTO")
class TaskDetailView : StandardDetailView<Task>() {
    @Subscribe
    private fun onInitEntity(event: InitEntityEvent<Task>) {
        event.entity.setPriority(TaskPriority.MEDIUM)
    }

    @Subscribe("descriptionField")
    private fun onDescriptionFieldComponentValueChange(event: AbstractField.ComponentValueChangeEvent<JmixTextArea, *>) {
        event.source.helperText="${event.value.toString().length}/500"
    }
}