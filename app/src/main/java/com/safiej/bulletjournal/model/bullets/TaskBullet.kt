package com.safiej.bulletjournal.model.bullets

import java.util.*

class TaskBullet(
    title: String,
    active: Boolean,
    significant: Boolean,
    priority: Boolean,
    dateAdded: Date,
    var state: TaskState
) : Bullet(title, active, significant, priority, dateAdded)