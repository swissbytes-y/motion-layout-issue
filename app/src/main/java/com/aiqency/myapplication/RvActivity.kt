package com.aiqency.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_rv.*
import java.util.*

class RvActivity : AppCompatActivity() {

    private val TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)

        rv?.apply {
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            adapter = Adapter((0..20).map { UUID.randomUUID().toString()})
            addItemDecoration(
                androidx.recyclerview.widget.DividerItemDecoration(
                    context,
                    androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
                )
            )
        }
        rv.setOnTouchListener { v, event ->
            motionLayout.onTouchEvent(event)
            true
        }
    }
}

class Adapter(val items: List<String>): androidx.recyclerview.widget.RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
          ViewHolder(LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tv.text = item
    }

    class ViewHolder(view: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        val tv = view.findViewById<TextView>(android.R.id.text1)
    }

}
