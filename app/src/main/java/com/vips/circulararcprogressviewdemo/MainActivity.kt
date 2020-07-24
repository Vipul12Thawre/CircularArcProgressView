package com.vips.circulararcprogressviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.vips.circulararcprogressview.CircularArcProgressView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawViews()
    }

    private fun drawViews() {
        val circularArcProgressView1 =
                include.findViewById<CircularArcProgressView>(R.id.circularArcProgressView)
        val percentTv =
                include.findViewById<TextView>(R.id.percentTv)
        circularArcProgressView1.setStrokeColor(ContextCompat.getColor(this, R.color.colorBrown))
        circularArcProgressView1.setProgressColor(
                ContextCompat.getColor(
                        this,
                        R.color.colorBrownFade
                )
        )
        circularArcProgressView1.setProgress(40)
        percentTv.text="40%"

        val circularArcProgressView2 =
                include2.findViewById<CircularArcProgressView>(R.id.circularArcProgressView)
        val percentTv2 =
                include2.findViewById<TextView>(R.id.percentTv)
        circularArcProgressView2.setStrokeColor(ContextCompat.getColor(this, R.color.colorOrange))
        circularArcProgressView2.setProgressColor(
                ContextCompat.getColor(
                        this,
                        R.color.colorOrangeFade
                )
        )
        circularArcProgressView2.setProgress(60)
        percentTv2.text="60%"

        val circularArcProgressView3 =
                include3.findViewById<CircularArcProgressView>(R.id.circularArcProgressView)
        val percentTv3 =
                include3.findViewById<TextView>(R.id.percentTv)
        circularArcProgressView3.setStrokeColor(ContextCompat.getColor(this, R.color.colorPink))
        circularArcProgressView3.setProgressColor(
                ContextCompat.getColor(
                        this,
                        R.color.colorPinkFade
                )
        )
        circularArcProgressView3.setProgress(10)
        percentTv3.text="10%"

        val circularArcProgressView4 =
                include4.findViewById<CircularArcProgressView>(R.id.circularArcProgressView)
        val percentTv4 =
                include4.findViewById<TextView>(R.id.percentTv)
        circularArcProgressView4.setStrokeColor(ContextCompat.getColor(this, R.color.colorViolet))
        circularArcProgressView4.setProgressColor(
                ContextCompat.getColor(
                        this,
                        R.color.colorVioletFade
                )
        )
        percentTv4.text="50%"

        circularArcProgressView4.setProgress(50)
    }
}