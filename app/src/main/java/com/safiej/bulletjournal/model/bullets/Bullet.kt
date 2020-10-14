package com.safiej.bulletjournal.model.bullets

import java.util.*
import kotlin.collections.ArrayList

open class Bullet(
    var title: String,
    var active: Boolean,
    var significant: Boolean,
    var priority: Boolean,
    var dateAdded: Date
) {
    val subBulletList = ArrayList<Bullet>()
}