package com.reactnativenavigation.utils;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ViewUtils {
    @Nullable
    public static <T> T findChildByClass(ViewGroup root, Class clazz) {
        for (int i = 0; i < root.getChildCount(); i++) {
            View view = root.getChildAt(i);
            if (clazz.isAssignableFrom(view.getClass())) {
                return (T) view;
            }

            if (view instanceof ViewGroup) {
                view = findChildByClass((ViewGroup) view, clazz);
                if (view != null && clazz.isAssignableFrom(view.getClass())) {
                    return (T) view;
                }
            }
        }
        return null;
    }

    public static <T> List<T> findChildrenByClass(ViewGroup root, Class clazz) {
        List<T> ret = new ArrayList<>();
        for (int i = 0; i < root.getChildCount(); i++) {
            View view = root.getChildAt(i);
            if (clazz.isAssignableFrom(view.getClass())) {
                ret.add((T) view);
            }
        }
        return ret;
    }
}