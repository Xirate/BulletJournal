package com.safiej.bulletjournal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.safiej.bulletjournal.model.bullets.Bullet
import kotlinx.android.synthetic.main.fragment_daily_log.*
import java.util.*
import kotlin.collections.ArrayList

class DailyLogFragment : Fragment() {

    private lateinit var recyclerAdapter: DailyLogAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_daily_log, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerAdapter = DailyLogAdapter()
        fragment_daily_log_recycler.layoutManager = LinearLayoutManager(context)
        fragment_daily_log_recycler.adapter = recyclerAdapter

        val mockData = ArrayList<DailyLogItem>()

        mockData.add(DateDailyLogItem(Date(System.currentTimeMillis())))
        mockData.add(BulletDailyLogItem(Bullet("Test Bullet #1", true, false, false, Date(System.currentTimeMillis()))))
        mockData.add(DateDailyLogItem(Date(System.currentTimeMillis() + 86400000)))
        mockData.add(BulletDailyLogItem(Bullet("Test Bullet #2", true, false, false, Date(System.currentTimeMillis()))))
        mockData.add(BulletDailyLogItem(Bullet("Test Bullet #3", true, false, false, Date(System.currentTimeMillis()))))

        recyclerAdapter.setData(mockData)
    }

    companion object {
        fun newInstance() : DailyLogFragment {
            return DailyLogFragment().apply {
                arguments = Bundle().apply {

                }
            }
        }
    }
}
