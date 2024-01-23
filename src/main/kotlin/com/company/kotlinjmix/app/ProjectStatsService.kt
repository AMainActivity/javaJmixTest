package com.company.kotlinjmix.app

import com.company.kotlinjmix.entity.Project
import com.company.kotlinjmix.entity.ProjectStats
import io.jmix.core.DataManager
import org.springframework.stereotype.Component
import java.util.*
import java.util.stream.Collectors

@Component
class ProjectStatsService(private val dataManager: DataManager) {
    fun fetchStatistics(): MutableList<ProjectStats> {
        val projects = dataManager.load(Project::class.java).all().list()
        val projectStats = projects
                .filterNotNull()
                .stream()
                .map {
                    val stat = dataManager.create(ProjectStats::class.java)
                    stat.id = it.id
                    stat.projectName = it.name
                    stat.tasksCount = it.tasks.size
                    val plannedEfforts = it.tasks.stream()
                            .map() { it.estimation ?: 0 }
                            .reduce(0) { sum, element ->
                                sum + element
                            }
                    stat.plannedEfforts = plannedEfforts
                    stat.actualEfforts = it.id?.let { it1 -> (getActualEfforts(it1) ?: 0).toInt() }
                    stat
                }
                .collect(Collectors.toList())
        return projectStats
    }

    private fun getActualEfforts(projectId: UUID) =
            dataManager.loadValue("select SUM(t.timeSpent) from TimeEntry t " +
                    "where t.task.project.id = :taskProjectId", Long::class.java)
                    .parameter("taskProjectId", projectId)
                    .one()

}