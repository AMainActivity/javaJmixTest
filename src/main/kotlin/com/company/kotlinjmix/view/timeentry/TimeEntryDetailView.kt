package com.company.kotlinjmix.view.timeentry

import com.company.kotlinjmix.entity.TimeEntry
import com.company.kotlinjmix.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.core.TimeSource
import io.jmix.flowui.view.*
import org.springframework.beans.factory.annotation.Autowired
import java.util.*


@Route(value = "timeEntries/:id", layout = MainView::class)
@ViewController("TimeEntry.detail")
@ViewDescriptor("time-entry-detail-view.xml")
@EditedEntityContainer("timeEntryDc")
class TimeEntryDetailView : StandardDetailView<TimeEntry>() {
    @Autowired
    private val timeSource: TimeSource? = null
    @Subscribe
    private fun onInitEntity(event: InitEntityEvent<TimeEntry>) {
        event.entity.entryDate= timeSource?.now()?.toLocalDateTime()
    }
}