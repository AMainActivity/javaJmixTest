package com.company.kotlinjmix.view.timeentry

import com.company.kotlinjmix.entity.TimeEntry
import com.company.kotlinjmix.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.core.TimeSource
import io.jmix.core.security.CurrentAuthentication
import io.jmix.flowui.view.*
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate
import java.util.*
import com.company.kotlinjmix.entity.User
import io.jmix.flowui.Dialogs


@Route(value = "timeEntries/:id", layout = MainView::class)
@ViewController("TimeEntry.detail")
@ViewDescriptor("time-entry-detail-view.xml")
@EditedEntityContainer("timeEntryDc")
class TimeEntryDetailView : StandardDetailView<TimeEntry>() {
    @Autowired
    private lateinit var currentAuthentication: CurrentAuthentication

    @Autowired
    private val timeSource: TimeSource? = null

    @Autowired
    private lateinit var dialogs: Dialogs

    @Subscribe
    private fun onInitEntity(event: InitEntityEvent<TimeEntry>) {
        event.entity.entryDate = timeSource?.now()?.toLocalDateTime()
        val user = currentAuthentication.user as User
        event.entity.user = user
        dialogs.createMessageDialog()
            .withHeader("Success")
            .withText(user.username)
            .open()
    }
}