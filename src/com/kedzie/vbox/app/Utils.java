package com.kedzie.vbox.app;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import android.content.Context;
import android.content.IntentFilter;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

/**
 * Android Utilities
 * @apiviz.stereotype utility
 */
public class Utils {

	public static int getIntPreference(Context ctx, String name) {
		return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(ctx).getString(name, ""));
	}
	
	public static boolean getBooleanPreference(Context ctx, String name) {
		return PreferenceManager.getDefaultSharedPreferences(ctx).getBoolean(name, false);
	}
	
	public static String getStringPreference(Context ctx, String name) {
		return PreferenceManager.getDefaultSharedPreferences(ctx).getString(name, "");
	}
	
	/**
	 * Show {@link Toast} long notification with {@link String#format}
	 * @param ctx message {@link Context}
	 * @param msg Message to show
	 * @param formatting params
	 */
	public static void toastLong(Context ctx, String msg, Object...params) {
		Toast.makeText(ctx, isEmpty(params) ? msg : String.format(msg, params), Toast.LENGTH_LONG).show();
	}
	
	/**
	 * Show {@link Toast} short notification
	 * @param ctx message {@link Context}
	 * @param msg Message to show
	 */
	public static void toastShort(Context ctx, String msg, Object...params) {
		Toast.makeText(ctx, isEmpty(params) ? msg : String.format(msg, params), Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * Check if String is <code>null</code> or empty string
	 * @param s    the string
	 * @return     <code>true</code> if empty string or null, <code>false</code> otherwise
	 */
	public static boolean isEmpty(String s) {
		return s==null || s.equals("");
	}
	
	/**
     * Check if array is <code>null</code> or empty
     * @param array    the array
     * @return              <code>true</code> if empty or null, <code>false</code> otherwise
     */
	public static boolean isEmpty(Object []array) {
		return array==null || array.length==0;
	}
	
	public static String arrayToString(Object []array) {
		StringBuilder sb = new StringBuilder("{ ");
		for(int i=0; i<array.length; i++) {
			sb.append(array[i].toString());
			if(i<array.length-1)	sb.append(", ");
		}
		return sb.append(" }").toString();
	}
	
	/**
     * Get type parameter of Generic Type
     * @param genericType the generic {@link Type}
     * @param index which parameter
     * @return type parameter
     */
    public static Class<?> getTypeParameter(Type genericType, int index) {
        return (Class<?>)((ParameterizedType)genericType).getActualTypeArguments()[index];
    }
	
	/**
	 * Get first type parameter of Generic Type
	 * @param genericType the generic {@link Type}
	 * @return type parameter
	 */
	public static Class<?> getTypeParameter(Type genericType) {
		return getTypeParameter(genericType, 0);
	}
	
    /**
     * Show a DialogFragment with Back Stack
     * @param manager   FragmentManager
     * @param tag           tag for Fragment
     * @param dialog        the DialogFragment implementation
     */
    public static void showDialog(FragmentManager manager, String tag, DialogFragment dialog) {
        FragmentTransaction tx = manager.beginTransaction();
        Fragment prev = manager.findFragmentByTag(tag);
        if(prev!=null)
            tx.remove(prev);
        tx.addToBackStack(null);
        dialog.show(tx, tag);
    }
    
    /**
     * Create an {@link IntentFilter} for multiple actions
     * @param actions   accepted actions
     * @return      the {@link IntentFilter}
     */
    public static IntentFilter createIntentFilter(String...actions) {
        IntentFilter filter = new IntentFilter();
        for(String action : actions)
            filter.addAction(action);
        return filter;
    }
}
