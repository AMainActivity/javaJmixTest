package com.company.kotlinjmix.view.projectstats

import com.company.kotlinjmix.entity.ProjectStats
import com.company.kotlinjmix.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.core.LoadContext
import io.jmix.flowui.view.*
import io.jmix.flowui.view.Target

@Route(value = "projectStatses", layout = MainView::class)
@ViewController("ProjectStats.list")
@ViewDescriptor("project-stats-list-view.xml")
@LookupComponent("projectStatsesDataGrid")
@DialogMode(width = "50em")
class ProjectStatsListView : StandardListView<ProjectStats>() {

    @Install(to = "projectStatsesDl", target = Target.DATA_LOADER)
    fun projectStatsesDlLoadDelegate(loadContext: LoadContext<ProjectStats>): MutableList<ProjectStats> {
        // Here you can load entities from an external store
        return mutableListOf()
    }
}