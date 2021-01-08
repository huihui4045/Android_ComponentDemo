package com.alizhezi.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



/**
 * Created by 邢燕 on 2020/9/9 09:47.
 * Email:lucky_xyic@sina.cn
 * 智能客服广告页，可动画折叠
 */
public class ActionBanner extends RelativeLayout implements View.OnClickListener {
    private final String TAG = "FloatActionButton";
    public TextView tvSee, tvContent;
    public ImageView ivService;
    private RelativeLayout rlRoot;
    public LinearLayout llBg;
    private Context mContext;
    public ValueAnimator valueAnimator;





    public ActionBanner(Context context) {
        this(context, null);
    }

    public ActionBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context ctx) {
        this.mContext = ctx;
        LayoutInflater.from(ctx).inflate(R.layout.action_banner_layout, this, true);
        tvSee = findViewById(R.id.tv_ai_see);
        ivService = findViewById(R.id.iv_drag);
        rlRoot = findViewById(R.id.rl_root);
        llBg = findViewById(R.id.ll_bg);
        tvContent = findViewById(R.id.tv_content);
        tvSee.setOnClickListener(this);
        ivService.setOnClickListener(this);
        tvContent.setOnClickListener(this);
       // tvContent.getLayoutParams().width = ScreenUtils.getScreenWidth(mContext) - DeviceUtil.dp2px(mContext, 190);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_ai_see://查看
            case R.id.iv_drag:
            case R.id.tv_content:

                break;
            default:
                break;
        }
    }

    /**
     * 开启属性动画
     */
    public void startAnimator() {

        valueAnimator = ValueAnimator.ofInt(0, rlRoot.getWidth()-DeviceUtil.dp2px(mContext, 90)).setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                int offX = (int) animation.getAnimatedValue();

                rlRoot.setTranslationX(offX);


                if ((int) animation.getAnimatedValue() == DeviceUtil.dp2px(mContext, 90)) {
                    rlRoot.setVisibility(GONE);

                }

            }
        });
        valueAnimator.start();
    }


    /**
     * 不在当前银行首页时，对动画销毁处理
     */
    public void releaseAnimator() {

        if (valueAnimator != null) {
            /* 离开银行首页时结束动画即手动设置animation.getAnimatedValue() = 240 相当于 ivServiceRight = visible，目的是为了处理再次回到银行首页initAiRobotAnimator动画方法直接进入resumeAnimator展开ui */
            valueAnimator.end();/* 停止到动画结束的位置，动画结束位置的时候相当于方法onAnimationUpdate中的animation.getAnimatedValue() = 240 相当于 ivServiceRight = visible */
            valueAnimator.cancel();
            valueAnimator.removeAllUpdateListeners();
        }
    }

    /**
     * 网络图片适配
     *
     * @param url
     */
    public void setIvBanner(String url) {
        if (!TextUtils.isEmpty(url)) {
           // ImageLoaderUtil.loadImage(url, ivService, ImageLoaderUtil.getOptions(R.drawable.ai_icon, R.drawable.ai_icon));
        } else {
            //ivService.setImageResource(R.drawable.ai_icon);
        }
    }

    /**
     * 推荐内容适配
     *
     * @param recommendDesc
     */
    public void setContent(String recommendDesc) {
        tvContent.setText(recommendDesc);
    }

}
