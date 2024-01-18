package com.company.kotlinjmix.view.project

import com.company.kotlinjmix.entity.Project
import com.company.kotlinjmix.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.flowui.view.*

@Route(value = "projects/:id", layout = MainView::class)
@ViewController("Project.detail")
@ViewDescriptor("project-detail-view.xml")
@EditedEntityContainer("projectDc")
class ProjectDetailView : StandardDetailView<Project>() {
}