package com.chris.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.chris.widget.R;

/**
 * create by Chris Chan
 * create on 2019/6/8 16:47
 * use for :
 */
public class ProgressBar extends View {
    public static final int DEFAULT_RULE_COLOR = 0xff444444;//默认标尺颜色
    public static final int DEFAULT_RULE_HEIGHT = 1;//默认标尺高度，即线条的粗细
    public static final int DEFAULT_PADDING = 10;//默认边距
    public static final int DEFAULT_CURSOR_COLOR = 0xffff4444;//默认游标颜色
    public static final int DEFAULT_CURSOR_RADIUS = 6;//默认游标半径

    private int mWidth;//控件宽
    private int mHeight;//控件高
    private int mMinWidth = 400;//最小宽度
    private int mMinHeight = 40;//最小高度

    private Paint mPaint;//画笔
    private int progress = 0;//进度值

    private int ruleColor = DEFAULT_RULE_COLOR;//标尺颜色
    private int ruleHeight = dp2px(DEFAULT_RULE_HEIGHT);//标尺高度，即线条的粗细
    private int mPadding = dp2px(DEFAULT_PADDING);//边距
    private int cursorColor = DEFAULT_CURSOR_COLOR;//游标颜色
    private int cursorRadius = dp2px(DEFAULT_CURSOR_RADIUS);//游标半径

    public ProgressBar(Context context) {
        this(context, null);
    }

    public ProgressBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        obtainStyledAttrs(attrs);
        initPaint();
    }

    /**
     * 获取布局的属性
     *
     * @param attrs
     */
    private void obtainStyledAttrs(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.ProgressBar);

        ruleColor = array.getColor(R.styleable.ProgressBar_rule_color, ruleColor);
        ruleHeight = (int) array.getDimension(R.styleable.ProgressBar_rule_height, ruleHeight);
        mPadding = (int) array.getDimension(R.styleable.ProgressBar_padding, mPadding);
        cursorColor = array.getColor(R.styleable.ProgressBar_cursor_color, cursorColor);
        cursorRadius = (int) array.getDimension(R.styleable.ProgressBar_cursor_radius, cursorRadius);

        array.recycle();
    }

    /**
     * 初始化
     */
    private void initialize() {
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(ruleHeight);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getDefaultWidth(widthMeasureSpec);
        mHeight = getDefaultHeight(heightMeasureSpec);
        setMeasuredDimension(mWidth, mHeight);
    }

    /**
     * 得到默认的控件宽度
     *
     * @param widthMeasureSpec
     * @return
     */
    private int getDefaultWidth(int widthMeasureSpec) {
        int hMode = MeasureSpec.getMode(widthMeasureSpec);
        int hSize = MeasureSpec.getSize(widthMeasureSpec);
        //如果用户设定了精确值。则按照精确值取值，否则返回最小宽度
        if (hMode == MeasureSpec.EXACTLY) {
            //宽度不能小于设定的最小值
            if (hSize < mMinWidth) {
                hSize = mMinWidth;
            }
            return hSize;
        } else {
            return mMinWidth;
        }
    }

    /**
     * 得到默认的控件高度
     *
     * @param heightMeasureSpec
     * @return
     */
    private int getDefaultHeight(int heightMeasureSpec) {
        int hMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSize = MeasureSpec.getSize(heightMeasureSpec);

        if (hMode == MeasureSpec.EXACTLY) {
            if (hSize < mMinHeight) {
                hSize = mMinHeight;
            }
            return hSize;
        } else {
            return mMinHeight;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        mPaint.setColor(ruleColor);
        mPaint.setStyle(Paint.Style.STROKE);
        //绘制标尺
        canvas.drawLine(mPadding, getHeight() / 2, mWidth - mPadding, mHeight / 2, mPaint);
        mPaint.setColor(cursorColor);
        mPaint.setStyle(Paint.Style.FILL);
        //绘制游标
        canvas.drawCircle(mPadding + (mWidth - mPadding * 2) * (progress / 100.0f), mHeight / 2, cursorRadius, mPaint);
        canvas.restore();
    }

    /**
     * 获取进度值
     *
     * @return
     */
    public int getProgress() {
        return progress;
    }

    /**
     * 设置进度值
     *
     * @param progress
     */
    public void setProgress(int progress) {
        if (progress <= 100) {
            this.progress = progress;
            invalidate();
        }
    }

    /**
     * sp转换成px
     *
     * @param dpValue
     * @return
     */
    private int dp2px(int dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, getResources().getDisplayMetrics());
    }

    /**
     * sp转换成px
     *
     * @param spValue
     * @return
     */
    private int sp2px(int spValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, getResources().getDisplayMetrics());
    }


}
