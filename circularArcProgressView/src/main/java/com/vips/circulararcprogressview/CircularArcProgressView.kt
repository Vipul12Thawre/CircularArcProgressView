package com.vips.circulararcprogressview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CircularArcProgressView(context: Context?, attrs: AttributeSet) : View(context, attrs) {

    companion object {
        private const val DEFAULT_STROKE_COLOR = Color.BLUE
        private const val DEFAULT_PROGRESS_COLOR = Color.GREEN
        private const val DEFAULT_PROGRESS = 270
        private const val DEFAULT_STROKE_WIDTH = 10
        private const val DEFAULT_BG_COLOR = Color.WHITE
    }

    private var canvas: Canvas? = null

    private var strokeColor = DEFAULT_STROKE_COLOR
    private var progressColor = DEFAULT_PROGRESS_COLOR
    private var progress = DEFAULT_PROGRESS
    private var circleBgColor = DEFAULT_BG_COLOR
    private var strokeWidth = DEFAULT_STROKE_WIDTH

    private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.WHITE
    }
    private val strokePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }

    private val arcPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        this.canvas = canvas
        val mx = width.toFloat() / 2
        val my = height.toFloat() / 2
        val radius = (height.toFloat() / 2) - 10

        val oval = RectF(mx - radius, my - radius, mx + radius, my + radius)

        paint.color = circleBgColor
        canvas.drawCircle(width.toFloat() / 2, height.toFloat() / 2, radius, paint) // fill color

        arcPaint.color = progressColor
        arcPaint.alpha = 150
        val sweepAngle = (progress / 100f) * 360f // convert percentage into degrees(sweepAngle)
        canvas.drawArc(oval, 270f, sweepAngle, true, arcPaint) // progress color


        strokePaint.strokeWidth = strokeWidth.toFloat()
        drawStrokeCircle(strokeColor)
    }

    private fun drawStrokeCircle(strokeColor: Int) {
        val radius = (height.toFloat() / 2) - 10

        strokePaint.color = strokeColor
        this.canvas?.drawCircle(
            width.toFloat() / 2,
            height.toFloat() / 2,
            radius,
            strokePaint
        ) // stroke color
    }

    private fun setupAttributes(attrs: AttributeSet) {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs, R.styleable.CircularArcProgressView,
            0, 0
        )
        strokeColor = typedArray.getColor(
            R.styleable.CircularArcProgressView_strokeColor,
            DEFAULT_STROKE_COLOR
        )
        progressColor = typedArray.getColor(
            R.styleable.CircularArcProgressView_progressColor,
            DEFAULT_PROGRESS_COLOR
        )
        progress =
            typedArray.getColor(R.styleable.CircularArcProgressView_progress, DEFAULT_PROGRESS)

        circleBgColor = typedArray.getColor(
            R.styleable.CircularArcProgressView_circleBackgroundColor,
            DEFAULT_PROGRESS
        )
        strokeWidth = typedArray.getColor(
            R.styleable.CircularArcProgressView_circleStrokeWidth,
            DEFAULT_STROKE_WIDTH
        )

        typedArray.recycle()
    }

    init {

        setupAttributes(attrs)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width = when (widthMode) {
            MeasureSpec.EXACTLY -> widthSize
            MeasureSpec.AT_MOST -> 100
            MeasureSpec.UNSPECIFIED -> 100

            else -> 100
        }

        val height = when (heightMode) {
            MeasureSpec.EXACTLY -> heightSize
            MeasureSpec.AT_MOST -> 100
            MeasureSpec.UNSPECIFIED -> 100

            else -> 100
        }

        setMeasuredDimension(width, height)
    }

    fun setStrokeColor(color: Int) {
        strokeColor = color
        invalidate()
    }

    fun setProgressColor(color: Int) {
        progressColor = color
        invalidate()
    }

    fun setProgress(progress: Int) {
        this.progress = progress
        invalidate()
    }

    fun setCircleBackgroundColor(color: Int) {
        this.circleBgColor = color
        invalidate()
    }

    fun setCircleStrokeWidth(width: Int) {
        this.strokeWidth = width
        invalidate()
    }
}