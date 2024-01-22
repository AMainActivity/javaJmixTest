package com.company.kotlinjmix.view.task

import com.company.kotlinjmix.entity.Task
import com.company.kotlinjmix.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.flowui.view.*

@Route(value = "tasks", layout = MainView::class)
@ViewController("Task_.list")
@ViewDescriptor("task-list-view.xml")
@LookupComponent("tasksDataGrid")
@DialogMode(width = "64em")
class TaskListView : StandardListView<Task>() {
}