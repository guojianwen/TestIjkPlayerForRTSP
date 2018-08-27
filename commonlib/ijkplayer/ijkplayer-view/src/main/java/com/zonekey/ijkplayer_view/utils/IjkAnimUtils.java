package com.zonekey.ijkplayer_view.utils;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

/**
 * Created by xu.wang
 * Date on 2016/7/13 17:01
 * 为操作动画,提取的简单的类
 */
public class IjkAnimUtils {
    //动画的执行时间
    private static final int animDuration = 500;

    /**
     * 左右进出菜单动画
     * @param menu_left  开始位置
     * @param menu_right    结束位置
     * @param alpha_start 开始透明度
     * @param alpha_end   结束透明度
     */
    public static void menuAnimLeftOrRight(float menu_left, float menu_right, float alpha_start, float alpha_end, View view, Context context) {
        AnimationSet set = new AnimationSet(context, null);
        TranslateAnimation translateAnimation = new TranslateAnimation(menu_left, menu_right, 0, 0);
        translateAnimation.setDuration(animDuration);
        translateAnimation.setFillAfter(true);
        set.addAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(alpha_start, alpha_end);
        alphaAnimation.setDuration(animDuration);
        alphaAnimation.setFillAfter(true);
        set.addAnimation(alphaAnimation);
        // set.setInterpolator(new DecelerateInterpolator(1.0f));
        view.startAnimation(set);
    }

    /**
     * 上部进出菜单动画
     * @param menu_top  开始位置
     * @param menu_bottm    结束位置
     * @param alpha_start 开始透明度
     * @param alpha_end   结束透明度
     */
    public static void menuAnim(float menu_top, float menu_bottm, float alpha_start, float alpha_end, View view,Context context) {
        AnimationSet set = new AnimationSet(context, null);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, menu_top, menu_bottm);
        translateAnimation.setDuration(animDuration);
        translateAnimation.setFillAfter(true);
        set.addAnimation(translateAnimation);

        AlphaAnimation alphaAnimation = new AlphaAnimation(alpha_start, alpha_end);
        alphaAnimation.setDuration(animDuration);
        alphaAnimation.setFillAfter(true);
        set.addAnimation(alphaAnimation);

        set.setInterpolator(new DecelerateInterpolator(1.0f));

        view.startAnimation(set);
    }

    /**
     * 左右进出菜单动画,可以设置动画时间
     * @param menu_left  开始位置
     * @param menu_right    结束位置
     * @param alpha_start 开始透明度
     * @param alpha_end   结束透明度
     */
    public static void menuAnimLeftOrRight(float menu_left, float menu_right, float alpha_start, float alpha_end, View view, Context context,long times) {
        AnimationSet set = new AnimationSet(context, null);
        TranslateAnimation translateAnimation = new TranslateAnimation(menu_left, menu_right, 0, 0);
        translateAnimation.setDuration(1000);
        translateAnimation.setFillAfter(true);
        set.addAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(alpha_start, alpha_end);
        alphaAnimation.setDuration(times);
        alphaAnimation.setFillAfter(true);
        set.addAnimation(alphaAnimation);
        // set.setInterpolator(new DecelerateInterpolator(1.0f));
        view.startAnimation(set);
    }

    /**
     * 上部进出菜单动画
     * @param menu_top  开始位置
     * @param menu_bottom    结束位置
     * @param alpha_start 开始透明度
     * @param alpha_end   结束透明度
     */
    public static void menuAnim(float menu_top, float menu_bottom, float alpha_start, float alpha_end, View view,Context context, long times) {
        AnimationSet set = new AnimationSet(context, null);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, menu_top, menu_bottom);
        translateAnimation.setDuration(times);
        translateAnimation.setFillAfter(true);
        set.addAnimation(translateAnimation);

        AlphaAnimation alphaAnimation = new AlphaAnimation(alpha_start, alpha_end);
        alphaAnimation.setDuration(times);
        alphaAnimation.setFillAfter(true);
        set.addAnimation(alphaAnimation);

        set.setInterpolator(new DecelerateInterpolator(1.0f));

        view.startAnimation(set);
    }

}
