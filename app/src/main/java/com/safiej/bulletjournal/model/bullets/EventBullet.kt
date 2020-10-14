package com.safiej.bulletjournal.model.bullets

import com.safiej.bulletjournal.model.bullets.Bullet
import java.util.*

class EventBullet (
    title: String,
    active: Boolean,
    significant: Boolean,
    priority: Boolean,
    dateAdded: Date,
    var date: Date
) : Bullet(title, active, significant, priority, dateAdded)