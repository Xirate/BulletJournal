package com.safiej.bulletjournal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.safiej.bulletjournal.model.bullets.Bullet
import kotlinx.android.synthetic.main.item_daily_log_bullet.view.*
import kotlinx.android.synthetic.main.item_daily_log_date.view.*
import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class DailyLogAdapter() : RecyclerView.Adapter<DailyLogAdapter.DailyLogItemViewHolder>() {

    private val TYPE_DATE = 0
    private val TYPE_BULLET = 1

    private var data: ArrayList<DailyLogItem> = ArrayList()

    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int): Int {
        return when(data[position]) {
            is DateDailyLogItem -> TYPE_DATE
            is BulletDailyLogItem -> TYPE_BULLET
            else -> throw IllegalStateException("DailyLogAdapter items have to be one of classes extending DailyLogItem")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyLogItemViewHolder {

        val layoutId = when(viewType) {
            TYPE_DATE -> R.layout.item_daily_log_date
            TYPE_BULLET -> R.layout.item_daily_log_bullet
            else -> throw IllegalStateException("Illegal item view type in DailyLogAdapter")
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return when(viewType) {
            TYPE_DATE -> DateDailyLogItemViewHolder(view)
            TYPE_BULLET -> BulletDailyLogItemViewHolder(view)
            else -> throw IllegalStateException("Illegal item view type in DailyLogAdapter")
        }
    }

    override fun onBindViewHolder(holder: DailyLogItemViewHolder, position: Int) {
        when(holder) {
            is DateDailyLogItemViewHolder -> holder.bind((data[position] as DateDailyLogItem).date)
            is BulletDailyLogItemViewHolder -> holder.bind((data[position] as BulletDailyLogItem).bullet)
        }
    }

    fun setData(data: ArrayList<DailyLogItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    open class DailyLogItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class DateDailyLogItemViewHolder(itemView: View) : DailyLogItemViewHolder(itemView) {

        private var content: TextView = itemView.item_daily_log_date_content

        fun bind(date: Date) {
            val sdf = SimpleDateFormat("dd.MM EEEE", Locale.getDefault())
            content.text = sdf.format(date)
        }
    }

    class BulletDailyLogItemViewHolder(itemView: View) : DailyLogItemViewHolder(itemView) {

        private var content: TextView = itemView.item_daily_log_bullet_content

        fun bind(bullet: Bullet) {
            content.text = bullet.title
        }
    }

}

open class DailyLogItem

class DateDailyLogItem(val date: Date) : DailyLogItem()

class BulletDailyLogItem(val bullet: Bullet) : DailyLogItem()

