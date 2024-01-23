package com.company.kotlinjmix.view.projectstats

import com.company.kotlinjmix.app.ProjectStatsService
import com.company.kotlinjmix.entity.ProjectStats
import com.company.kotlinjmix.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.core.LoadContext
import io.jmix.flowui.view.*
import io.jmix.flowui.view.Target
import org.springframework.beans.factory.annotation.Autowired

@Route(value = "projectStatses", layout = MainView::class)
@ViewController("ProjectStats.list")
@ViewDescriptor("project-stats-list-view.xml")
@LookupComponent("projectStatsesDataGrid")
@DialogMode(width = "50em")
class ProjectStatsListView : StandardListView<ProjectStats>() {
    @Autowired
    private lateinit var projectStatsService: ProjectStatsService

    @Install(to = "projectStatsesDl", target = Target.DATA_LOADER)
    fun projectStatsesDlLoadDelegate(loadContext: LoadContext<ProjectStats>): MutableList<ProjectStats> {
        // Here you can load entities from an external store
        return projectStatsService.fetchStatistics()
    }
}