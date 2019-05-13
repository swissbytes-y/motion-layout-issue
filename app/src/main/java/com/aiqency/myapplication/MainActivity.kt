package com.aiqency.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG, "R.id.start ${R.id.start}")
        Log.i(TAG, "R.id.middle ${R.id.middle}")
        Log.i(TAG, "R.id.end ${R.id.end}")
        val startId = R.id.start
        val middleId = R.id.middle
        val endId = R.id.end

        to_start.setOnClickListener {
            motionLayout.transitionToState(R.id.start)
        }

        to_middle.setOnClickListener {
            motionLayout.transitionToState(R.id.middle)
        }

        to_top.setOnClickListener {
            motionLayout.transitionToState(R.id.top)
        }

        redirect.setOnClickListener { startActivity(Intent(this, RvActivity::class.java)) }

        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionChange(layout: MotionLayout?, fromId: Int, toId: Int, progress: Float) {
                Log.i(TAG, "onTransitionChange fromId: $fromId")
                Log.i(TAG, "onTransitionChange toId: $toId")
            }

            override fun onTransitionCompleted(layout: MotionLayout?, position: Int) {
                Log.i(TAG, "onTransitionCompleted position: $position")
            }

            override fun onTransitionTrigger(p0: MotionLayout?, fromId: Int, toId: Boolean, p3: Float) {
                Log.i(TAG, "onTransitionTrigger fromId: $fromId")
                Log.i(TAG, "onTransitionTrigger toId: $toId")
            }

            override fun onTransitionStarted(layout: MotionLayout?, fromId: Int, toId: Int) {
                Log.i(TAG, "onTransitionStarted fromId: $fromId")
                Log.i(TAG, "onTransitionStarted toId: $toId")

                if (fromId == startId && toId == middleId){
                    Log.i(TAG, "from bottom to middle")
                } else if (fromId == middleId && toId == endId){
                    Log.i(TAG, "from middle to top")
                } else if (fromId == endId && toId == middleId){
                    Log.i(TAG, "from top to middle")
                } else if (fromId == middleId && toId == startId){
                    Log.i(TAG, "from middle to bottom")
                }

            }
        })
    }
}