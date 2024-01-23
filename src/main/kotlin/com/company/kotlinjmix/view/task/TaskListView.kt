package com.company.kotlinjmix.view.task

import com.vaadin.flow.component.button.Button;
import com.company.kotlinjmix.entity.Task
import com.company.kotlinjmix.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.flowui.UiComponents
import io.jmix.flowui.component.grid.DataGrid
import io.jmix.flowui.download.Downloader
import io.jmix.flowui.view.*
import org.springframework.beans.factory.annotation.Autowired

@Route(value = "tasks", layout = MainView::class)
@ViewController("Task_.list")
@ViewDescriptor("task-list-view.xml")
@LookupComponent("tasksDataGrid")
@DialogMode(width = "64em")
class TaskListView : StandardListView<Task>() {
    @ViewComponent
    private lateinit var tasksDataGrid: DataGrid<Task>

    @Autowired
    private lateinit var uiComponents: UiComponents

    @Autowired
    private lateinit var downloader: Downloader

    @Subscribe
    private fun onInit(event: InitEvent) {
        tasksDataGrid.addComponentColumn { attachment ->
            val but: Button = uiComponents.create(Button::class.java)
            but.text = "Attachment"
            but.themeName = "tertiary-inline"
            if (attachment.attachment == null) {
                but.isEnabled = false
            }
            but.addClickListener {
                downloader.download(attachment.attachment)
            }
            but
        }
    }
}