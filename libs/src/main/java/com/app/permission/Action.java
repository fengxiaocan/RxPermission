
package com.app.permission;

public interface Action<T> {

    /**
     * An action.
     *
     * @param data the data.
     */
    void onAction(T data);
}