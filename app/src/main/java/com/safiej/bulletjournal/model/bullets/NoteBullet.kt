package com.safiej.bulletjournal.model.bullets

import com.safiej.bulletjournal.model.bullets.Bullet
import java.util.*

class NoteBullet(
    title: String,
    active: Boolean,
    significant: Boolean,
    priority: Boolean,
    dateAdded: Date
) : Bullet(title, active, significant, priority, dateAdded)