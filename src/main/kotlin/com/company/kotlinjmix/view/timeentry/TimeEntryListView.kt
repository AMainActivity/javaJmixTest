package com.company.kotlinjmix.view.timeentry

import com.company.kotlinjmix.entity.TimeEntry
import com.company.kotlinjmix.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.flowui.view.*

@Route(value = "timeEntries", layout = MainView::class)
@ViewController("TimeEntry.list")
@ViewDescriptor("time-entry-list-view.xml")
@LookupComponent("timeEntriesDataGrid")
@DialogMode(width = "64em")
class TimeEntryListView : StandardListView<TimeEntry>() {
}